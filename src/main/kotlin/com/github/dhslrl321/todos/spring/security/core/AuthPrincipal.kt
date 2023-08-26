package com.github.dhslrl321.todos.spring.security.core

import com.github.dhslrl321.todos.domain.role.UserRoles
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

data class AuthPrincipal(
  val userId: Long,
  val role: UserRoles
) {

  /**
   * role 과 authorities 를 조회
   */
  fun grantedAuthorities(): List<GrantedAuthority> = roles() + authorities()

  private fun roles() = role.authorities
    .map { SimpleGrantedAuthority("ROLE_${it.name}") }

  private fun authorities() = role.authorities
    .flatMap { it.actions }
    .map { SimpleGrantedAuthority(it.name) }
}
