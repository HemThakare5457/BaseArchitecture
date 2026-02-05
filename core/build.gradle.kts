plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

apply(from = "../common-module.gradle")

android {
    namespace = "com.example.core"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {
    // Module-specific dependencies go here
    implementation(libs.viewmodelKtx)
}