package com.github.dhslrl321.todos.domain.todo

import java.time.LocalDateTime

class InMemoryTodoRepository(
  private val storage: MutableMap<String, Todo>,
): TodoRepository {

  override fun findBy(id: String): Todo? =
    storage[id]

  override fun findAll(): List<Todo> =
    storage.values.toList()


  override fun save(todo: Todo): Todo? {
    val existingTodo = storage[todo.id]
    if (existingTodo == null) {
      storage[todo.id] = todo
    } else {
      storage[todo.id] = existingTodo.copy(
        name = todo.name,
        status = todo.status,
        updatedAt = LocalDateTime.now(),
        deletedAt = todo.deletedAt ?: existingTodo.deletedAt
      )
    }
    return storage[todo.id]
  }
}
