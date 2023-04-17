plugins {
    id(Plugins.com_android_library)
    id(Plugins.org_jetbrains_kotlin_android)
    id(Plugins.kotlin_kapt)
    id(Plugins.com_google_dagger_hilt_android)
}

android {
    namespace = ConfigVersions.namespace_domain
    compileSdk = ConfigVersions.compileSdk

    defaultConfig {
        minSdk = ConfigVersions.minSdk
        targetSdk = ConfigVersions.targetSdk

        testInstrumentationRunner = ConfigVersions.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
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

    implementation(Dependencies.com_google_dagger_hilt_android)
    kapt(Dependencies.com_google_dagger_hilt_compiler)
}

kapt {
    correctErrorTypes = true
}