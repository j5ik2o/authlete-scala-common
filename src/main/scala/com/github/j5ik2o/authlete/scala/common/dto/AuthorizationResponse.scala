package com.github.j5ik2o.authlete.scala.common.dto

import com.github.j5ik2o.authlete.scala.common.`type`.{ Display, Prompt }
import io.circe.{ Decoder, Encoder }

case class AuthorizationResponse(
  resultCode: String,
  resultMessage: String,
  action: AuthorizationResponse.Action.Value,
  service: Option[Service],
  client: Option[Client],
  display: Option[Display.Value],
  maxAge: Int,
  scopes: Seq[Scope],
  uiLocales: Seq[String],
  claimsLocales: Seq[String],
  claims: Seq[String],
  acrEssential: Boolean,
  acrs: Seq[String],
  subject: Option[String],
  loginHint: Option[String],
  lowestPrompt: Option[Prompt.Value],
  prompts: Seq[Prompt.Value],
  responseContent: Option[String],
  ticket: Option[String]
)
    extends AbstractApiResponse {

  lazy val summarize: String =
    AuthorizationResponse.summaryFormat.format(
      ticket,
      action,
      client.map(_.serviceNumber).getOrElse(0),
      client.map(_.clientId).getOrElse(0),
      client.flatMap(_.clientSecret),
      client.flatMap(_.clientType),
      client.flatMap(_.developer),
      display,
      maxAge,
      AuthorizationResponse.listScopeNames(scopes),
      AuthorizationResponse.join(uiLocales),
      AuthorizationResponse.join(claimsLocales),
      AuthorizationResponse.join(claims),
      acrEssential,
      AuthorizationResponse.join(acrs),
      subject,
      loginHint,
      lowestPrompt,
      AuthorizationResponse.listPrompts(prompts)
    )

}

object AuthorizationResponse {

  object Action extends Enumeration {
    val BadRequest = Value("BAD_REQUEST")
    val Location = Value("LOCATION")
    val Form = Value("FORM")
    val NoInteraction = Value("NO_INTERACTION")
    val Interaction = Value("INTERACTION")
  }

  implicit val ActionJsonEncoder: Encoder[Action.Value] = Encoder.enumEncoder(Action)
  implicit val ActionJsonDecoder: Decoder[Action.Value] = Decoder.enumDecoder(Action)

  private def listScopeNames(scopes: Seq[Scope]) = {
    scopes.map(_.name).mkString(" ")
  }

  private def listPrompts(prompts: Seq[Prompt.Value]) = {
    val promptNames = prompts.map(_.toString.toLowerCase)
    join(promptNames)
  }

  private def join(strings: Seq[String]): String = strings.mkString(" ")

  private val summaryFormat =
    "ticket=%s, action=%s, serviceNumber=%d, clientNumber=%d, clientId=%d, clientSecret=%s, clientType=%s, developer=%s, display=%s, maxAge=%d, " + "scopes=%s, uiLocales=%s, claimsLocales=%s, claims=%s, acrEssential=%s, " + "acrs=%s, subject=%s, loginHint=%s, lowestPrompt=%s, prompts=%s"
}
