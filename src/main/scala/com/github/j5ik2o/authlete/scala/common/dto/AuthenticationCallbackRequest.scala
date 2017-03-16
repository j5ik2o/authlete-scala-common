package com.github.j5ik2o.authlete.scala.common.dto

import com.github.j5ik2o.authlete.scala.common.`type`.Sns

case class AuthenticationCallbackRequest(
  serviceApiKey: Long,
  clientId: Long,
  id: Option[String],
  password: Option[String],
  claims: Seq[String],
  claimsLocales: Seq[String],
  sns: Option[Sns.Value],
  accessToken: Option[String],
  refreshToken: Option[String],
  expiresIn: Long,
  rawTokenResponse: Option[String]
)

