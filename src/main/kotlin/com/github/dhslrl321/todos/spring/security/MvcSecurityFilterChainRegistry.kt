package com.github.dhslrl321.todos.spring.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableMethodSecurity
class MvcSecurityFilterChainRegistry {
  @Bean
  fun filterChain(http: HttpSecurity): SecurityFilterChain {
    http
      .csrf {
        it.disable()
      }
      .headers { it -> it.frameOptions { it.disable() } }
      .authorizeHttpRequests {
        it
          .requestMatchers(
            "/login",
            "/health"
          )
          .permitAll()
          .requestMatchers("/**").authenticated()
          .anyRequest().permitAll()
      }.addFilterBefore(TodoAppAuthenticationFilter(), UsernamePasswordAuthenticationFilter::class.java)
    return http.build()
  }
}
