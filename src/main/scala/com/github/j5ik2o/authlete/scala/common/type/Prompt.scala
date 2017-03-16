package com.github.j5ik2o.authlete.scala.common.`type`

import io.circe.{ Decoder, Encoder }

object Prompt extends Enumeration {

  val None = Value(0, "none")
  val Login = Value(1, "login")
  val Consent = Value(2, "consent")
  val SelectAccount = Value(3, "select_account")

}

object PromptJsonImplicits {

  implicit val PromptJsonEncoder: Encoder[Prompt.Value] = Encoder.enumEncoder(Prompt)
  implicit val PromptJsonDecoder: Decoder[Prompt.Value] = Decoder.enumDecoder(Prompt)

}