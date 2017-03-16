package com.github.j5ik2o.authlete.scala.common.dto

case class ClientListResponse(
  start: Int,
  end: Int,
  developer: Option[String],
  totalCount: Int,
  clients: Seq[Client]
)

