package com.github.j5ik2o.authlete.scala.common.dto

import com.github.j5ik2o.authlete.scala.common.`type`.GrantType

case class TokenCreateRequest(
  grantType: Option[GrantType.Value],
  clientId: Long,
  subject: Option[String],
  scopes: Seq[String],
  accessTokenDuration: Long,
  refreshTokenDuration: Long,
  properties: Seq[Property]
)

