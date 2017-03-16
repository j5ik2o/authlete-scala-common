package com.github.j5ik2o.authlete.scala.common.dto

import com.github.j5ik2o.authlete.scala.common.`type`.Sns
import io.circe.{ Decoder, Encoder, Json }
import io.circe.syntax._

case class SnsCredentials(
  sns: Option[Sns.Value],
  apiKey: Option[String],
  apiSecret: Option[String]
)

object SnsCredentials {

  import com.github.j5ik2o.authlete.scala.common.`type`.SnsJsonImplicits._

  implicit val snsCredentialsJsonEncoder: Encoder[SnsCredentials] =
    Encoder.instance { v =>
      Json.obj(
        "sns" -> v.sns.asJson,
        "apiKey" -> v.apiKey.asJson,
        "apiSecret" -> v.apiSecret.asJson
      )
    }

  implicit val snsCredentialsJsonDecoder: Decoder[SnsCredentials] =
    Decoder.instance { hcursor =>
      for {
        sns <- hcursor.get[Option[Sns.Value]]("sns").right
        apiKey <- hcursor.get[Option[String]]("apiKey").right
        apiSecret <- hcursor.get[Option[String]]("apiSecret").right
      } yield SnsCredentials(sns, apiKey, apiSecret)
    }

}
