package com.github.j5ik2o.authlete.scala.common.`type`

import io.circe.{ Decoder, Encoder }

object Display extends Enumeration {
  val Page = Value(1, "page")
  val Popup = Value(2, "popup")
  val Touch = Value(3, "touch")
  val Wap = Value(94, "wap")

}

object DisplayJsonImplicits {

  implicit val DisplayJsonEncoder: Encoder[Display.Value] = Encoder.enumEncoder(Display)
  implicit val DisplayJsonDecoder: Decoder[Display.Value] = Decoder.enumDecoder(Display)

}