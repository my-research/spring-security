package com.github.dhslrl321.todos.domain.user

import com.github.dhslrl321.todos.domain.role.UserRoles

data class User(
  val id: Long,
  val role: UserRoles
) {
}
