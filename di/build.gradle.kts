plugins {
	kotlin("jvm")
	kotlin("plugin.spring")
	kotlin("plugin.jpa") version "1.8.0"
	kotlin("plugin.allopen") version "1.8.0"
	id("org.springframework.boot")
}

java.sourceCompatibility = JavaVersion.VERSION_17

group = rootProject.group
version = rootProject.version

dependencies {
	implementation(project(":ms-user:domain"))
	implementation(project(":ms-user:db"))
	implementation(project(":ms-user:rest"))

	implementation("org.springframework.boot:spring-boot-starter")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	runtimeOnly("org.postgresql:postgresql")
}