package com.github.j5ik2o.authlete.scala.common.dto

case class TokenIssueRequest(
    ticket: Option[String],
    subject: Option[String],
    properties: Seq[Property]
) {

}

