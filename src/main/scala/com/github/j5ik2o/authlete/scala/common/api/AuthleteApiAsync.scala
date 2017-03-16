package com.github.j5ik2o.authlete.scala.common.api

import com.github.j5ik2o.authlete.scala.common.dto._

import scala.concurrent.{ ExecutionContext, Future }

trait AuthleteApiAsync {

  def introspection(request: IntrospectionRequest)(implicit ec: ExecutionContext): Future[IntrospectionResponse]

  def userinfoIssue(request: UserInfoIssueRequest)(implicit ec: ExecutionContext): Future[UserInfoIssueResponse]

  def authorizationIssue(request: AuthorizationIssueRequest)(implicit ec: ExecutionContext): Future[AuthorizationIssueResponse]

  def authorizationFail(request: AuthorizationFailRequest)(implicit ec: ExecutionContext): Future[AuthorizationFailResponse]

  def getServiceJwks(implicit ec: ExecutionContext): Future[Option[String]]

  def getServiceJwks(pretty: Boolean, includePrivateKeys: Boolean)(implicit ec: ExecutionContext): Future[Option[String]]

  def token(request: TokenRequest)(implicit ec: ExecutionContext): Future[TokenResponse]

  //  def getGrantedScopes(clientId: Long, subject: String)(implicit ec: ExecutionContext): Future[GrantedScopesGetResponse]

  def deleteService(apiKey: Long)(implicit ec: ExecutionContext): Future[Unit]

  def tokenCreate(request: TokenCreateRequest)(implicit ec: ExecutionContext): Future[TokenCreateResponse]

  def createServie(service: Service)(implicit ec: ExecutionContext): Future[Service]

  def userinfo(request: UserInfoRequest)(implicit ec: ExecutionContext): Future[UserInfoResponse]

  def getService(apiKey: Long)(implicit ec: ExecutionContext): Future[Service]

  def getClient(clientId: Long)(implicit ec: ExecutionContext): Future[Client]

  def updateClient(client: Client)(implicit ec: ExecutionContext): Future[Client]

  def revocation(request: RevocationRequest)(implicit ec: ExecutionContext): Future[RevocationResponse]

  def deleteClient(clientId: Long)(implicit ec: ExecutionContext): Future[Unit]

  def getServiceList(implicit ec: ExecutionContext): Future[ServiceListResponse]

  def getServiceList(start: Int, end: Int)(implicit ec: ExecutionContext): Future[ServiceListResponse]

  def getServiceConfiguration(implicit ec: ExecutionContext): Future[String]

  def getServiceConfiguration(pretty: Boolean)(implicit ec: ExecutionContext): Future[String]

  def tokenFail(request: TokenFailRequest)(implicit ec: ExecutionContext): Future[TokenFailResponse]

  def authorization(request: AuthorizationRequest)(implicit ec: ExecutionContext): Future[AuthorizationResponse]

  def tokenUpdate(request: TokenUpdateRequest)(implicit ec: ExecutionContext): Future[TokenUpdateResponse]

  def setRequestableScopes(clientId: Long, scopes: Array[String])(implicit ec: ExecutionContext): Future[Array[String]]

  def getRequestableScopes(clientId: Long)(implicit ec: ExecutionContext): Future[Array[String]]

  def createClient(client: Client)(implicit ec: ExecutionContext): Future[Client]

  def updateService(service: Service)(implicit ec: ExecutionContext): Future[Service]

  def getClientList(implicit ec: ExecutionContext): Future[ClientListResponse]

  def getClientList(developer: String)(implicit ec: ExecutionContext): Future[ClientListResponse]

  def getClientList(start: Int, end: Int)(implicit ec: ExecutionContext): Future[ClientListResponse]

  def getClientList(developer: String, start: Int, end: Int)(implicit ec: ExecutionContext): Future[ClientListResponse]

  def tokenIssue(request: TokenIssueRequest)(implicit ec: ExecutionContext): Future[TokenIssueResponse]

  //  def deleteGrantedScopes(clientId: Long, subject: String)(implicit ec: ExecutionContext): Future[Unit]

  def deleteRequestableScopes(clientId: Long)(implicit ec: ExecutionContext): Future[Unit]

}

object AuthleteApiAsync {

}
