package com.github.j5ik2o.authlete.scala.common.dto

case class IntrospectionResponse(
    resultCode: String,
    resultMessage: String,
    action: IntrospectionResponse.Action.Value,
    clientId: Long,
    subject: Option[String],
    scopes: Seq[String],
    existent: Boolean,
    usable: Boolean,
    sufficient: Boolean,
    refreshable: Boolean,
    responseContent: Option[String],
    expiresAt: Long,
    properties: Seq[Property]
) extends AbstractApiResponse {
  private def buildScopes = scopes.mkString(" ")

  private def buildProperties =
    properties.map(e => s"${e.key}=${e.value}").mkString("[", ",", "]")

  lazy val summary: String = IntrospectionResponse.summaryFormat
    .format(
      action,
      clientId,
      subject,
      existent,
      usable,
      sufficient,
      refreshable,
      expiresAt,
      buildScopes,
      buildProperties
    )

}

object IntrospectionResponse {

  object Action extends Enumeration {
    val InternalServerError, BadRequest, Unauthorized, Forbidden, Ok = Value
  }

  private val summaryFormat = "action=%s, clientId=%d, subject=%s, existent=%s, " +
    "usable=%s, sufficient=%s, refreshable=%s, expiresAt=%d, " + "scopes=%s, properties=%s"

}
