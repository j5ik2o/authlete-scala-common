package com.github.j5ik2o.authlete.scala.common.`type`

import io.circe.{ Decoder, Encoder }

object Sns extends Enumeration {

  val Facebook = Value(1, "facebook")

}

object SnsJsonImplicits {

  implicit val SnsJsonEncoder: Encoder[Sns.Value] = Encoder.enumEncoder(Sns)
  implicit val SnsJsonDecoder: Decoder[Sns.Value] = Decoder.enumDecoder(Sns)

}
