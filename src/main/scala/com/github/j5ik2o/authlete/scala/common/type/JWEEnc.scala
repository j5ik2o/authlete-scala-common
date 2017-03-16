package com.github.j5ik2o.authlete.scala.common.`type`

import io.circe.{ Decoder, Encoder }

object JWEEnc extends Enumeration {

  val A128CBC_HS256 = Value(1, "A128CBC-HS256")
  val A192CBC_HS384 = Value(2, "A192CBC-HS384")
  val A256CBC_HS512 = Value(3, "A256CBC-HS512")
  val A128GCM = Value(4, "A128GCM")
  val A192GCM = Value(5, "A192GCM")
  val A256GCM = Value(6, "A256GCM")

}

object JWEEncJsonImplicits {

  implicit val JWEEncJsonEncoder: Encoder[JWEEnc.Value] = Encoder.enumEncoder(JWEEnc)
  implicit val JWEEncsonDecoder: Decoder[JWEEnc.Value] = Decoder.enumDecoder(JWEEnc)

}

