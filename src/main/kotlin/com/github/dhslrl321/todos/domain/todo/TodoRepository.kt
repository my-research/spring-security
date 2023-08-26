package com.github.dhslrl321.todos.domain.todo

interface TodoRepository {

  fun findBy(id: String): Todo?

  fun findAll(): List<Todo>

  fun save(create: Todo): Todo?

}
