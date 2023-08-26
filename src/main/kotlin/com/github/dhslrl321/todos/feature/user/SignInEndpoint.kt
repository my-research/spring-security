package com.github.dhslrl321.todos.feature.user

import com.github.dhslrl321.todos.domain.user.User
import com.github.dhslrl321.todos.domain.user.UserRepository
import com.github.dhslrl321.todos.support.JwtTokenUtil.createAccessToken
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/login")
class SignInEndpoint(
  private val repository: UserRepository
) {

  companion object {
    private const val ACCESS_TOKEN_EXPIRE_SECONDS: Long = 60 * 60 * 24
  }

  @PostMapping
  fun login(@RequestBody body: Map<String, Long>): ResponseEntity<Map<String, String>> {

    val user = (repository.findBy(body["userId"]!!)
      ?: throw IllegalArgumentException("[todos] user 가 존재하지 않습니다"))

    return ResponseEntity.ok(mapOf("token" to createAccessToken(claims(user))))

  }

  private fun claims(user: User): Claims? =
    Jwts.claims().also {
      it.subject = user.id.toString()
      it.expiration = Date(System.currentTimeMillis() + (ACCESS_TOKEN_EXPIRE_SECONDS * 1000))
      it["role"] = user.role
    }
}
