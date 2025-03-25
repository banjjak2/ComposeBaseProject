plugins {
    alias(libs.plugins.composebaseproject.android.application)
    alias(libs.plugins.composebaseproject.android.application.compose)
    alias(libs.plugins.composebaseproject.android.hilt)
}

android {
    namespace = "com.sample.composebaseproject"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.sample.composebaseproject"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.retrofit.serialization.converter)

    implementation(libs.androidx.navigation.compose)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
