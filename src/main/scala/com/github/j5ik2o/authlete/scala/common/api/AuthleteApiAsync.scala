package com.github.j5ik2o.authlete.scala.common.api

import com.authlete.common.api.AuthleteApi
import com.authlete.common.dto._

import scala.concurrent.{ ExecutionContext, Future }

class AuthleteApiAsync(underlying: AuthleteApi) {

  def introspection(request: IntrospectionRequest)(implicit ec: ExecutionContext): Future[IntrospectionResponse] = Future {
    underlying.introspection(request)
  }

  def userinfoIssue(request: UserInfoIssueRequest)(implicit ec: ExecutionContext): Future[UserInfoIssueResponse] = Future {
    underlying.userinfoIssue(request)
  }

  def authorizationIssue(request: AuthorizationIssueRequest)(implicit ec: ExecutionContext): Future[AuthorizationIssueResponse] = Future {
    underlying.authorizationIssue(request)
  }

  def authorizationFail(request: AuthorizationFailRequest)(implicit ec: ExecutionContext): Future[AuthorizationFailResponse] = Future {
    underlying.authorizationFail(request)
  }

  def getServiceJwks(implicit ec: ExecutionContext): Future[String] = Future {
    underlying.getServiceJwks
  }

  def getServiceJwks(pretty: Boolean, includePrivateKeys: Boolean)(implicit ec: ExecutionContext): Future[String] = Future {
    underlying.getServiceJwks(pretty, includePrivateKeys)
  }

  def token(request: TokenRequest)(implicit ec: ExecutionContext): Future[TokenResponse] = Future {
    underlying.token(request)
  }

  def getGrantedScopes(clientId: Long, subject: String)(implicit ec: ExecutionContext): Future[GrantedScopesGetResponse] = Future {
    underlying.getGrantedScopes(clientId, subject)
  }

  def deleteService(apiKey: Long)(implicit ec: ExecutionContext): Future[Unit] = Future {
    underlying.deleteService(apiKey)
  }

  def tokenCreate(request: TokenCreateRequest)(implicit ec: ExecutionContext): Future[TokenCreateResponse] = Future {
    underlying.tokenCreate(request)
  }

  def createServie(service: Service)(implicit ec: ExecutionContext): Future[Service] = Future {
    underlying.createServie(service)
  }

  def userinfo(request: UserInfoRequest)(implicit ec: ExecutionContext): Future[UserInfoResponse] = Future {
    underlying.userinfo(request)
  }

  def getService(apiKey: Long)(implicit ec: ExecutionContext): Future[Service] = Future {
    underlying.getService(apiKey)
  }

  def getClient(clientId: Long)(implicit ec: ExecutionContext): Future[Client] = Future {
    underlying.getClient(clientId)
  }

  def updateClient(client: Client)(implicit ec: ExecutionContext): Future[Client] = Future {
    underlying.updateClient(client)
  }

  def revocation(request: RevocationRequest)(implicit ec: ExecutionContext): Future[RevocationResponse] = Future {
    underlying.revocation(request)
  }

  def deleteClient(clientId: Long)(implicit ec: ExecutionContext): Future[Unit] = Future {
    underlying.deleteClient(clientId)
  }

  def getServiceList(implicit ec: ExecutionContext): Future[ServiceListResponse] = Future {
    underlying.getServiceList()
  }

  def getServiceList(start: Int, end: Int)(implicit ec: ExecutionContext): Future[ServiceListResponse] = Future {
    underlying.getServiceList(start, end)
  }

  def getServiceConfiguration(implicit ec: ExecutionContext): Future[String] = Future {
    underlying.getServiceConfiguration
  }

  def getServiceConfiguration(pretty: Boolean)(implicit ec: ExecutionContext): Future[String] = Future {
    underlying.getServiceConfiguration(pretty)
  }

  def tokenFail(request: TokenFailRequest)(implicit ec: ExecutionContext): Future[TokenFailResponse] = Future {
    underlying.tokenFail(request)
  }

  def authorization(request: AuthorizationRequest)(implicit ec: ExecutionContext): Future[AuthorizationResponse] = Future {
    underlying.authorization(request)
  }

  def tokenUpdate(request: TokenUpdateRequest)(implicit ec: ExecutionContext): Future[TokenUpdateResponse] = Future {
    underlying.tokenUpdate(request)
  }

  def setRequestableScopes(clientId: Long, scopes: Array[String])(implicit ec: ExecutionContext): Future[Array[String]] = Future {
    underlying.setRequestableScopes(clientId, scopes)
  }

  def getRequestableScopes(clientId: Long)(implicit ec: ExecutionContext): Future[Array[String]] = Future {
    underlying.getRequestableScopes(clientId)
  }

  def createClient(client: Client)(implicit ec: ExecutionContext): Future[Client] = Future {
    underlying.createClient(client)
  }

  def updateService(service: Service)(implicit ec: ExecutionContext): Future[Service] = Future {
    underlying.updateService(service)
  }

  def getClientList(implicit ec: ExecutionContext): Future[ClientListResponse] = Future {
    underlying.getClientList
  }

  def getClientList(developer: String)(implicit ec: ExecutionContext): Future[ClientListResponse] = Future {
    underlying.getClientList(developer)
  }

  def getClientList(start: Int, end: Int)(implicit ec: ExecutionContext): Future[ClientListResponse] = Future {
    underlying.getClientList(start, end)
  }

  def getClientList(developer: String, start: Int, end: Int)(implicit ec: ExecutionContext): Future[ClientListResponse] = Future {
    underlying.getClientList(developer, start, end)
  }

  def tokenIssue(request: TokenIssueRequest)(implicit ec: ExecutionContext): Future[TokenIssueResponse] = Future {
    underlying.tokenIssue(request)
  }

  def deleteGrantedScopes(clientId: Long, subject: String)(implicit ec: ExecutionContext): Future[Unit] = Future {
    underlying.deleteGrantedScopes(clientId, subject)
  }

  def deleteRequestableScopes(clientId: Long)(implicit ec: ExecutionContext): Future[Unit] = Future {
    underlying.deleteRequestableScopes(clientId)
  }
}
