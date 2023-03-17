plugins {
    kotlin("jvm")
}

val coroutinesVersion: String by project

java.sourceCompatibility = JavaVersion.VERSION_17

group = rootProject.group
version = rootProject.version

dependencies {
    implementation(project(":cor"))
    implementation(kotlin("stdlib-common"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
//    implementation("com.crowdproj:kotlin-cor:0.5.5")
}