package com.github.j5ik2o.authlete.scala.common.dto

import io.circe.syntax._
import org.scalatest.FunSpec

class ClientSpec extends FunSpec {

  describe("Client") {
    it("should be able to is encoded/decoded") {
      val client = Client(
        number = 1,
        serviceNumber = 1,
        developer = None,
        clientId = 1,
        clientSecret = None,
        clientType = None,
        redirectUris = Seq.empty,
        responseTypes = Seq.empty,
        grantTypes = Seq.empty,
        applicationType = None,
        contacts = Seq.empty,
        clientName = MultiParams(None, Seq.empty),
        logoUri = MultiParams(None, Seq.empty),
        clientUri = MultiParams(None, Seq.empty),
        policyUri = MultiParams(None, Seq.empty),
        tosUri = MultiParams(None, Seq.empty),
        jwksUri = None,
        jwks = None,
        sectorIdentifier = None,
        subjectType = None,
        idTokenJWSJWEParams = JWSJWEParams(None, None, None),
        userInfoJWSJWEParams = JWSJWEParams(None, None, None),
        requestJWSJWEParams = JWSJWEParams(None, None, None),
        tokenAuthMethod = None,
        tokenAuthSignAlg = None,
        defaultMaxAge = 1,
        defaultAcrs = Seq.empty,
        authTimeRequired = false,
        loginUri = None,
        requestUris = Seq.empty,
        description = MultiParams(None, Seq.empty),
        createdAt = 1,
        modifiedAt = 1
      )

      val json = client.asJson

      println(json)
      val result = json.as[Client]

      result match {
        case Left(e) =>
          fail(e)
        case Right(v) =>
          assert(v == client)
      }

    }
  }

}
