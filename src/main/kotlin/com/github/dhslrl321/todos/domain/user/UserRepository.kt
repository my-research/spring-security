package com.github.dhslrl321.todos.domain.user

interface UserRepository {

  fun findBy(id: Long): User?

}
