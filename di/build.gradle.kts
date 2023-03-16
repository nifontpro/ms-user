plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
}

java.sourceCompatibility = JavaVersion.VERSION_17

dependencies {
    implementation(project(":ms-user:domain"))
    implementation(project(":ms-user:db"))
    implementation(project(":ms-user:rest"))

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}