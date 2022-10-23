import extensions.addNavigationDependencies

plugins {
    id("commons.android-feature")
    id("commons.android-compose")
    id("commons.dagger-hilt")
    id("com.google.devtools.ksp")
}


ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "splash")
}

dependencies {


//    implementation(project(mapOf("path" to ":core:mvi")))
    implementation(project(mapOf("path" to ":core:utils")))

//    implementation(project(mapOf("path" to ":libraries:ui-component")))
    implementation(project(mapOf("path" to ":libraries:navigation")))

    addNavigationDependencies()
}