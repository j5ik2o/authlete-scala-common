package com.github.j5ik2o.authlete.scala.common.dto

import com.github.j5ik2o.authlete.scala.common.`type`.Plan

case class ServiceCreatableResponse(
  creatable: Boolean,
  count: Int,
  limit: Int,
  plan: Plan.Value
)

