package com.github.j5ik2o.authlete.scala.common.`type`

import io.circe.{ Decoder, Encoder }

object ClientType extends Enumeration {

  val Public = Value(1, "public")
  val Confidential = Value(2, "confidential")

}

object ClientTypeJsonImplicits {
  implicit val ClientTypeJsonEncoder: Encoder[ClientType.Value] = Encoder.enumEncoder(ClientType)
  implicit val ClientTypeJsonDecoder: Decoder[ClientType.Value] = Decoder.enumDecoder(ClientType)
}