package com.github.dhslrl321.todos.spring.security

import com.github.dhslrl321.todos.domain.role.UserRoles
import com.github.dhslrl321.todos.spring.security.core.AuthPrincipal
import com.github.dhslrl321.todos.support.JwtTokenUtil
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

@Configuration
class TodoAppAuthenticationFilter : OncePerRequestFilter() {
  companion object {
    private const val BEARER_PREFIX = "Bearer "
  }

  override fun doFilterInternal(
    request: HttpServletRequest,
    response: HttpServletResponse,
    filterChain: FilterChain
  ) {
    try {
      val authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION)
      if (authorizationHeader != null && authorizationHeader.startsWith(BEARER_PREFIX)) {

        val claims = JwtTokenUtil.getClaims(authorizationHeader.substring(BEARER_PREFIX.length))

        val principal = AuthPrincipal(
          userId = claims.subject.toLong(),
          role = UserRoles.valueOf(claims["role"].toString()),
        )

        SecurityContextHolder.getContext().authentication =
          UsernamePasswordAuthenticationToken(
            principal,
            "",
            principal.grantedAuthorities()
          )
      }
    } catch (e: Exception) {
      response.sendError(HttpStatus.UNAUTHORIZED.value(), e.message)
    }
    filterChain.doFilter(request, response)
  }
}
