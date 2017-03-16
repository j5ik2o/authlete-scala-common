package com.github.j5ik2o.authlete.scala.common.dto

case class TokenResponse(
  resultCode: String,
  resultMessage: String,
  action: TokenResponse.Action.Value,
  responseContent: Option[String],
  username: Option[String],
  password: Option[String],
  ticket: Option[String],
  accessToken: Option[String],
  accessTokenExpiresAt: Long,
  accessTokenDuration: Long,
  refreshToken: Option[String],
  refreshTokenExpiresAt: Long,
  refreshTokenDuration: Long,
  idToken: Option[String]
)
    extends AbstractApiResponse {

  lazy val summary: String = TokenResponse.summaryFormat
    .format(action, username, password, ticket, responseContent,
      accessToken, accessTokenExpiresAt, accessTokenDuration,
      refreshToken, refreshTokenExpiresAt, refreshTokenDuration,
      idToken)

}

object TokenResponse {

  object Action extends Enumeration {
    val InvalidClient, InternalServerError, BadRequest, Password, Ok = Value
  }

  private val summaryFormat = "action=%s, username=%s, password=%s, ticket=%s, responseContent=%s, " + "accessToken=%s, accessTokenExpiresAt=%d, accessTokenDuration=%d, " + "refreshToken=%s, refreshTokenExpiresAt=%d, refreshTokenDuration=%d, " + "idToken=%s"
}
