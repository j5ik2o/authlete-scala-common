package com.github.j5ik2o.authlete.scala.common.dto

case class RevocationRequest(
  parameters: Option[String],
  clientId: Option[String],
  clientSecret: Option[String]
)

