import extensions.addHiltDependencies
import extensions.addNetworkDependencies

plugins {
    id("commons.android-library")
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")
}

dependencies {

    // Network
    addNetworkDependencies()

    addHiltDependencies()
}