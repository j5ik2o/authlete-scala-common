package com.github.j5ik2o.authlete.scala.common.`type`

import io.circe.{ Decoder, Encoder }

object HashAlg extends Enumeration {
  val Sha256, Sha384, Sha512 = Value

}

object HashAlgJsonImplicits {

  implicit val HashAlgJsonEncoder: Encoder[HashAlg.Value] = Encoder.enumEncoder(HashAlg)
  implicit val HashAlgJsonDecoder: Decoder[HashAlg.Value] = Decoder.enumDecoder(HashAlg)

}
