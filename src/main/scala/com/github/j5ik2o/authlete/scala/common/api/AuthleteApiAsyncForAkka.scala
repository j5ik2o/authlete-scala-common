package com.github.j5ik2o.authlete.scala.common.api

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.marshalling.Marshal
import akka.http.scaladsl.model.{ HttpMethods, HttpRequest, RequestEntity }
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{ Sink, Source }
import com.github.j5ik2o.authlete.scala.common.dto._
import io.circe.parser._

import scala.concurrent.duration.FiniteDuration
import scala.concurrent.{ ExecutionContext, Future }

class AuthleteApiAsyncForAkka(apiConfig: ApiConfig)(implicit system: ActorSystem)
    extends AuthleteApiAsync with FailFastCirceSupport {

  private implicit val materializer = ActorMaterializer()

  private val poolClientFlow = Http().cachedHostConnectionPoolHttps[Int](apiConfig.host, apiConfig.port.getOrElse(443))
  override val timeoutForToStrict: FiniteDuration = apiConfig.timeoutForToStrict

  override def introspection(request: IntrospectionRequest)(implicit ec: ExecutionContext): Future[IntrospectionResponse] = ???

  override def userinfoIssue(request: UserInfoIssueRequest)(implicit ec: ExecutionContext): Future[UserInfoIssueResponse] = ???

  override def authorizationIssue(request: AuthorizationIssueRequest)(implicit ec: ExecutionContext): Future[AuthorizationIssueResponse] = ???

  override def authorizationFail(request: AuthorizationFailRequest)(implicit ec: ExecutionContext): Future[AuthorizationFailResponse] = ???

  override def getServiceJwks(implicit ec: ExecutionContext): Future[Option[String]] = ???

  override def getServiceJwks(pretty: Boolean, includePrivateKeys: Boolean)(implicit ec: ExecutionContext): Future[Option[String]] = ???

  override def token(request: TokenRequest)(implicit ec: ExecutionContext): Future[TokenResponse] = ???

  override def deleteService(apiKey: Long)(implicit ec: ExecutionContext): Future[Unit] = ???

  override def tokenCreate(request: TokenCreateRequest)(implicit ec: ExecutionContext): Future[TokenCreateResponse] = ???

  override def createServie(service: Service)(implicit ec: ExecutionContext): Future[Service] = ???

  override def userinfo(request: UserInfoRequest)(implicit ec: ExecutionContext): Future[UserInfoResponse] = ???

  override def getService(apiKey: Long)(implicit ec: ExecutionContext): Future[Service] = ???

  override def getClient(clientId: Long)(implicit ec: ExecutionContext): Future[Client] = ???

  override def updateClient(client: Client)(implicit ec: ExecutionContext): Future[Client] = ???

  override def revocation(request: RevocationRequest)(implicit ec: ExecutionContext): Future[RevocationResponse] = ???

  override def deleteClient(clientId: Long)(implicit ec: ExecutionContext): Future[Unit] = ???

  override def getServiceList(implicit ec: ExecutionContext): Future[ServiceListResponse] = ???

  override def getServiceList(start: Int, end: Int)(implicit ec: ExecutionContext): Future[ServiceListResponse] = ???

  override def getServiceConfiguration(implicit ec: ExecutionContext): Future[String] = ???

  override def getServiceConfiguration(pretty: Boolean)(implicit ec: ExecutionContext): Future[String] = ???

  override def tokenFail(request: TokenFailRequest)(implicit ec: ExecutionContext): Future[TokenFailResponse] = ???

  override def authorization(request: AuthorizationRequest)(implicit ec: ExecutionContext): Future[AuthorizationResponse] = {
    import io.circe.generic.auto._
    import JsonImplicits._
    (for {
      requestEntity <- Marshal(request).to[RequestEntity]
      rawResponse <- Source.single(
        HttpRequest(uri = "/auth/authorization")
          .withMethod(HttpMethods.POST)
          .withEntity(requestEntity)
          -> 1
      ).via(poolClientFlow).runWith(Sink.head)
      //response <- Unmarshal(rawResponse).to[AuthorizationResponse]
    } yield rawResponse).flatMap {
      case (triedResponse, _) =>
        null
      //        triedResponse.map{ httpResponse =>
      //          Unmarshal(httpResponse.entity).to[AuthorizationResponse]
      //        }.get
    }
    //    future.flatMap {
    //      case (triedResponse, _) =>
    //        triedResponse.map { response =>
    //          Unmarshal(response.entity).to[ByteString].map{ e =>
    //
    //          }
    //          response.entity.toStrict(timeout).map {
    //            _.data
    //          }.map(_.utf8String).flatMap { s =>
    //            parse(s) match {
    //              case Left(e) =>
    //                throw AuthleteApiException(Some("Occurred Error"), Some(e))
    //              case Right(jsonResult) =>
    //                jsonResult.as[ItemSearchResult] match {
    //                  case Left(e) =>
    //                    throw AuthleteApiException(Some("Occurred Error"), Some(e))
    //                  case Right(model) =>
    //                    model
    //                }
    //            }
    //          }.recoverWith {
    //            case ex: Exception =>
    //              Future.failed(AuthleteApiException(Some("Occurred Error"), Some(e)))
    //          }
    //        }.get
    //    }
  }

  override def tokenUpdate(request: TokenUpdateRequest)(implicit ec: ExecutionContext): Future[TokenUpdateResponse] = ???

  override def setRequestableScopes(clientId: Long, scopes: Array[String])(implicit ec: ExecutionContext): Future[Array[String]] = ???

  override def getRequestableScopes(clientId: Long)(implicit ec: ExecutionContext): Future[Array[String]] = ???

  override def createClient(client: Client)(implicit ec: ExecutionContext): Future[Client] = ???

  override def updateService(service: Service)(implicit ec: ExecutionContext): Future[Service] = ???

  override def getClientList(implicit ec: ExecutionContext): Future[ClientListResponse] = ???

  override def getClientList(developer: String)(implicit ec: ExecutionContext): Future[ClientListResponse] = ???

  override def getClientList(start: Int, end: Int)(implicit ec: ExecutionContext): Future[ClientListResponse] = ???

  override def getClientList(developer: String, start: Int, end: Int)(implicit ec: ExecutionContext): Future[ClientListResponse] = ???

  override def tokenIssue(request: TokenIssueRequest)(implicit ec: ExecutionContext): Future[TokenIssueResponse] = ???

  override def deleteRequestableScopes(clientId: Long)(implicit ec: ExecutionContext): Future[Unit] = ???

}

object AuthleteApiAsyncForAkka {

  def apply(apiConfig: ApiConfig)(implicit system: ActorSystem): AuthleteApiAsync =
    new AuthleteApiAsyncForAkka(apiConfig)

}
