package com.github.j5ik2o.authlete.scala.common.dto

case class AuthenticationCallbackResponse(
  authenticated: Boolean,
  subject: Option[String],
  claims: Option[String]
)

