package com.github.dhslrl321.todos.support.fixture

import com.github.dhslrl321.todos.domain.todo.Todo
import com.github.dhslrl321.todos.support.fixture.UserFixture.user1
import com.github.dhslrl321.todos.support.fixture.UserFixture.user2
import java.time.LocalDateTime
import java.util.*

object TodoFixture {
  val todo1 = create(userId = user1.id, name = "kotlin 공부")
  val todo2 = create(userId = user1.id, name = "알고리즘 문제풀이 3문제")
  val todo3 = create(userId = user1.id, name = "scdf 아키텍처 분석")

  val todo4 = create(userId = user2.id, name = "프로틴 먹기")
  val todo5 = createDeleted(userId = user2.id, name = "가슴 운동")
  val todo6 = create(userId = user2.id, name = "주짓수")
  val todo7 = create(userId = user2.id, name = "가계부 작성")

  fun create(userId: Long, name: String): Todo = Todo(id = newId(), userId = userId, name = name)

  fun createDeleted(userId: Long, name: String): Todo =
    Todo(id = newId(), userId = userId, name = name, deletedAt = LocalDateTime.now())

}

private fun newId() = UUID.randomUUID().toString()
