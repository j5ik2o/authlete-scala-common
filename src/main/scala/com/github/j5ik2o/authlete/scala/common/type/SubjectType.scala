package com.github.j5ik2o.authlete.scala.common.`type`

import io.circe.{ Decoder, Encoder }

object SubjectType extends Enumeration {

  val Public = Value(1, "public")
  val Pairwise = Value(2, "pairwise")

}

object SubjectTypeJsonImplicits {

  implicit val SubjectTypeJsonEncoder: Encoder[SubjectType.Value] = Encoder.enumEncoder(SubjectType)
  implicit val SubjectTypeJsonDecoder: Decoder[SubjectType.Value] = Decoder.enumDecoder(SubjectType)

}

