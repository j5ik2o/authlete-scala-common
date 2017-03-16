package com.github.j5ik2o.authlete.scala.common.dto

case class Address(
  formatted: Option[String],
  streetAddress: Option[String],
  locality: Option[String],
  region: Option[String],
  postalCode: Option[String],
  country: String
)

object Address {

}

