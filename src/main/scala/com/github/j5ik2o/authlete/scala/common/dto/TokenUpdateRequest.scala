package com.github.j5ik2o.authlete.scala.common.dto

case class TokenUpdateRequest(
  accessToken: Option[String],
  accessTokenExpiresAt: Long,
  scopes: Seq[String],
  properties: Seq[Property]
)

