package com.github.j5ik2o.authlete.scala.common.api

import scala.concurrent.duration._

case class ApiConfig(host: String, port: Option[Int] = None, timeoutForToStrict: FiniteDuration = 3 seconds)

