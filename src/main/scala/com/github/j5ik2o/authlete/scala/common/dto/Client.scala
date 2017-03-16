package com.github.j5ik2o.authlete.scala.common.dto

import java.net.URI

import com.github.j5ik2o.authlete.scala.common.`type`._
import io.circe.syntax._
import io.circe.{ Decoder, Encoder, Json }

case class JWSJWEParams(
  signAlg: Option[JWSAlg],
  encryptionAlg: Option[JWEAlg.Value],
  encryptionEnc: Option[JWEEnc.Value]
)

case class MultiParams[A](
  value: Option[A],
  values: Seq[TaggedValue]
)

case class Client(
  number: Int,
  serviceNumber: Int,
  developer: Option[String],
  clientId: Long,
  clientSecret: Option[String],
  clientType: Option[ClientType.Value],
  redirectUris: Seq[String],
  responseTypes: Seq[ResponseType],
  grantTypes: Seq[GrantType.Value],
  applicationType: Option[ApplicationType.Value],
  contacts: Seq[String],
  clientName: MultiParams[String],
  logoUri: MultiParams[URI],
  clientUri: MultiParams[URI],
  policyUri: MultiParams[URI],
  tosUri: MultiParams[URI],
  jwksUri: Option[URI],
  jwks: Option[String],
  sectorIdentifier: Option[URI],
  subjectType: Option[SubjectType.Value],
  idTokenJWSJWEParams: JWSJWEParams,
  userInfoJWSJWEParams: JWSJWEParams,
  requestJWSJWEParams: JWSJWEParams,
  tokenAuthMethod: Option[ClientAuthMethod.Value],
  tokenAuthSignAlg: Option[JWSAlg],
  defaultMaxAge: Int,
  defaultAcrs: Seq[String],
  authTimeRequired: Boolean,
  loginUri: Option[URI],
  requestUris: Seq[String],
  description: MultiParams[String],
  createdAt: Long,
  modifiedAt: Long
)

object Client {

  import ResponseTypeJsonImplicits._
  import ApplicationTypeJsonImplicits._
  import ClientAuthMethodJsonImplicits._
  import ClientTypeJsonImplicits._
  import GrantTypeJsonImplicits._
  import JWEAlgJsonImplicits._
  import JWEEncJsonImplicits._
  import SubjectTypeJsonImplicits._
  import com.github.j5ik2o.authlete.scala.common.api.JsonImplicits._

  implicit val ClientJsonEncoder: Encoder[Client] = Encoder.instance { v =>
    Json.obj(
      "number" -> v.number.asJson,
      "serviceNumber" -> v.serviceNumber.asJson,
      "developer" -> v.developer.asJson,
      "clientId" -> v.clientId.asJson,
      "clientSecret" -> v.clientSecret.asJson,
      "clientType" -> v.clientType.asJson,
      "redirectUris" -> v.redirectUris.asJson,
      "responseTypes" -> v.responseTypes.asJson,
      "grantTypes" -> v.grantTypes.asJson,
      "applicationType" -> v.applicationType.asJson,
      "contacts" -> v.contacts.asJson,
      "clientName" -> v.clientName.value.asJson,
      "clientNames" -> v.clientName.values.asJson,
      "logoUri" -> v.logoUri.value.asJson,
      "logoUris" -> v.logoUri.values.asJson,
      "clientUri" -> v.clientUri.value.asJson,
      "clientUris" -> v.clientUri.values.asJson,
      "policyUri" -> v.policyUri.value.asJson,
      "policyUris" -> v.policyUri.values.asJson,
      "tosUri" -> v.tosUri.value.asJson,
      "tosUris" -> v.tosUri.values.asJson,
      "jwksUri" -> v.jwksUri.asJson,
      "jwks" -> v.jwks.asJson,
      "sectorIdentifier" -> v.sectorIdentifier.asJson,
      "subjectType" -> v.subjectType.asJson,
      "idTokenSignAlg" -> v.idTokenJWSJWEParams.signAlg.asJson,
      "idTokenEncryptionAlg" -> v.idTokenJWSJWEParams.encryptionAlg.asJson,
      "idTokenEncryptionEnc" -> v.idTokenJWSJWEParams.encryptionEnc.asJson,
      "userInfoSignAlg" -> v.userInfoJWSJWEParams.signAlg.asJson,
      "userInfoEncryptionAlg" -> v.userInfoJWSJWEParams.encryptionAlg.asJson,
      "userInfoEncryptionEnc" -> v.userInfoJWSJWEParams.encryptionEnc.asJson,
      "requestInfoSignAlg" -> v.requestJWSJWEParams.signAlg.asJson,
      "requestInfoEncryptionAlg" -> v.requestJWSJWEParams.encryptionAlg.asJson,
      "requestInfoEncryptionEnc" -> v.requestJWSJWEParams.encryptionEnc.asJson,
      "tokenAuthMethod" -> v.tokenAuthMethod.asJson,
      "tokenAuthSignAlg" -> v.tokenAuthSignAlg.asJson,
      "defaultMaxAge" -> v.defaultMaxAge.asJson,
      "defaultAcrs" -> v.defaultAcrs.asJson,
      "authTimeRequired" -> v.authTimeRequired.asJson,
      "loginUri" -> v.loginUri.asJson,
      "requestUris" -> v.requestUris.asJson,
      "descripton" -> v.description.value.asJson,
      "descriptons" -> v.description.values.asJson,
      "createdAt" -> v.createdAt.asJson,
      "modifiedAt" -> v.modifiedAt.asJson
    )
  }

  implicit val ClientJsonDecoder: Decoder[Client] = Decoder.instance { hcursor =>
    for {
      number <- hcursor.get[Int]("number").right
      serviceNumber <- hcursor.get[Int]("serviceNumber").right
      developer <- hcursor.get[Option[String]]("developer").right
      clientId <- hcursor.get[Long]("clientId").right
      clientSecret <- hcursor.get[Option[String]]("clientSecret").right
      clientType <- hcursor.get[Option[ClientType.Value]]("clientType").right
      redirectUris <- hcursor.get[Seq[String]]("redirectUris").right
      responseTypes <- hcursor.get[Seq[ResponseType]]("responseTypes").right
      grantTypes <- hcursor.get[Seq[GrantType.Value]]("grantTypes").right
      applicationType <- hcursor.get[Option[ApplicationType.Value]]("applicationType").right
      contacts <- hcursor.get[Seq[String]]("contacts").right
      clientName <- hcursor.get[Option[String]]("clientName").right
      clientNames <- hcursor.get[Seq[TaggedValue]]("clientNames").right
      logoUri <- hcursor.get[Option[URI]]("logoUri").right
      logoUris <- hcursor.get[Seq[TaggedValue]]("logoUris").right
      clientUri <- hcursor.get[Option[URI]]("clientUri").right
      clientUris <- hcursor.get[Seq[TaggedValue]]("clientUris").right
      policyUri <- hcursor.get[Option[URI]]("policyUri").right
      policyUris <- hcursor.get[Seq[TaggedValue]]("policyUris").right
      tosUri <- hcursor.get[Option[URI]]("tosUri").right
      tosUris <- hcursor.get[Seq[TaggedValue]]("tosUris").right
      jwksUri <- hcursor.get[Option[URI]]("jwksUri").right
      jwks <- hcursor.get[Option[String]]("jwks").right
      sectorIdentifier <- hcursor.get[Option[URI]]("sectorIdentifier").right
      subjectType <- hcursor.get[Option[SubjectType.Value]]("subjectType").right
      idTokenSignAlg <- hcursor.get[Option[JWSAlg]]("idTokenSignAlg").right
      idTokenEncryptionAlg <- hcursor.get[Option[JWEAlg.Value]]("idTokenEncryptionAlg").right
      idTokenEncryptionEnc <- hcursor.get[Option[JWEEnc.Value]]("idTokenEncryptionEnc").right
      userInfoSignAlg <- hcursor.get[Option[JWSAlg]]("userInfoSignAlg").right
      userInfoEncryptionAlg <- hcursor.get[Option[JWEAlg.Value]]("userInfoEncryptionAlg").right
      userInfoEncryptionEnc <- hcursor.get[Option[JWEEnc.Value]]("userInfoEncryptionEnc").right
      requestSignAlg <- hcursor.get[Option[JWSAlg]]("requestSignAlg").right
      requestEncryptionAlg <- hcursor.get[Option[JWEAlg.Value]]("requestEncryptionAlg").right
      requestEncryptionEnc <- hcursor.get[Option[JWEEnc.Value]]("requestEncryptionEnc").right
      tokenAuthMethod <- hcursor.get[Option[ClientAuthMethod.Value]]("tokenAuthMethod").right
      tokenAuthSignAlg <- hcursor.get[Option[JWSAlg]]("tokenAuthSignAlg").right
      defaultMaxAge <- hcursor.get[Int]("defaultMaxAge").right
      defaultAcrs <- hcursor.get[Seq[String]]("defaultAcrs").right
      authTimeRequired <- hcursor.get[Boolean]("authTimeRequired").right
      loginUri <- hcursor.get[Option[URI]]("loginUri").right
      requestUris <- hcursor.get[Seq[String]]("requestUris").right
      descripton <- hcursor.get[Option[String]]("descripton").right
      descriptons <- hcursor.get[Seq[TaggedValue]]("descriptons").right
      createdAt <- hcursor.get[Long]("createdAt").right
      modifiedAt <- hcursor.get[Long]("modifiedAt").right
    } yield {
      new Client(
        number,
        serviceNumber,
        developer,
        clientId,
        clientSecret,
        clientType,
        redirectUris,
        responseTypes,
        grantTypes,
        applicationType,
        contacts,
        MultiParams(clientName, clientNames),
        MultiParams(logoUri, logoUris),
        MultiParams(clientUri, clientUris),
        MultiParams(policyUri, policyUris),
        MultiParams(tosUri, tosUris),
        jwksUri,
        jwks,
        sectorIdentifier,
        subjectType,
        JWSJWEParams(idTokenSignAlg, idTokenEncryptionAlg, idTokenEncryptionEnc),
        JWSJWEParams(userInfoSignAlg, userInfoEncryptionAlg, userInfoEncryptionEnc),
        JWSJWEParams(requestSignAlg, requestEncryptionAlg, requestEncryptionEnc),
        tokenAuthMethod,
        tokenAuthSignAlg,
        defaultMaxAge,
        defaultAcrs,
        authTimeRequired,
        loginUri,
        requestUris,
        MultiParams(descripton, descriptons),
        createdAt,
        modifiedAt
      )
    }
  }

}

