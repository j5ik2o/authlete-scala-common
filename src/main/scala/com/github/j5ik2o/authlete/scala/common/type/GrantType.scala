package com.github.j5ik2o.authlete.scala.common.`type`

import io.circe.{ Decoder, Encoder }

object GrantType extends Enumeration {

  val AuthorizationCode = Value(1, "authorization_code")
  val Implicit = Value(2, "implicit")
  val Password = Value(3, "password")
  val ClientCredentials = Value(4, "client_credentials")
  val RefreshToken = Value(5, "refresh_token")

}

object GrantTypeJsonImplicits {

  implicit val GrantTypeJsonEncoder: Encoder[GrantType.Value] = Encoder.enumEncoder(GrantType)
  implicit val GrantTypeJsonDecoder: Decoder[GrantType.Value] = Decoder.enumDecoder(GrantType)

}
