package com.github.dhslrl321.todos.feature.todo.create

import com.github.dhslrl321.todos.domain.todo.Todo
import com.github.dhslrl321.todos.domain.todo.TodoRepository
import com.github.dhslrl321.todos.support.fixture.TodoFixture.create
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PostAuthorize
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todos")
class CreateTodoController(
  private val repository: TodoRepository
) {

  @PreAuthorize("hasAuthority('CREATE_TODO')")
  @PostAuthorize("returnObject.userId == authentication.principal.userId")
  @PostMapping
  fun create(@RequestBody body: Map<String, Any>): ResponseEntity<Todo> {
    val userId = (body["userId"] as Int).toLong()

    return ResponseEntity.ok(
      repository.save(
        create(
          userId = userId,
          name = body["name"] as String
        )
      )
    )
  }

}
