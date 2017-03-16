package com.github.j5ik2o.authlete.scala.common.api

case class AuthleteApiException(
  message: Option[String],
  cause: Option[Throwable],
  statusCode: Option[Int],
  statusMessage: Option[String],
  responseBody: Option[String],
  responseHeaders: Map[String, Seq[String]]
)
    extends Exception(message.orNull, cause.orNull)

object AuthleteApiException {

  def withMessage(message: Option[String]): AuthleteApiException =
    new AuthleteApiException(message, None, None, None, None, Map.empty)

  def withCause(cause: Option[Throwable]): AuthleteApiException =
    new AuthleteApiException(None, cause, None, None, None, Map.empty)

  def apply(statusCode: Int, statusMessage: String, responseBody: String): AuthleteApiException =
    new AuthleteApiException(None, None, Some(statusCode), Some(statusMessage), Some(responseBody), Map.empty)

  def apply(statusCode: Int, statusMessage: String, responseBody: String, responseHeaders: Map[String, Seq[String]]): AuthleteApiException =
    new AuthleteApiException(None, None, Some(statusCode), Some(statusMessage), Some(responseBody), responseHeaders)

  def apply(message: String, statusCode: Int, statusMessage: String, responseBody: String): AuthleteApiException =
    new AuthleteApiException(Some(message), None, Some(statusCode), Some(statusMessage), Some(responseBody), Map.empty)

  def apply(cause: Throwable, statusCode: Int, statusMessage: String, responseBody: String, responseHeaders: Map[String, Seq[String]]): AuthleteApiException =
    new AuthleteApiException(None, Some(cause), Some(statusCode), Some(statusMessage), Some(responseBody), responseHeaders)

  def apply(cause: Throwable, statusCode: Int, statusMessage: String, responseBody: String): AuthleteApiException =
    new AuthleteApiException(None, Some(cause), Some(statusCode), Some(statusMessage), Some(responseBody), Map.empty)

  def apply(message: String, statusCode: Int, statusMessage: String, responseBody: String, responseHeaders: Map[String, Seq[String]]): AuthleteApiException =
    new AuthleteApiException(Some(message), None, Some(statusCode), Some(statusMessage), Some(responseBody), responseHeaders)

  def apply(message: String, cause: Throwable, statusCode: Int, statusMessage: String, responseBody: String, responseHeaders: Map[String, Seq[String]]): AuthleteApiException =
    new AuthleteApiException(Some(message), Some(cause), Some(statusCode), Some(statusMessage), Some(responseBody), responseHeaders)

}

