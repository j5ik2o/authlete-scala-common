package com.github.j5ik2o.authlete.scala.common.`type`

import io.circe.{ Decoder, Encoder }

object ApplicationType extends Enumeration {

  val Web = Value(1, "web")
  val Native = Value(2, "native")

}

object ApplicationTypeJsonImplicits {

  implicit val ApplicationTypeJsonEncoder: Encoder[ApplicationType.Value] = Encoder.enumEncoder(ApplicationType)
  implicit val ApplicationTypeJsonDecoder: Decoder[ApplicationType.Value] = Decoder.enumDecoder(ApplicationType)

}

