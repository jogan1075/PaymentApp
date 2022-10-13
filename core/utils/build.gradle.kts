import extensions.addComposeDependencies
import extensions.addHiltDependencies

plugins {
    id("commons.android-library")
    id("commons.android-compose")
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")
}

dependencies {


//    addComposeDependencies()
    addHiltDependencies()
}