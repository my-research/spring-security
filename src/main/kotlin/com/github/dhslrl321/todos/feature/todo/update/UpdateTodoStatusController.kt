package com.github.dhslrl321.todos.feature.todo.update

import com.github.dhslrl321.todos.domain.todo.Todo
import com.github.dhslrl321.todos.domain.todo.TodoRepository
import com.github.dhslrl321.todos.domain.todo.TodoStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class UpdateTodoStatusController(
  private val repository: TodoRepository
) {

  @PutMapping("{id}")
  fun update(
    @PathVariable id: String,
    @RequestBody body: Map<String, Any>
  ): ResponseEntity<Todo> {

    val todo = repository.findBy(id)
      ?: throw IllegalArgumentException("[todos-business] 존재 하지 않는 todo 입니다")

    val toStatus = TodoStatus.valueOf(body["to"] as String)

    todo.transitTo(toStatus)

    return ResponseEntity.ok(todo)
  }

}
