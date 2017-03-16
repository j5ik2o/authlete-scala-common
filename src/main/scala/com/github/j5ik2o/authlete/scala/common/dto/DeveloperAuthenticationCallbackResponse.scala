package com.github.j5ik2o.authlete.scala.common.dto

case class DeveloperAuthenticationCallbackResponse(
  authenticated: Boolean,
  subject: Option[String],
  displayName: Option[String]
)

