import org.gradle.api.JavaVersion

object Versions {
    val core_ktx = "1.10.0"
    val lifecycle_runtime_ktx = "2.6.1"
    val activity_compose = "1.7.0"
    val ui = "1.4.1"
    val ui_tooling_preview = "1.4.1"
    val material = "1.4.1"
    val glide_compose = "1.0.0-alpha.1"
    val lifecycle_viewmodel_compose = "2.6.1"
    val hilt_android = "2.44"
    val hilt_compiler = "2.44"
    val timber = "5.0.1"
    val realm_gradle_plugin = "10.11.1"
    val com_android_application = "7.4.2"
    val com_android_library = "7.4.2"
    val org_jetbrains_kotlin_android = "1.8.10"
    val com_google_dagger_hilt_android = "2.44"
    val ktor_client_core = "2.1.2"
    val io_ktor_ktor_client_cio = "2.0.1"
    val io_ktor_ktor_client_content_negotiation = "2.1.2"
    val io_ktor_ktor_client_logging_jvm = "2.1.2"
    val io_ktor_ktor_serialization_gson = "2.1.2"
    val io_ktor_ktor_serialization_kotlinx_json = "2.1.2"
}

object Dependencies {
    val module_data = ":data"
    val module_domain = ":domain"
    val androidx_core_core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    val androidx_lifecycle_lifecycle_runtime_ktx =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_runtime_ktx}"
    val androidx_activity_activit_compose =
        "androidx.activity:activity-compose:${Versions.activity_compose}"
    val androidx_compose_ui_ui = "androidx.compose.ui:ui:${Versions.ui}"
    val androidx_compose_ui_ui_tooling_preview =
        "androidx.compose.ui:ui-tooling-preview:${Versions.ui_tooling_preview}"
    val androidx_compose_material_material =
        "androidx.compose.material:material:${Versions.material}"
    val com_github_bumptech_glide_compose =
        "com.github.bumptech.glide:compose:${Versions.glide_compose}"
    val androidx_lifecycle_lifecycle_viewmodel_compose =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle_viewmodel_compose}"
    val com_google_dagger_hilt_android = "com.google.dagger:hilt-android:${Versions.hilt_android}"
    val com_google_dagger_hilt_compiler =
        "com.google.dagger:hilt-compiler:${Versions.hilt_compiler}"
    val com_jakewharton_timber_timber = "com.jakewharton.timber:timber:${Versions.timber}"
    val io_realm_realm_gradle_plugin =
        "io.realm:realm-gradle-plugin:${Versions.realm_gradle_plugin}"
    val io_ktor_ktor_client_core = "io.ktor:ktor-client-core:${Versions.ktor_client_core}"
    val io_ktor_ktor_client_cio = "io.ktor:ktor-client-cio:${Versions.io_ktor_ktor_client_cio}"
    val io_ktor_ktor_client_content_negotiation =
        "io.ktor:ktor-client-content-negotiation:${Versions.io_ktor_ktor_client_content_negotiation}"
    val io_ktor_ktor_client_logging_jvm =
        "io.ktor:ktor-client-logging-jvm:${Versions.io_ktor_ktor_client_logging_jvm}"
    val io_ktor_ktor_serialization_gson =
        "io.ktor:ktor-serialization-gson:${Versions.io_ktor_ktor_serialization_gson}"
    val io_ktor_ktor_serialization_kotlinx_json =
        "io.ktor:ktor-serialization-kotlinx-json:${Versions.io_ktor_ktor_serialization_kotlinx_json}"
}

object Plugins {
    val com_android_application = "com.android.application"
    val org_jetbrains_kotlin_android = "org.jetbrains.kotlin.android"
    val kotlin_kapt = "kotlin-kapt"
    val com_google_dagger_hilt_android = "com.google.dagger.hilt.android"
    val com_android_library = "com.android.library"
    val realm_android = "realm-android"
}

object ConfigVersions {
    val namespace_app = "com.example.myhouse"
    val namespace_data = "com.example.data"
    val namespace_domain = "com.example.domain"
    val compileSdk = 33
    val applicationId = "com.example.myhouse"
    val minSdk = 21
    val targetSdk = 33
    val versionCode = 1
    val versionName = "1.0"
    val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    val jvmTarget = "1.8"
    val kotlinCompilerExtensionVersion = "1.4.4"
    val packagingOptions_resources_excludes = "/META-INF/{AL2.0,LGPL2.1}"
    val compileOptions_sourceCompatibility = JavaVersion.VERSION_1_8
    val compileOptions_targetCompatibility = JavaVersion.VERSION_1_8
}