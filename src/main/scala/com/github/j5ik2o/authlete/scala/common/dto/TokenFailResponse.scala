package com.github.j5ik2o.authlete.scala.common.dto

case class TokenFailResponse(
  resultCode: String,
  resultMessage: String,
  action: TokenFailResponse.Action.Value,
  responseContent: Option[String]
)
    extends AbstractApiResponse

object TokenFailResponse {

  object Action extends Enumeration {
    val InternalServerError, BadRequest = Value
  }

}

