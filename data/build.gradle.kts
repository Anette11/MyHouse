plugins {
    id(Plugins.com_android_library)
    id(Plugins.org_jetbrains_kotlin_android)
    id(Plugins.kotlin_kapt)
    id(Plugins.com_google_dagger_hilt_android)
    id(Plugins.realm_android)
}

android {
    namespace = ConfigVersions.namespace_data
    compileSdk = ConfigVersions.compileSdk

    defaultConfig {
        minSdk = ConfigVersions.minSdk
        targetSdk = ConfigVersions.targetSdk

        testInstrumentationRunner = ConfigVersions.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "BASE_URL", "\"http://cars.cprogroup.ru/api/rubetek/\"")
        buildConfigField("String", "CAMERAS", "\"cameras/\"")
        buildConfigField("String", "DOORS", "\"doors/\"")

        buildConfigField("long", "DB_VERSION", "1")
        buildConfigField("String", "DB_NAME", "\"realm_db\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = ConfigVersions.compileOptions_sourceCompatibility
        targetCompatibility = ConfigVersions.compileOptions_targetCompatibility
    }
    kotlinOptions {
        jvmTarget = ConfigVersions.jvmTarget
    }
}

dependencies {

    implementation(project(Dependencies.module_domain))
    implementation(Dependencies.io_ktor_ktor_client_core)
    implementation(Dependencies.io_ktor_ktor_client_cio)
    implementation(Dependencies.io_ktor_ktor_client_content_negotiation)
    implementation(Dependencies.io_ktor_ktor_client_logging_jvm)
    implementation(Dependencies.io_ktor_ktor_serialization_gson)
    implementation(Dependencies.io_ktor_ktor_serialization_kotlinx_json)
    implementation(Dependencies.com_google_dagger_hilt_android)
    kapt(Dependencies.com_google_dagger_hilt_compiler)
    implementation(Dependencies.com_jakewharton_timber_timber)
}

kapt {
    correctErrorTypes = true
}