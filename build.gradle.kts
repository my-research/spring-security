import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "3.1.1"
  id("io.spring.dependency-management") version "1.1.0"
  kotlin("jvm") version "1.8.22"
  kotlin("plugin.spring") version "1.8.22"
}

group = "com.github.dhslrl321.todos"
version = "0.0.1-SNAPSHOT"

java {
  sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
  compileOnly {
    extendsFrom(configurations.annotationProcessor.get())
  }
}

repositories {
  mavenCentral()
}

dependencies {

  implementation("org.springframework.boot:spring-boot-starter-web")


  implementation("org.springframework.boot:spring-boot-starter-security")
  implementation ("io.jsonwebtoken:jjwt-api:0.11.5")
  testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
  testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
  testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
  runtimeOnly ("io.jsonwebtoken:jjwt-impl:0.11.5")
  runtimeOnly ("io.jsonwebtoken:jjwt-jackson:0.11.5")

  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-reflect")

  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.springframework.security:spring-security-test")
  testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
  testImplementation("org.assertj:assertj-core:3.20.2")
  testImplementation("io.kotest:kotest-runner-junit5:5.6.2")
  testImplementation("io.kotest:kotest-assertions-core:4.6.3")
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs += "-Xjsr305=strict"
    jvmTarget = "17"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}

