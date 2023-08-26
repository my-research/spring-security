package com.github.dhslrl321.todos.domain.role

import com.github.dhslrl321.todos.domain.role.UserAuthorities.*

enum class UserRoles(
  val authorities: List<UserAuthorities>
) {
  ADMIN(
    listOf(TODO_MANAGEMENT)
  ),
  USER(
    listOf(TODO_MANAGEMENT)
  ),
  ANONYMOUS(
    listOf(TODO_READER)
  )
}
