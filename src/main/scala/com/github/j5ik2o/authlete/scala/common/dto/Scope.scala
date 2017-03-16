package com.github.j5ik2o.authlete.scala.common.dto

import io.circe.{ Decoder, Encoder, Json }
import io.circe.syntax._

case class Scope(name: Option[String], defaultEntry: Boolean, description: Option[String], descriptions: Option[String])

object Scope {

  def extractNames(scopes: Seq[Scope]): Seq[String] = {
    scopes.flatMap(_.name.map(Seq(_)).getOrElse(Seq.empty))
  }

  implicit val ScopeJsonEncoder: Encoder[Scope] = Encoder.instance { v =>
    Json.obj(
      "name" -> v.name.asJson,
      "defaultEntry" -> v.defaultEntry.asJson,
      "description" -> v.description.asJson,
      "descriptions" -> v.descriptions.asJson
    )
  }

  implicit val ScopeJsonDecoder: Decoder[Scope] = Decoder.instance { hcursor =>
    for {
      name <- hcursor.get[Option[String]]("name").right
      defaultEntry <- hcursor.get[Boolean]("defaultEntry").right
      description <- hcursor.get[Option[String]]("description").right
      descriptions <- hcursor.get[Option[String]]("descriptions").right
    } yield Scope(name, defaultEntry, description, descriptions)
  }

}