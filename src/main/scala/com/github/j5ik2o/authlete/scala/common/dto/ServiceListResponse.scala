package com.github.j5ik2o.authlete.scala.common.dto

case class ServiceListResponse(
  start: Int,
  end: Int,
  totalCount: Int,
  services: Seq[Service]
)

