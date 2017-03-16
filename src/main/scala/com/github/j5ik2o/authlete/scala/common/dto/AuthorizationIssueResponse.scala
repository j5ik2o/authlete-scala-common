package com.github.j5ik2o.authlete.scala.common.dto

case class AuthorizationIssueResponse(
  resultCode: String,
  resultMessage: String,
  action: AuthorizationResponse.Action.Value,
  responseContent: Option[String],
  accessToken: Option[String],
  accessTokenExpiresAt: Long,
  accessTokenDuration: Long,
  idToken: Option[String],
  authorizationCode: Option[String]
)
    extends AbstractApiResponse {

  lazy val summary: String =
    AuthorizationIssueResponse.summaryFormat
      .format(
        action,
        responseContent.orNull,
        accessToken.orNull,
        accessTokenExpiresAt,
        accessTokenDuration,
        idToken.orNull,
        authorizationCode.orNull
      )

}

object AuthorizationIssueResponse {

  object Action extends Enumeration {
    val InternalServerError, BadRequest, Location, Form = Value
  }

  private val summaryFormat =
    "action=%s, responseContent=%s, accessToken=%s, accessTokenExpiresAt=%d," +
      " accessTokenDuration=%d, idToken=%s, authorizationCode=%s"
}
