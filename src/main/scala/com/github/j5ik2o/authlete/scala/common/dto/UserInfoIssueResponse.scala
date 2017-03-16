package com.github.j5ik2o.authlete.scala.common.dto

case class UserInfoIssueResponse(
    action: UserInfoIssueResponse.Action.Value,
    responseContent: Option[String]
) {
  lazy val summary: String = UserInfoIssueResponse.summaryFormat
    .format(action, responseContent)
}

object UserInfoIssueResponse {

  object Action extends Enumeration {
    val InternalServerError, BadRequest, Unauthorized, Forbidden, Json, Jwt = Value
  }

  private val summaryFormat = "action=%s, responseContent=%s"

}
