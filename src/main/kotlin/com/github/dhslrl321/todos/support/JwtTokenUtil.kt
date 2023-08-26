package com.github.dhslrl321.todos.support

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import java.util.*

object JwtTokenUtil {
  private const val SECRET_KEY = "my-dhslrl321's-jjwt-secret-key!@#$"

  /**
   * Token 생성
   */
  fun createAccessToken(claims: Claims?): String {
    return Jwts.builder()
      .setClaims(claims)
      .setIssuedAt(Date())
      .signWith(Keys.hmacShaKeyFor(SECRET_KEY.toByteArray()))
      .compact()
  }

  /**
   * Token 에서 Claim 추츨
   */
  fun getClaims(token: String): Claims {
    return Jwts
      .parserBuilder()
      .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.toByteArray()))
      .build()
      .parseClaimsJws(token)
      .body
  }
}
