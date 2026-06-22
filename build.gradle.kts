plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "2.3.0"
    id("org.jetbrains.intellij.platform") version "2.16.0"
}

group = "com.leve"
version = "1.2"

repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        // 재현 가능한 빌드를 위해 패치 버전까지 지정
        intellijIdea("2026.1.2")
    }

    // 실제로 Kotlin Script(.kts)를 실행하는 기능이 있을 때만 유지
    implementation(kotlin("script-runtime"))
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

kotlin {
    jvmToolchain(21)
}

intellijPlatform {
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "231"
            untilBuild = "261.*"
        }
    }
}