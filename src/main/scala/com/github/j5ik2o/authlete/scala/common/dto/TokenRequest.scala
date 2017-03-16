package com.github.j5ik2o.authlete.scala.common.dto

case class TokenRequest(
    parameters: Option[String],
    clientId: Option[String],
    clientSecret: Option[String],
    properties: Seq[Property]
) {

}

