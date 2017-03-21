package com.github.j5ik2o.authlete.scala.common.api

import com.authlete.common.api.AuthleteApi
import com.authlete.common.dto._

import scala.concurrent.{ ExecutionContext, Future }

class AuthleteApiAsyncImpl(underlying: AuthleteApi) extends AuthleteApiAsync {

  override def introspection(request: IntrospectionRequest)(implicit ec: ExecutionContext): Future[IntrospectionResponse] = Future {
    underlying.introspection(request)
  }

  override def userinfoIssue(request: UserInfoIssueRequest)(implicit ec: ExecutionContext): Future[UserInfoIssueResponse] = Future {
    underlying.userinfoIssue(request)
  }

  override def authorizationIssue(request: AuthorizationIssueRequest)(implicit ec: ExecutionContext): Future[AuthorizationIssueResponse] = Future {
    underlying.authorizationIssue(request)
  }

  override def authorizationFail(request: AuthorizationFailRequest)(implicit ec: ExecutionContext): Future[AuthorizationFailResponse] = Future {
    underlying.authorizationFail(request)
  }

  override def getServiceJwks(implicit ec: ExecutionContext): Future[Option[String]] = Future {
    Option(underlying.getServiceJwks)
  }

  override def getServiceJwks(pretty: Boolean, includePrivateKeys: Boolean)(implicit ec: ExecutionContext): Future[Option[String]] = Future {
    Option(underlying.getServiceJwks(pretty, includePrivateKeys))
  }

  override def token(request: TokenRequest)(implicit ec: ExecutionContext): Future[TokenResponse] = Future {
    underlying.token(request)
  }

  override def getGrantedScopes(clientId: Long, subject: String)(implicit ec: ExecutionContext): Future[GrantedScopesGetResponse] = Future {
    underlying.getGrantedScopes(clientId, subject)
  }

  override def deleteService(apiKey: Long)(implicit ec: ExecutionContext): Future[Unit] = Future {
    underlying.deleteService(apiKey)
  }

  override def tokenCreate(request: TokenCreateRequest)(implicit ec: ExecutionContext): Future[TokenCreateResponse] = Future {
    underlying.tokenCreate(request)
  }

  override def createServie(service: Service)(implicit ec: ExecutionContext): Future[Service] = Future {
    underlying.createServie(service)
  }

  override def userinfo(request: UserInfoRequest)(implicit ec: ExecutionContext): Future[UserInfoResponse] = Future {
    underlying.userinfo(request)
  }

  override def getService(apiKey: Long)(implicit ec: ExecutionContext): Future[Service] = Future {
    underlying.getService(apiKey)
  }

  override def getClient(clientId: Long)(implicit ec: ExecutionContext): Future[Client] = Future {
    underlying.getClient(clientId)
  }

  override def updateClient(client: Client)(implicit ec: ExecutionContext): Future[Client] = Future {
    underlying.updateClient(client)
  }

  override def revocation(request: RevocationRequest)(implicit ec: ExecutionContext): Future[RevocationResponse] = Future {
    underlying.revocation(request)
  }

  override def deleteClient(clientId: Long)(implicit ec: ExecutionContext): Future[Unit] = Future {
    underlying.deleteClient(clientId)
  }

  override def getServiceList(implicit ec: ExecutionContext): Future[ServiceListResponse] = Future {
    underlying.getServiceList()
  }

  override def getServiceList(start: Int, end: Int)(implicit ec: ExecutionContext): Future[ServiceListResponse] = Future {
    underlying.getServiceList(start, end)
  }

  override def getServiceConfiguration(implicit ec: ExecutionContext): Future[String] = Future {
    underlying.getServiceConfiguration
  }

  override def getServiceConfiguration(pretty: Boolean)(implicit ec: ExecutionContext): Future[String] = Future {
    underlying.getServiceConfiguration(pretty)
  }

  override def tokenFail(request: TokenFailRequest)(implicit ec: ExecutionContext): Future[TokenFailResponse] = Future {
    underlying.tokenFail(request)
  }

  override def authorization(request: AuthorizationRequest)(implicit ec: ExecutionContext): Future[AuthorizationResponse] = Future {
    underlying.authorization(request)
  }

  override def tokenUpdate(request: TokenUpdateRequest)(implicit ec: ExecutionContext): Future[TokenUpdateResponse] = Future {
    underlying.tokenUpdate(request)
  }

  override def setRequestableScopes(clientId: Long, scopes: Array[String])(implicit ec: ExecutionContext): Future[Array[String]] = Future {
    underlying.setRequestableScopes(clientId, scopes)
  }

  override def getRequestableScopes(clientId: Long)(implicit ec: ExecutionContext): Future[Array[String]] = Future {
    underlying.getRequestableScopes(clientId)
  }

  override def createClient(client: Client)(implicit ec: ExecutionContext): Future[Client] = Future {
    underlying.createClient(client)
  }

  override def updateService(service: Service)(implicit ec: ExecutionContext): Future[Service] = Future {
    underlying.updateService(service)
  }

  override def getClientList(implicit ec: ExecutionContext): Future[ClientListResponse] = Future {
    underlying.getClientList
  }

  override def getClientList(developer: String)(implicit ec: ExecutionContext): Future[ClientListResponse] = Future {
    underlying.getClientList(developer)
  }

  override def getClientList(start: Int, end: Int)(implicit ec: ExecutionContext): Future[ClientListResponse] = Future {
    underlying.getClientList(start, end)
  }

  override def getClientList(developer: String, start: Int, end: Int)(implicit ec: ExecutionContext): Future[ClientListResponse] = Future {
    underlying.getClientList(developer, start, end)
  }

  override def tokenIssue(request: TokenIssueRequest)(implicit ec: ExecutionContext): Future[TokenIssueResponse] = Future {
    underlying.tokenIssue(request)
  }

  override def deleteGrantedScopes(clientId: Long, subject: String)(implicit ec: ExecutionContext): Future[Unit] = Future {
    underlying.deleteGrantedScopes(clientId, subject)
  }

  override def deleteRequestableScopes(clientId: Long)(implicit ec: ExecutionContext): Future[Unit] = Future {
    underlying.deleteRequestableScopes(clientId)
  }
}
