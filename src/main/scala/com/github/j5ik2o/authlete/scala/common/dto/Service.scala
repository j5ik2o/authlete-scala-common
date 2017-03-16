package com.github.j5ik2o.authlete.scala.common.dto

import java.net.URI

import com.github.j5ik2o.authlete.scala.common.`type`._
import io.circe.syntax._
import io.circe.{ Decoder, Encoder, Json }

case class ServiceSupportedParams(
  supportedScopes: Seq[Scope],
  supportedResponseTypes: Seq[ResponseType],
  supportedGrantTypes: Seq[GrantType.Value],
  supportedAcrs: Seq[String],
  supportedTokenAuthMethods: Seq[ClientAuthMethod.Value],
  supportedDisplays: Seq[Display.Value],
  supportedClaimTypes: Seq[ClaimType.Value],
  supportedClaims: Seq[String],
  serviceDocumentation: Option[URI],
  supportedUiLocales: Seq[String]
)

case class AuthenticationCallbackParams(
  callbackEndpoint: Option[URI],
  callbackApiKey: Option[String],
  callbackApiSecret: Option[String]
)

case class DirectEndpointParams(
  directAuthorizationEndpointEnabled: Boolean,
  directTokenEndpointEnabled: Boolean,
  directRevocationEndpointEnabled: Boolean,
  directUserInfoEndpointEnabled: Boolean,
  directJwksEndpointEnabled: Boolean
)

case class EndpointParams(
  authorizationEndpoint: Option[URI],
  tokenEndpoint: Option[URI],
  revocationEndpoint: Option[URI],
  userInfoEndpoint: Option[URI],
  registrationEndpoint: Option[URI]
)

case class SnsParams(
  supportedSnses: Seq[Sns.Value],
  snsCredentials: Seq[SnsCredentials]
)

case class JwkParams(
  jwksUri: Option[URI],
  jwks: Option[String]
)

case class Service(
  number: Int,
  serviceOwnerNumber: Int,
  serviceName: Option[String],
  apiKey: Long,
  apiSecret: Option[String],
  issuer: Option[URI],
  endpointParams: EndpointParams,
  jwkParams: JwkParams,
  serviceSupportedParams: ServiceSupportedParams,
  policyUri: Option[URI],
  tosUri: Option[URI],
  authenticationCallbackParams: AuthenticationCallbackParams,
  snsParams: SnsParams,
  createdAt: Long,
  modifiedAt: Long,
  developerAuthenticationCallbackParams: AuthenticationCallbackParams,
  developerSnsParams: SnsParams,
  clientsPerDeveloper: Int,
  directEndpointParams: DirectEndpointParams,
  singleAccessTokenPerSubject: Boolean,
  pkceRequired: Boolean,
  refreshTokenKept: Boolean
)

object Service {

  import ResponseTypeJsonImplicits._
  import ClaimTypeJsonImplicits._
  import ClientAuthMethodJsonImplicits._
  import DisplayJsonImplicits._
  import GrantTypeJsonImplicits._
  import SnsJsonImplicits._
  import com.github.j5ik2o.authlete.scala.common.api.JsonImplicits._

  implicit val ServiceJsonEncoder: Encoder[Service] = Encoder.instance { v =>
    Json.obj(
      "number" -> v.number.asJson,
      "serviceOwnerNumber" -> v.serviceOwnerNumber.asJson,
      "serviceName" -> v.serviceName.asJson,
      "apiKey" -> v.apiKey.asJson,
      "apiSecret" -> v.apiSecret.asJson,
      "issuer" -> v.issuer.asJson,
      "authorizationEndpoint" -> v.endpointParams.authorizationEndpoint.asJson,
      "tokenEndpoint" -> v.endpointParams.tokenEndpoint.asJson,
      "revocationEndpoint" -> v.endpointParams.revocationEndpoint.asJson,
      "userInfoEndpoint" -> v.endpointParams.userInfoEndpoint.asJson,
      "registrationEndpoint" -> v.endpointParams.registrationEndpoint.asJson,
      "jwksUri" -> v.jwkParams.jwksUri.asJson,
      "jwks" -> v.jwkParams.jwks.asJson,
      "supportedScopes" -> v.serviceSupportedParams.supportedScopes.asJson,
      "supportedResponseTypes" -> v.serviceSupportedParams.supportedResponseTypes.asJson,
      "supportedGrantTypes" -> v.serviceSupportedParams.supportedGrantTypes.asJson,
      "supportedAcrs" -> v.serviceSupportedParams.supportedAcrs.asJson,
      "supportedTokenAuthMethods" -> v.serviceSupportedParams.supportedTokenAuthMethods.asJson,
      "supportedDisplays" -> v.serviceSupportedParams.supportedDisplays.asJson,
      "supportedClaimTypes" -> v.serviceSupportedParams.supportedClaimTypes.asJson,
      "supportedClaims" -> v.serviceSupportedParams.supportedClaims.asJson,
      "serviceDocumentation" -> v.serviceSupportedParams.serviceDocumentation.asJson,
      "supportedUiLocales" -> v.serviceSupportedParams.supportedUiLocales.asJson,
      "policyUri" -> v.policyUri.asJson,
      "tosUri" -> v.tosUri.asJson,
      "authenticationCallbackEndpoint" -> v.authenticationCallbackParams.callbackEndpoint.asJson,
      "authenticationCallbackApiKey" -> v.authenticationCallbackParams.callbackApiKey.asJson,
      "authenticationCallbackApiSecret" -> v.authenticationCallbackParams.callbackApiSecret.asJson,
      "supportedSnses" -> v.snsParams.supportedSnses.asJson,
      "snsCredentials" -> v.snsParams.snsCredentials.asJson,
      "createdAt" -> v.createdAt.asJson,
      "modifiedAt" -> v.modifiedAt.asJson,
      "developerAuthenticationCallbackEndpoint" -> v.developerAuthenticationCallbackParams.callbackEndpoint.asJson,
      "developerAuthenticationCallbackApiKey" -> v.developerAuthenticationCallbackParams.callbackApiKey.asJson,
      "developerAuthenticationCallbackApiSecret" -> v.developerAuthenticationCallbackParams.callbackApiSecret.asJson,
      "supportedDeveloperSnses" -> v.developerSnsParams.supportedSnses.asJson,
      "developerSnsCredentials" -> v.developerSnsParams.snsCredentials.asJson,
      "clientsPerDeveloper" -> v.clientsPerDeveloper.asJson,
      "directAuthorizationEndpointEnabled" -> v.directEndpointParams.directAuthorizationEndpointEnabled.asJson,
      "directTokenEndpointEnabled" -> v.directEndpointParams.directTokenEndpointEnabled.asJson,
      "directRevocationEndpointEnabled" -> v.directEndpointParams.directRevocationEndpointEnabled.asJson,
      "directUserInfoEndpointEnabled" -> v.directEndpointParams.directUserInfoEndpointEnabled.asJson,
      "directJwksEndpointEnabled" -> v.directEndpointParams.directJwksEndpointEnabled.asJson,
      "singleAccessTokenPerSubject" -> v.singleAccessTokenPerSubject.asJson,
      "pkceRequired" -> v.pkceRequired.asJson,
      "refreshTokenKept" -> v.refreshTokenKept.asJson
    )
  }

  implicit val ServiceJsonDecoder: Decoder[Service] = Decoder.instance { hcursor =>
    (for {
      number <- hcursor.get[Int]("number").right
      serviceOwnerNumber <- hcursor.get[Int]("serviceOwnerNumber").right
      serviceName <- hcursor.get[Option[String]]("serviceName").right
      apiKey <- hcursor.get[Long]("apiKey").right
      apiSecret <- hcursor.get[Option[String]]("apiSecret").right
      issuer <- hcursor.get[Option[URI]]("issuer").right
      authorizationEndpoint <- hcursor.get[Option[URI]]("authorizationEndpoint").right
      tokenEndpoint <- hcursor.get[Option[URI]]("tokenEndpoint").right
      revocationEndpoint <- hcursor.get[Option[URI]]("revocationEndpoint").right
      userInfoEndpoint <- hcursor.get[Option[URI]]("userInfoEndpoint").right
      registrationEndpoint <- hcursor.get[Option[URI]]("registrationEndpoint").right
      jwksUri <- hcursor.get[Option[URI]]("jwksUri").right
      jwks <- hcursor.get[Option[String]]("jwks").right
      supportedScopes <- hcursor.get[Seq[Scope]]("supportedScopes").right
      supportedResponseTypes <- hcursor.get[Seq[ResponseType]]("supportedResponseTypes").right
      supportedGrantTypes <- hcursor.get[Seq[GrantType.Value]]("supportedGrantTypes").right
      supportedAcrs <- hcursor.get[Seq[String]]("supportedAcrs").right
      supportedTokenAuthMethods <- hcursor.get[Seq[ClientAuthMethod.Value]]("supportedTokenAuthMethods").right
      supportedDisplays <- hcursor.get[Seq[Display.Value]]("supportedDisplays").right
      supportedClaimTypes <- hcursor.get[Seq[ClaimType.Value]]("supportedClaimTypes").right
      supportedClaims <- hcursor.get[Seq[String]]("supportedClaims").right
      serviceDocumentation <- hcursor.get[Option[URI]]("serviceDocumentation").right
      supportedUiLocales <- hcursor.get[Seq[String]]("supportedUiLocales").right
      policyUri <- hcursor.get[Option[URI]]("policyUri").right
      tosUri <- hcursor.get[Option[URI]]("tosUri").right
      authenticationCallbackEndpoint <- hcursor.get[Option[URI]]("authenticationCallbackEndpoint").right
      authenticationCallbackApiKey <- hcursor.get[Option[String]]("authenticationCallbackApiKey").right
      authenticationCallbackApiSecret <- hcursor.get[Option[String]]("authenticationCallbackApiSecret").right
      supportedSnses <- hcursor.get[Seq[Sns.Value]]("supportedSnses").right
      snsCredentials <- hcursor.get[Seq[SnsCredentials]]("snsCredentials").right
      createdAt <- hcursor.get[Long]("createdAt").right
      modifiedAt <- hcursor.get[Long]("modifiedAt").right
      developerAuthenticationCallbackEndpoint <- hcursor.get[Option[URI]]("developerAuthenticationCallbackEndpoint").right
      developerAuthenticationCallbackApiKey <- hcursor.get[Option[String]]("developerAuthenticationCallbackApiKey").right
      developerAuthenticationCallbackApiSecret <- hcursor.get[Option[String]]("developerAuthenticationCallbackApiSecret").right
      supportedDeveloperSnses <- hcursor.get[Seq[Sns.Value]]("supportedDeveloperSnses").right
      developerSnsCredentials <- hcursor.get[Seq[SnsCredentials]]("developerSnsCredentials").right
      clientsPerDeveloper <- hcursor.get[Int]("clientsPerDeveloper").right
      directAuthorizationEndpointEnabled <- hcursor.get[Boolean]("directAuthorizationEndpointEnabled").right
      directTokenEndpointEnabled <- hcursor.get[Boolean]("directTokenEndpointEnabled").right
      directRevocationEndpointEnabled <- hcursor.get[Boolean]("directRevocationEndpointEnabled").right
      directUserInfoEndpointEnabled <- hcursor.get[Boolean]("directUserInfoEndpointEnabled").right
      directJwksEndpointEnabled <- hcursor.get[Boolean]("directJwksEndpointEnabled").right
      singleAccessTokenPerSubject <- hcursor.get[Boolean]("singleAccessTokenPerSubject").right
      pkceRequired <- hcursor.get[Boolean]("pkceRequired").right
      refreshTokenKept <- hcursor.get[Boolean]("refreshTokenKept").right
    } yield {
      val endpointParams = new EndpointParams(
        authorizationEndpoint,
        tokenEndpoint,
        revocationEndpoint,
        userInfoEndpoint,
        registrationEndpoint
      )
      val jwkParams = new JwkParams(
        jwksUri,
        jwks
      )
      val serviceSupportedParams = new ServiceSupportedParams(
        supportedScopes,
        supportedResponseTypes,
        supportedGrantTypes,
        supportedAcrs,
        supportedTokenAuthMethods,
        supportedDisplays,
        supportedClaimTypes,
        supportedClaims,
        serviceDocumentation,
        supportedUiLocales
      )
      val authenticationCallbackParams = new AuthenticationCallbackParams(
        authenticationCallbackEndpoint,
        authenticationCallbackApiKey,
        authenticationCallbackApiSecret
      )
      val snsParams = new SnsParams(
        supportedSnses, snsCredentials
      )
      val developerAuthenticationCallbackParams = new AuthenticationCallbackParams(
        developerAuthenticationCallbackEndpoint,
        developerAuthenticationCallbackApiKey,
        developerAuthenticationCallbackApiSecret
      )
      val developerSnsParams = new SnsParams(
        supportedDeveloperSnses, developerSnsCredentials
      )
      val directEndpointParams = new DirectEndpointParams(
        directAuthorizationEndpointEnabled,
        directTokenEndpointEnabled,
        directRevocationEndpointEnabled,
        directUserInfoEndpointEnabled,
        directJwksEndpointEnabled
      )
      new Service(
        number,
        serviceOwnerNumber,
        serviceName,
        apiKey,
        apiSecret,
        issuer,
        endpointParams,
        jwkParams,
        serviceSupportedParams,
        policyUri,
        tosUri,
        authenticationCallbackParams,
        snsParams,
        createdAt,
        modifiedAt,
        developerAuthenticationCallbackParams,
        developerSnsParams,
        clientsPerDeveloper,
        directEndpointParams,
        singleAccessTokenPerSubject,
        pkceRequired,
        refreshTokenKept
      )
    })
  }

}
