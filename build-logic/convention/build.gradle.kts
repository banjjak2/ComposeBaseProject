import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.sample.composebaseproject.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_11
    }
}

dependencies {
    /**
     * 안드로이드 관련 빌드를 설정하기 위해
     * 없을 경우 플러그인 설정 시 CommonExtension이 import되지 않음
     */
    compileOnly(libs.android.gradlePlugin)
    /**
     * KotlinAndroidProjectExtension 등으로 프로젝트를 세팅하기 위해
     */
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = libs.plugins.composebaseproject.android.application.asProvider().get().pluginId
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("AndroidApplicationComposeConvention") {
            id = libs.plugins.composebaseproject.android.application.compose.get().pluginId
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("AndroidHiltConvention") {
            id = libs.plugins.composebaseproject.android.hilt.get().pluginId
            implementationClass = "AndroidHiltConventionPlugin"
        }
    }
}
