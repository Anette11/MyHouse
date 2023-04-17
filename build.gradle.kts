buildscript {
    dependencies {
        classpath(Dependencies.io_realm_realm_gradle_plugin)
    }
}
plugins {
    id(Plugins.com_android_application) version Versions.com_android_application apply false
    id(Plugins.com_android_library) version Versions.com_android_library apply false
    id(Plugins.org_jetbrains_kotlin_android) version Versions.org_jetbrains_kotlin_android apply false
    id(Plugins.com_google_dagger_hilt_android) version Versions.com_google_dagger_hilt_android apply false
}