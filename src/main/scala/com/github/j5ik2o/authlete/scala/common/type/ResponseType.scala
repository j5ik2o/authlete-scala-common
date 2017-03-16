package com.github.j5ik2o.authlete.scala.common.`type`

import io.circe.{ Decoder, Encoder }

sealed trait ResponseType {
  val valueAsNumber: Short
  val valueAsString: String
  val valueAsFlags: Int
}

object ResponseTypeJsonImplicits {

  implicit val ResponseTypeEncoder: Encoder[ResponseType] = Encoder[String].contramap(_.valueAsString)
  implicit val ResponseTypeDecoder: Decoder[ResponseType] = Decoder[String].map(ResponseType.valueOf)

}

object ResponseType {

  val values = Set(None, Code, Token, IdToken, CodeToken, IdTokenToken, CodeIdTokenToken)

  def valueOf(name: String): ResponseType = {
    values.find(_.valueAsString == name).get
  }

  case object None extends ResponseType {
    override val valueAsNumber = 0.toShort
    override val valueAsString = "none"
    override val valueAsFlags = 0x0
  }

  case object Code extends ResponseType {
    override val valueAsNumber = 1.toShort
    override val valueAsString = "code"
    override val valueAsFlags = 0x1
  }

  case object Token extends ResponseType {
    override val valueAsNumber = 2.toShort
    override val valueAsString = "token"
    override val valueAsFlags = 0x2
  }

  case object IdToken extends ResponseType {
    override val valueAsNumber = 3.toShort
    override val valueAsString = "id_token"
    override val valueAsFlags = 0x4
  }

  case object CodeToken extends ResponseType {
    override val valueAsNumber = 4.toShort
    override val valueAsString = "code token"
    override val valueAsFlags = 0x3
  }

  case object IdCodeToken extends ResponseType {
    override val valueAsNumber = 5.toShort
    override val valueAsString = "code id_token"
    override val valueAsFlags = 0x3
  }

  case object IdTokenToken extends ResponseType {
    override val valueAsNumber = 6.toShort
    override val valueAsString = "id_token token"
    override val valueAsFlags = 0x6
  }

  case object CodeIdTokenToken extends ResponseType {
    override val valueAsNumber = 7.toShort
    override val valueAsString = "code id_token token"
    override val valueAsFlags = 0x7
  }

}
