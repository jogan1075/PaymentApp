package commons


import extensions.addHiltDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    // Dagger Hilt
    addHiltDependencies()
}