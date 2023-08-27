package com.github.dhslrl321.todos.spring.security

class UnauthorizedException(
  override val message: String
): RuntimeException() {
}
