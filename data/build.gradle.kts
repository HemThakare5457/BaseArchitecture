plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

apply(from = "../common-module.gradle")

android {
    namespace = "com.example.data"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {
    // Module-specific dependencies go here
    implementation(project(":core"))
    //retrofit`
    implementation(libs.gsonConverter)
    implementation(libs.retrofit)
    implementation(libs.okHttp3LoggingInterceptor)
}