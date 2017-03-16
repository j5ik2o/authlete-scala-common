package com.github.j5ik2o.authlete.scala.common.dto

case class GrantedScopesGetResponse(
  serviceApiKey: Long,
  clientId: Long,
  subject: Option[String],
  latestGrantedScopes: Seq[String],
  mergedGrantedScopes: Seq[String],
  modifiedAt: Long
)

