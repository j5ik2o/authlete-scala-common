package com.github.j5ik2o.authlete.scala.common.dto

case class RevocationResponse(
  resultCode: String,
  resultMessage: String,
  action: RevocationResponse.Action.Value,
  responseContent: Option[String]
)
    extends AbstractApiResponse {

  lazy val summarize: String = RevocationResponse.summaryFormat
    .format(action, responseContent.orNull)

}

object RevocationResponse {

  object Action extends Enumeration {
    val InvalidClient, InternalServerError, BadRequest, Ok = Value
  }

  private val summaryFormat = "action=%s, responseContent=%s"

}