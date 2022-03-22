package com.fjoglar.composechallenge.buildsrc

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.2"

    object Kotlin {
        private const val version = "1.6.10"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object Google {
        const val material = "com.google.android.material:material:1.4.0"

        object Accompanist {
            private const val version = "0.24.4-alpha"

            const val systemUiController =
                "com.google.accompanist:accompanist-systemuicontroller:$version"
        }
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.6.0"
        const val appcompat = "androidx.appcompat:appcompat:1.3.1"

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.4.0-beta01"
        }

        object Compose {
            const val version = "1.2.0-alpha05"

            const val ui = "androidx.compose.ui:ui:$version"
            const val material = "androidx.compose.material:material:$version"
            const val materialIconsExtended =
                "androidx.compose.material:material-icons-extended:$version"

            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
        }

        object Navigation {
            const val compose = "androidx.navigation:navigation-compose:2.4.0-alpha10"
        }
    }

    object Coil {
        const val compose = "io.coil-kt:coil-compose:1.4.0"
    }
}