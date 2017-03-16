package com.github.j5ik2o.authlete.scala.common.dto

case class TokenFailRequest(
  ticket: Option[String],
  reason: Option[TokenFailRequest.Reason.Value]
)

object TokenFailRequest {

  object Reason extends Enumeration {
    val Unknown, InvalidResourceOwnerCredentials = Value
  }

}
