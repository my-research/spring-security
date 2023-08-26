package com.github.dhslrl321.todos.feature.todo.query

import com.github.dhslrl321.todos.domain.todo.Todo
import com.github.dhslrl321.todos.domain.todo.TodoRepository
import com.github.dhslrl321.todos.domain.todo.TodoStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class QueryTodoController(
  private val repository: TodoRepository
) {

  @PreAuthorize("hasAuthority('READ_TODO') or hasRole('ADMIN')")
  @GetMapping
  fun getTodos(
    @RequestParam(value = "status")
    status: List<TodoStatus>
  ): ResponseEntity<Any> {

    val todos = repository.findAll()
      .filter { status.contains(it.status) }

    return ResponseEntity.ok(
      mapOf(
        "count" to todos.size,
        "todos" to todos
      )
    )
  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("{id}")
  fun getTodo(@PathVariable id: String): ResponseEntity<Todo> =
    ResponseEntity.ok(
      repository.findBy(id)
        ?: throw IllegalArgumentException("[todos] todo 를 찾을 수 없습니다")
    )
}
