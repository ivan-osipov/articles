import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50"
}


repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.apply {
        freeCompilerArgs = listOf("-Xuse-experimental=kotlin.Experimental")
        jvmTarget = "1.8"
    }
}