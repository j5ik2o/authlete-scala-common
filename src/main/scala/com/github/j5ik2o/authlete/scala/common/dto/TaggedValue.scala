package com.github.j5ik2o.authlete.scala.common.dto

import io.circe.syntax._
import io.circe.{ Decoder, Encoder, Json }

case class TaggedValue(tag: Option[String], value: Option[String])

object TaggedValue {

  implicit val TaggedValueJsonEncoder: Encoder[TaggedValue] = Encoder.instance(v =>
    Json.obj(
      "tag" -> v.tag.asJson,
      "value" -> v.value.asJson
    ))

  implicit val TaggedValueJsonDecoder: Decoder[TaggedValue] = Decoder.instance { hcursor =>
    for {
      tag <- hcursor.get[Option[String]]("tag").right
      value <- hcursor.get[Option[String]]("value").right
    } yield TaggedValue(tag, value)
  }

}
