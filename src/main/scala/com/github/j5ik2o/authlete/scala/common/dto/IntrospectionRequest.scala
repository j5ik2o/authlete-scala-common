package com.github.j5ik2o.authlete.scala.common.dto

case class IntrospectionRequest(
  token: Option[String],
  scopes: Seq[String],
  subject: Option[String]
)

