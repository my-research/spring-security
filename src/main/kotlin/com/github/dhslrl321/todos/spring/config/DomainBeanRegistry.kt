package com.github.dhslrl321.todos.spring.config

import com.github.dhslrl321.todos.domain.todo.InMemoryTodoRepository
import com.github.dhslrl321.todos.domain.todo.TodoRepository
import com.github.dhslrl321.todos.domain.user.InMemoryUserRepository
import com.github.dhslrl321.todos.domain.user.UserRepository
import com.github.dhslrl321.todos.support.fixture.TodoFixture.todo1
import com.github.dhslrl321.todos.support.fixture.TodoFixture.todo2
import com.github.dhslrl321.todos.support.fixture.TodoFixture.todo3
import com.github.dhslrl321.todos.support.fixture.TodoFixture.todo4
import com.github.dhslrl321.todos.support.fixture.TodoFixture.todo5
import com.github.dhslrl321.todos.support.fixture.TodoFixture.todo6
import com.github.dhslrl321.todos.support.fixture.TodoFixture.todo7
import com.github.dhslrl321.todos.support.fixture.UserFixture.admin
import com.github.dhslrl321.todos.support.fixture.UserFixture.user1
import com.github.dhslrl321.todos.support.fixture.UserFixture.user2
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DomainBeanRegistry {

  @Bean
  fun todoRepository(): TodoRepository = InMemoryTodoRepository(
    mutableMapOf(
      todo1.id to todo1, todo2.id to todo2,
      todo3.id to todo3, todo4.id to todo4,
      todo5.id to todo5, todo6.id to todo6,
      todo7.id to todo7,
    )
  )

  @Bean
  fun userRepository(): UserRepository = InMemoryUserRepository(
    mutableMapOf(
      admin.id to admin,
      user1.id to user1,
      user2.id to user2
    )
  )
}
