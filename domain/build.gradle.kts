plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

apply(from = "../common-module.gradle")

android {
    namespace = "com.example.domain"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {
    // Module-specific dependencies go here
    implementation(project(":core"))
}