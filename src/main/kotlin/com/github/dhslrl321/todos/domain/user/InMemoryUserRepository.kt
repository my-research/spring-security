package com.github.dhslrl321.todos.domain.user

class InMemoryUserRepository(
  private val storage: MutableMap<Long, User>,
) : UserRepository {

  override fun findBy(id: Long): User? = storage[id]

}
