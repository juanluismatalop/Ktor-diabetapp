plugins {
    kotlin("jvm") version "1.9.0"
    id("io.ktor.plugin") version "2.3.0"
    kotlin("plugin.serialization") version "1.9.0"
}

group = "com"
version = "0.0.1"

application {
    mainClass.set("ktor.ApplicationKt")
    val isDevelopment: Boolean = project.hasProperty("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {

    implementation("io.ktor:ktor-server-core:2.3.0")
    implementation("io.ktor:ktor-server-netty:2.3.0")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.0")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.0")
    implementation("io.ktor:ktor-server-host-common:2.3.0")
    implementation("ch.qos.logback:logback-classic:1.4.5")

    // Base de datos
    implementation("org.jetbrains.exposed:exposed-core:0.41.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.41.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.41.1")
    implementation("org.mariadb.jdbc:mariadb-java-client:3.1.4")
    implementation("mysql:mysql-connector-java:8.0.33")
    implementation("com.zaxxer:HikariCP:5.0.1")

    // Testing
    testImplementation("io.ktor:ktor-server-test-host:2.3.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.9.0")
}
