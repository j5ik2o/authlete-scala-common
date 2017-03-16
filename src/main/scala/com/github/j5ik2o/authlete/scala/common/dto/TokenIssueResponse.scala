package com.github.j5ik2o.authlete.scala.common.dto

case class TokenIssueResponse(
  resultCode: String,
  resultMessage: String,
  action: TokenIssueResponse.Action.Value,
  responseContent: Option[String],
  accessToken: Option[String],
  accessTokenExpiresAt: Long,
  accessTokenDuration: Long,
  refreshToken: Option[String],
  refreshTokenExpiresAt: Long,
  refreshTokenDuration: Long
)
    extends AbstractApiResponse {

}

object TokenIssueResponse {

  object Action extends Enumeration {
    val InternalServerError, Ok = Value
  }
}
