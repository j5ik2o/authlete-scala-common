package com.github.j5ik2o.authlete.scala.common.dto

case class AuthorizationIssueRequest(
  ticket: Option[String],
  subject: Option[String],
  sub: Option[String],
  authTime: Long,
  acr: Option[String],
  claims: Option[String],
  properties: Seq[Property],
  scopes: Seq[String]
)

