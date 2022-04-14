import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.compose") version "1.1.1"
}

group = "io.hsar"
version = "0.0.1"

repositories {
    google()
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(compose.desktop.currentOs)

    implementation("com.fifesoft", "rsyntaxtextarea", "3.2.0")
//    implementation("org.jetbrains","markdown","0.3.1")
//    implementation("com.halilibo.compose-richtext", "richtext-commonmark", "0.11.0")

    implementation(enforcedPlatform("com.fasterxml.jackson:jackson-bom:2.13.2"))
    implementation("com.fasterxml.jackson.core", "jackson-core")
    implementation("com.fasterxml.jackson.module", "jackson-module-kotlin")
    implementation("com.fasterxml.jackson.datatype", "jackson-datatype-jsr310")
    implementation("com.fasterxml.jackson.datatype", "jackson-datatype-jdk8")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "JoinedUpThinking"
            packageVersion = "1.0.0"
        }
    }
}