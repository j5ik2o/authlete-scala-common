package com.github.j5ik2o.authlete.scala.common.dto

import java.net.URI

import com.github.j5ik2o.authlete.scala.common.`type`.Sns
import com.github.j5ik2o.authlete.scala.common.dto.Service._
import io.circe.syntax._

class ServiceSpec extends org.scalatest.FunSpec {

  describe("Service") {
    it("should be able to is encoded/decoded") {
      val service = Service(
        number = 1,
        serviceOwnerNumber = 1,
        serviceName = Some("test"),
        apiKey = 1,
        apiSecret = Some("hoge"),
        issuer = Some(URI.create("http://test.com")),
        endpointParams = EndpointParams(None, None, None, None, None),
        jwkParams = JwkParams(None, None),
        serviceSupportedParams = ServiceSupportedParams(
          supportedScopes = Seq.empty,
          supportedResponseTypes = Seq.empty,
          supportedGrantTypes = Seq.empty,
          supportedAcrs = Seq.empty,
          supportedTokenAuthMethods = Seq.empty,
          supportedDisplays = Seq.empty,
          supportedClaimTypes = Seq.empty,
          supportedClaims = Seq.empty,
          serviceDocumentation = None,
          supportedUiLocales = Seq.empty
        ),
        policyUri = None,
        tosUri = None,
        authenticationCallbackParams = AuthenticationCallbackParams(
          callbackEndpoint = None,
          callbackApiKey = None,
          callbackApiSecret = None
        ),
        snsParams = SnsParams(
          supportedSnses = Seq(Sns.Facebook),
          snsCredentials = Seq.empty
        ),
        createdAt = 1,
        modifiedAt = 1,
        developerAuthenticationCallbackParams = AuthenticationCallbackParams(
          callbackEndpoint = None,
          callbackApiKey = None,
          callbackApiSecret = None
        ),
        developerSnsParams = SnsParams(
          supportedSnses = Seq(Sns.Facebook),
          snsCredentials = Seq.empty
        ),
        clientsPerDeveloper = 1,
        directEndpointParams = DirectEndpointParams(
          directAuthorizationEndpointEnabled = false,
          directTokenEndpointEnabled = false,
          directRevocationEndpointEnabled = false,
          directUserInfoEndpointEnabled = false,
          directJwksEndpointEnabled = false
        ),
        singleAccessTokenPerSubject = false,
        pkceRequired = false,
        refreshTokenKept = false
      )

      val json = service.asJson

      println(json)
      val result = json.as[Service]

      result match {
        case Left(e) =>
          fail(e)
        case Right(v) =>
          assert(v == service)
      }
    }
  }

}
