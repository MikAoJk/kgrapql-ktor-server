import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val kgraphql_version: String by project
val jvm_version: String by project


plugins {
    kotlin("jvm") version "1.9.0"
    id("io.ktor.plugin") version "2.3.1"
}

group = "io.github.MikAoJk"
version = "0.0.1"
application {
    mainClass.set("io.github.MikAoJk.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("com.apurebase:kgraphql:$kgraphql_version")
    implementation("com.apurebase:kgraphql-ktor:$kgraphql_version")

    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = jvm_version
    }
    named<KotlinCompile>("compileTestKotlin") {
        kotlinOptions.jvmTarget = jvm_version
    }
}
