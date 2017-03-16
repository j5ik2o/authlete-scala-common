package com.github.j5ik2o.authlete.scala.common.`type`

import io.circe.{ Decoder, Encoder }

object JWEAlg extends Enumeration {
  val RSA1_5 = Value(1, "RSA1_5")
  val RSA_OAEP = Value(2, "RSA-OAEP")
  val RSA_OAEP_256 = Value(3, "RSA-OEAP-256")
  val A128KW = Value(4, "A128KW")
  val A192KW = Value(5, "A192KW")
  val A256KW = Value(6, "A256KW")
  val DIR = Value(7, "dir")
  val ECDH_ES = Value(8, "ECDH-ES")
  val ECDH_ES_A128KW = Value(9, "ECDH-ES+A128KW")
  val ECDH_ES_A192KW = Value(10, "ECDH-ES+A192KW")
  val ECDH_ES_A256KW = Value(11, "ECDH-ES+A256KW")
  val A128GCMKW = Value(12, "A128GCMKW")
  val A192GCMKW = Value(13, "A192GCMKW")
  val A256GCMKW = Value(14, "A256GCMKW")
  val PBES2_HS256_A128KW = Value(15, "PBES2-HS256+A128KW")
  val PBES2_HS384_A192KW = Value(16, "PBES2-HS384+A192KW")
  val PBES2_HS512_A256KW = Value(17, "PBES2-HS512+A256KW")
}

object JWEAlgJsonImplicits {

  implicit val JWEAlgJsonEncoder: Encoder[JWEAlg.Value] = Encoder.enumEncoder(JWEAlg)
  implicit val JWEAlgJsonDecoder: Decoder[JWEAlg.Value] = Decoder.enumDecoder(JWEAlg)

}

