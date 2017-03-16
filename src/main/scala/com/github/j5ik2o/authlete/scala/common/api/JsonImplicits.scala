package com.github.j5ik2o.authlete.scala.common.api

import java.net.URI

import io.circe.{ Decoder, Encoder }

object JsonImplicits {
  implicit val uriEncoder: Encoder[URI] = Encoder[String].contramap(_.toString)
  implicit val uriDecoder: Decoder[URI] = Decoder[String].map(URI.create)
}
