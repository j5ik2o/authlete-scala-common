package com.github.j5ik2o.authlete.scala.common.dto

import com.github.j5ik2o.authlete.scala.common.`type`.Sns

case class DeveloperAuthenticationCallbackRequest(
  serviceApiKey: Long,
  id: Option[String],
  password: Option[String],
  sns: Option[Sns.Value],
  accessToken: Option[String],
  refreshToken: Option[String],
  expiresIn: Long,
  rawTokenResponse: Option[String]
)

