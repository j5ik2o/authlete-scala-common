package com.github.j5ik2o.authlete.scala.common.dto

import com.github.j5ik2o.authlete.scala.common.`type`.GrantType

case class TokenCreateResponse(
    resultCode: String,
    resultMessage: String,
    action: TokenCreateResponse.Action.Value,
    grantType: Option[GrantType.Value],
    clientId: Long,
    subject: Option[String],
    scopes: Seq[String],
    accessToken: Option[String],
    tokenType: Option[String],
    expiresIn: Long,
    expiresAt: Long,
    refreshToken: Option[String],
    properties: Seq[Property]
) extends AbstractApiResponse {
  lazy val summary: String = TokenCreateResponse.summaryFormat
    .format(action, grantType, clientId, subject, scopes.mkString(" "),
      accessToken, tokenType, expiresIn, expiresAt, refreshToken)
}

object TokenCreateResponse {

  object Action extends Enumeration {
    val InternalServerError, BadRequest, Forbidden, Ok = Value
  }

  private val summaryFormat = "action=%s, grantType=%s, clientId=%d, subject=%s, scopes=%s, " +
    "accessToken=%s, tokenType=%s, expiresIn=%d, expiresAt=%d, refreshToken=%s"

}