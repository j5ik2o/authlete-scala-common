package com.github.j5ik2o.authlete.scala.common.`type`

import io.circe.{ Decoder, Encoder }

object ClaimType extends Enumeration {
  val Normal = Value(1, "normal")
  val Aggregated = Value(2, "aggregated")
  val Distributed = Value(3, "distributed")

}

object ClaimTypeJsonImplicits {

  implicit val ClaimTypeJsonEncoder: Encoder[ClaimType.Value] = Encoder.enumEncoder(ClaimType)
  implicit val ClaimTypeJsonDecoder: Decoder[ClaimType.Value] = Decoder.enumDecoder(ClaimType)

}
