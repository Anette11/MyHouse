plugins {
    id(Plugins.com_android_application)
    id(Plugins.org_jetbrains_kotlin_android)
    id(Plugins.kotlin_kapt)
    id(Plugins.com_google_dagger_hilt_android)
}

android {
    namespace = ConfigVersions.namespace_app
    compileSdk = ConfigVersions.compileSdk

    defaultConfig {
        applicationId = ConfigVersions.applicationId
        minSdk = ConfigVersions.minSdk
        targetSdk = ConfigVersions.targetSdk
        versionCode = ConfigVersions.versionCode
        versionName = ConfigVersions.versionName

        testInstrumentationRunner = ConfigVersions.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = ConfigVersions.kotlinCompilerExtensionVersion
    }
    packagingOptions {
        resources {
            excludes += ConfigVersions.packagingOptions_resources_excludes
        }
    }
}

dependencies {

    implementation(project(Dependencies.module_data))
    implementation(project(Dependencies.module_domain))
    implementation(Dependencies.androidx_core_core_ktx)
    implementation(Dependencies.androidx_lifecycle_lifecycle_runtime_ktx)
    implementation(Dependencies.androidx_activity_activit_compose)
    implementation(Dependencies.androidx_compose_ui_ui)
    implementation(Dependencies.androidx_compose_ui_ui_tooling_preview)
    implementation(Dependencies.androidx_compose_material_material)
    implementation(Dependencies.com_github_bumptech_glide_compose)
    implementation(Dependencies.androidx_lifecycle_lifecycle_viewmodel_compose)
    implementation(Dependencies.com_google_dagger_hilt_android)
    kapt(Dependencies.com_google_dagger_hilt_compiler)
    implementation(Dependencies.com_jakewharton_timber_timber)
}

kapt {
    correctErrorTypes = true
}