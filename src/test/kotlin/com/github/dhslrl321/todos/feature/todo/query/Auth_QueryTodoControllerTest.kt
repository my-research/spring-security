package com.github.dhslrl321.todos.feature.todo.query

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@ExtendWith(SpringExtension::class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
class Auth_QueryTodoControllerTest {

  @Autowired
  private lateinit var mockMvc: MockMvc

  @Test
  @WithMockUser(roles = ["ADMIN"])
  fun `ADMIN role 을 가진 사용자는 접근할 수 있다`() {
    mockMvc.perform(get("/todos").queryParam("status", "CREATED"))
      .andExpect(MockMvcResultMatchers.status().isOk())
  }

  @Test
  @WithMockUser(roles = ["USER"])
  fun `USER role 을 가진 사용자는 접근이 안됨`() {
    mockMvc.perform(get("/todos").queryParam("status", "CREATED"))
      .andExpect(MockMvcResultMatchers.status().isForbidden())
  }

  @Test
  @WithMockUser(roles = ["USER"], authorities = ["READ_TODO"])
  fun `USER role 을 가졌지만 읽기 authority 가 있으면 접근 가능`() {
    mockMvc.perform(get("/todos").queryParam("status", "CREATED"))
      .andExpect(MockMvcResultMatchers.status().isOk())
  }
}
