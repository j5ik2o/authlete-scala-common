package com.github.j5ik2o.authlete.scala.common.dto

case class UserInfoIssueRequest(
  token: Option[String],
  claims: Option[String],
  sub: Option[String]
)

