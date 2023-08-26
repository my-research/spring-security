package com.github.dhslrl321.todos.domain.todo

import com.github.dhslrl321.todos.domain.todo.TodoStatus.CREATED
import java.time.LocalDateTime

data class Todo(
  val id: String,
  val userId: Long,
  var name: String,
  var status: TodoStatus = CREATED,
  val createdAt: LocalDateTime = LocalDateTime.now(),
  var updatedAt: LocalDateTime = LocalDateTime.now(),
  var deletedAt: LocalDateTime? = null
) {
  fun transitTo(to: TodoStatus) {
    this.status = to
  }
}
