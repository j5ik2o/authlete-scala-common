package com.github.j5ik2o.authlete.scala.common.`type`

import io.circe.{ Decoder, Encoder, Json }

sealed trait JWSAlg {
  val valueAsNumber: Int
  val valueAsString: String
  val valueAsHashAlg: Option[HashAlg.Value]
}

object JWSAlg {

  implicit val JWSAlgEncoder: Encoder[JWSAlg] = Encoder[String].contramap(_.valueAsString)
  implicit val JWSAlgDecoder: Decoder[JWSAlg] = Decoder[String].map(valueOf)

  val values = Set(
    None,
    HS256, HS384, HS512,
    RS256, RS384, RS512,
    ES256, ES384, ES512,
    PS256, PS384, PS512
  )

  def valueOf(name: String): JWSAlg = {
    values.find(_.valueAsString == name).get
  }

  case object None extends JWSAlg {
    override val valueAsNumber: Int = 0
    override val valueAsString: String = "none"
    override val valueAsHashAlg: Option[HashAlg.Value] = scala.None
  }

  case object HS256 extends JWSAlg {
    override val valueAsNumber: Int = 1
    override val valueAsString: String = "HS256"
    override val valueAsHashAlg: Option[HashAlg.Value] = Some(HashAlg.Sha256)
  }

  case object HS384 extends JWSAlg {
    override val valueAsNumber: Int = 2
    override val valueAsString: String = "HS384"
    override val valueAsHashAlg: Option[HashAlg.Value] = Some(HashAlg.Sha384)
  }

  case object HS512 extends JWSAlg {
    override val valueAsNumber: Int = 3
    override val valueAsString: String = "HS512"
    override val valueAsHashAlg: Option[HashAlg.Value] = Some(HashAlg.Sha512)
  }

  case object RS256 extends JWSAlg {
    override val valueAsNumber: Int = 4
    override val valueAsString: String = "RS256"
    override val valueAsHashAlg: Option[HashAlg.Value] = Some(HashAlg.Sha256)
  }

  case object RS384 extends JWSAlg {
    override val valueAsNumber: Int = 5
    override val valueAsString: String = "RS384"
    override val valueAsHashAlg: Option[HashAlg.Value] = Some(HashAlg.Sha384)
  }

  case object RS512 extends JWSAlg {
    override val valueAsNumber: Int = 6
    override val valueAsString: String = "RS512"
    override val valueAsHashAlg: Option[HashAlg.Value] = Some(HashAlg.Sha512)
  }

  case object ES256 extends JWSAlg {
    override val valueAsNumber: Int = 7
    override val valueAsString: String = "ES256"
    override val valueAsHashAlg: Option[HashAlg.Value] = Some(HashAlg.Sha256)
  }

  case object ES384 extends JWSAlg {
    override val valueAsNumber: Int = 8
    override val valueAsString: String = "ES384"
    override val valueAsHashAlg: Option[HashAlg.Value] = Some(HashAlg.Sha384)
  }

  case object ES512 extends JWSAlg {
    override val valueAsNumber: Int = 9
    override val valueAsString: String = "ES512"
    override val valueAsHashAlg: Option[HashAlg.Value] = Some(HashAlg.Sha512)
  }

  case object PS256 extends JWSAlg {
    override val valueAsNumber: Int = 10
    override val valueAsString: String = "PS256"
    override val valueAsHashAlg: Option[HashAlg.Value] = Some(HashAlg.Sha256)
  }

  case object PS384 extends JWSAlg {
    override val valueAsNumber: Int = 11
    override val valueAsString: String = "ES384"
    override val valueAsHashAlg: Option[HashAlg.Value] = Some(HashAlg.Sha384)
  }

  case object PS512 extends JWSAlg {
    override val valueAsNumber: Int = 12
    override val valueAsString: String = "PS512"
    override val valueAsHashAlg: Option[HashAlg.Value] = Some(HashAlg.Sha512)
  }

}

