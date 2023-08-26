package com.github.dhslrl321.todos.domain.role

import com.github.dhslrl321.todos.domain.role.UserActions.*

enum class UserAuthorities(
  val actions: List<UserActions>
) {
  TODO_MANAGEMENT(
    listOf(READ_TODO, CREATE_TODO, UPDATE_TODO, DELETE_TODO, ROLE_ADMIN)
  ),

  TODO_READER(
    listOf(READ_TODO)
  )
  ;
}
