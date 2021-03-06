pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
        jcenter()
        maven {
            url = uri("KOTLIN_REPO")
        }
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android" || requested.id.name == "kotlin-android-extensions") {
                useModule("com.android.tools.build:gradle:4.0.1")
            }
        }
    }
}
rootProject.name = "multiplatformMobileLibrary"