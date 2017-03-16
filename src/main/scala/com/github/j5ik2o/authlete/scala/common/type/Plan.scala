package com.github.j5ik2o.authlete.scala.common.`type`

import io.circe.{ Decoder, Encoder }

object Plan extends Enumeration {

  val Free, Lite, Premium, Enterprise = Value

}

object PlanJsonImplicits {

  implicit val PlanJsonEncoder: Encoder[Plan.Value] = Encoder.enumEncoder(Plan)
  implicit val PlanyJsonDecoder: Decoder[Plan.Value] = Decoder.enumDecoder(Plan)

}

