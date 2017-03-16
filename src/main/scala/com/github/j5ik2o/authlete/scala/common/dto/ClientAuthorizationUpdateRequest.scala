package com.github.j5ik2o.authlete.scala.common.dto

case class ClientAuthorizationUpdateRequest(
  subject: Option[String],
  scopes: Seq[String]
)
