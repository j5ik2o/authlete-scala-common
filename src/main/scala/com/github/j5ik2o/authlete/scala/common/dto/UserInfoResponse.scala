package com.github.j5ik2o.authlete.scala.common.dto

case class UserInfoResponse(
    action: UserInfoResponse.Action.Value,
    clientId: Long,
    subject: Option[String],
    scopes: Seq[String],
    claims: Seq[String],
    token: Option[String],
    responseContent: Option[String]
) {

  lazy val summary: String = UserInfoResponse.summaryFormat
    .format(action, clientId, subject, scopes.mkString(" "), claims.mkString(" "), token)

}

object UserInfoResponse {

  object Action extends Enumeration {
    val InternalServerError, BadRequest, Unauthorized, Forbidden, Ok = Value
  }

  private val summaryFormat = "action=%s, clientId=%d, subject=%s, scopes=%s, claims=%s, " + "accessToken=%s"

}