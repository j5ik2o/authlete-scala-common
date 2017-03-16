package com.github.j5ik2o.authlete.scala.common.dto

case class AuthorizationFailRequest(
  ticket: Option[String],
  reason: Option[AuthorizationFailRequest.Reason.Value],
  description: Option[String]
)

object AuthorizationFailRequest {

  object Reason extends Enumeration {
    val Unkown, NotLoggedIn, MaxAgeNotSupported, ExceedsMaxAge, DifferentSubject, AcrNotSatisfied, Denied, ServerError, NotAuthenticated = Value
  }

}
