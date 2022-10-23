import extensions.addNavigationDependencies
import extensions.implementation
import extensions.kapt
import extensions.testImplementation

plugins {
    id("commons.android-feature")
    id("commons.android-compose")
    id("commons.dagger-hilt")
    id("com.google.devtools.ksp")
}

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "banks")
}

dependencies {

    implementation(project(mapOf("path" to ":core:network")))
    implementation(project(mapOf("path" to ":core:mvi")))
    implementation(project(mapOf("path" to ":core:utils")))


    implementation(project(mapOf("path" to ":libraries:navigation")))


    implementation("com.google.dagger:hilt-android:2.40")
    kapt("com.google.dagger:hilt-android-compiler:2.40.4")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01")

    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.9")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation("com.google.code.gson:gson:2.9.0")

    addNavigationDependencies()
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
//    implementation("io.coil-kt:coil-gif:2.2.2")
    implementation(ComposeLib.Coil)

    testImplementation(TestingLib.mockitoKotlin)
    testImplementation ("io.kotest:kotest-assertions-core:5.3.1")
}