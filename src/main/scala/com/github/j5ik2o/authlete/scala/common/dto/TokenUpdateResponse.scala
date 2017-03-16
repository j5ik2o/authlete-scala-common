package com.github.j5ik2o.authlete.scala.common.dto

case class TokenUpdateResponse(
    action: TokenUpdateResponse.Action.Value,
    accessToken: Option[String],
    accessTokenExpiresAt: Long,
    scopes: Seq[String],
    properties: Seq[Property]
) {

  lazy val summary: String = TokenUpdateResponse.summaryFormat
    .format(action, accessToken, accessTokenExpiresAt, scopes.mkString(" "))

}

object TokenUpdateResponse {

  object Action extends Enumeration {
    val InternalServerError, BadRequest, Forbidden, NotFound, Ok = Value
  }

  private val summaryFormat = "action=%s, accessToken=%s, accessTokenExpiresAt=%d, scopes=%s"
}
