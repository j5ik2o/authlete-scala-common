package com.github.j5ik2o.authlete.scala.common.dto

case class AuthorizationFailResponse(
    action: AuthorizationFailResponse.Action.Value,
    responseContent: Option[String]
) {

  lazy val summary = AuthorizationFailResponse.summaryFormat
    .format(action, responseContent)
}

object AuthorizationFailResponse {

  object Action extends Enumeration {
    val InternalServerError, BadRequest, Location, Form = Value
  }

  private val summaryFormat = "action=%s, responseContent=%s"

}
