package com.github.j5ik2o.authlete.scala.common.api

import akka.http.scaladsl.marshalling.{ Marshaller, ToEntityMarshaller }
import akka.http.scaladsl.model.MediaTypes.`application/json`
import akka.http.scaladsl.model.{ HttpEntity, ResponseEntity }
import akka.http.scaladsl.unmarshalling.{ FromEntityUnmarshaller, Unmarshaller }
import akka.util.ByteString
import io.circe._
import io.circe.parser._

import scala.concurrent.duration.FiniteDuration

/**
 * Automatic to and from JSON marshalling/unmarshalling using an in-scope circe protocol.
 * The unmarshaller fails fast, throwing the first `Error` encountered.
 *
 * To use automatic codec derivation, user needs to import `io.circe.generic.auto._`.
 */
//object FailFastCirceSupport extends FailFastCirceSupport

/**
 * Automatic to and from JSON marshalling/unmarshalling using an in-scope circe protocol.
 * The unmarshaller fails fast, throwing the first `Error` encountered.
 *
 * To use automatic codec derivation import `io.circe.generic.auto._`.
 */
trait FailFastCirceSupport extends BaseCirceSupport with NoSpacesPrinter with FailFastUnmarshaller

/**
 * Automatic to and from JSON marshalling/unmarshalling using an in-scope circe protocol.
 * The unmarshaller accumulates all errors in the exception `Errors`.
 *
 * To use automatic codec derivation, user needs to import `io.circe.generic.auto._`.
 */
//object ErrorAccumulatingCirceSupport extends ErrorAccumulatingCirceSupport {
//  override val timeoutForToStrict: FiniteDuration = _
//}

/**
 * Automatic to and from JSON marshalling/unmarshalling using an in-scope circe protocol.
 * The unmarshaller accumulates all errors in the exception `Errors`.
 *
 * To use automatic codec derivation import `io.circe.generic.auto._`.
 */
trait ErrorAccumulatingCirceSupport
  extends BaseCirceSupport
  with NoSpacesPrinter
  with ErrorAccumulatingUnmarshaller

/**
 * Automatic to and from JSON marshalling/unmarshalling using an in-scope circe protocol.
 */
trait BaseCirceSupport {

  /**
   * Printer used in the JSON marshaller.
   */
  def printer: Printer

  /**
   * `Json` => HTTP entity
   *
   * @return marshaller for JSON value
   */
  implicit final val toEntityJsonMarshaller: ToEntityMarshaller[Json] =
    Marshaller.withFixedContentType(`application/json`) { json =>
      HttpEntity(`application/json`, printer.pretty(json))
    }

  /**
   * `A` => HTTP entity
   *
   * @tparam A type to encode
   * @return marshaller for any `A` value
   */
  implicit final def toEntityMarshaller[A: Encoder]: ToEntityMarshaller[A] =
    toEntityJsonMarshaller.compose(implicitly[Encoder[A]].apply)

  /**
   * HTTP entity => `Json`
   *
   * @return unmarshaller for `Json`
   */
  implicit final val fromEntityJsonUnmarshaller: FromEntityUnmarshaller[Json] =
    Unmarshaller.byteStringUnmarshaller
      .forContentTypes(`application/json`)
      .map {
        case ByteString.empty => throw Unmarshaller.NoContentException
        case data => jawn.parseByteBuffer(data.asByteBuffer).fold(throw _, identity)
      }

  /**
   * HTTP entity => `A`
   *
   * @tparam A type to decode
   * @return unmarshaller for `A`
   */
  implicit def fromEntityUnmarshaller[A: Decoder]: FromEntityUnmarshaller[A]

  val timeoutForToStrict: FiniteDuration

  implicit final val fromResponseEntityJsonUnmarshaller: Unmarshaller[ResponseEntity, Json] =
    Unmarshaller.withMaterializer[ResponseEntity, Json] { implicit ec => implicit mat => entity =>
      entity.toStrict(timeoutForToStrict).map(_.data.utf8String).map { v =>
        parse(v) match {
          case Left(e) =>
            throw e
          case Right(r) =>
            r
        }
      }
    }

  implicit def fromResponseEntityUnmarshaller[A: Decoder]: Unmarshaller[ResponseEntity, A] = {
    def decode(json: Json) = implicitly[Decoder[A]].decodeJson(json).fold(throw _, identity)
    fromResponseEntityJsonUnmarshaller.map(decode)
  }

}

/**
 * Mix-in this trait to fail on the first error during unmarshalling.
 */
trait FailFastUnmarshaller { this: BaseCirceSupport =>

  override implicit final def fromEntityUnmarshaller[A: Decoder]: FromEntityUnmarshaller[A] = {
    def decode(json: Json) = implicitly[Decoder[A]].decodeJson(json).fold(throw _, identity)
    fromEntityJsonUnmarshaller.map(decode)
  }
}

/**
 * Mix-in this trait to accumulate all errors during unmarshalling.
 */
trait ErrorAccumulatingUnmarshaller { this: BaseCirceSupport =>

  override implicit final def fromEntityUnmarshaller[A: Decoder]: FromEntityUnmarshaller[A] = {
    def decode(json: Json) =
      implicitly[Decoder[A]]
        .accumulating(json.hcursor)
        .fold(decodingFailure => throw Errors(decodingFailure), identity)
    fromEntityJsonUnmarshaller.map(decode)
  }
}

/**
 * Mix-in this trait to use a compact JSON printer during marshalling.
 */
trait NoSpacesPrinter {
  this: BaseCirceSupport =>

  override final def printer: Printer =
    Printer.noSpaces

}
