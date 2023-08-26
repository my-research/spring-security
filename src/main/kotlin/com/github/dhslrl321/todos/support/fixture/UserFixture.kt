package com.github.dhslrl321.todos.support.fixture

import com.github.dhslrl321.todos.domain.role.UserRoles
import com.github.dhslrl321.todos.domain.user.User

object UserFixture {
  val admin = User(1004, UserRoles.ADMIN)
  val user1 = User(1234, UserRoles.USER)
  val user2 = User(9876, UserRoles.USER)
}
