package com.github.j5ik2o.authlete.scala.common.`type`

import io.circe.{ Decoder, Encoder }

object ClientAuthMethod extends Enumeration {
  val None = Value(0, "none")
  val ClientSecretBasic = Value(1, "client_secret_basic")
  val ClientSecretJWT = Value(2, "client_secret_jwt")
  val PrivateKeyJWT = Value(3, "private_key_jwt")

}

object ClientAuthMethodJsonImplicits {

  implicit val ClientAuthMethodJsonEncoder: Encoder[ClientAuthMethod.Value] = Encoder.enumEncoder(ClientAuthMethod)
  implicit val ClientAuthMethodJsonDecoder: Decoder[ClientAuthMethod.Value] = Decoder.enumDecoder(ClientAuthMethod)

}
