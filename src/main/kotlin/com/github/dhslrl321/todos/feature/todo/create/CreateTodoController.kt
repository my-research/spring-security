package com.github.dhslrl321.todos.feature.todo.create

import com.github.dhslrl321.todos.domain.todo.Todo
import com.github.dhslrl321.todos.domain.todo.TodoRepository
import com.github.dhslrl321.todos.support.fixture.TodoFixture.create
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todos")
class CreateTodoController(
  private val repository: TodoRepository
) {

  @PostMapping
  fun create(@RequestBody body: Map<String, Any>): ResponseEntity<Todo> {
    return ResponseEntity.ok(
      repository.save(
        create(
          userId = body["userId"] as Long,
          name = body["name"] as String
        )
      )
    )
  }
}
