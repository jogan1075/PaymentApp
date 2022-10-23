import extensions.addNavigationDependencies

plugins {
    id("commons.android-feature")
    id("commons.android-compose")
    id("commons.dagger-hilt")
    id("com.google.devtools.ksp")
}


ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "amount")
}

dependencies {


    implementation(project(mapOf("path" to ":core:mvi")))
    implementation(project(mapOf("path" to ":core:utils")))
    
    implementation(project(mapOf("path" to ":libraries:navigation")))

    /*   implementation ("androidx.core:core-ktx:1.7.0")
       implementation ("androidx.appcompat:appcompat:1.5.1")
       implementation ("com.google.android.material:material:1.6.1")

       testImplementation ("junit:junit:4.13.2")
       androidTestImplementation ("androidx.test.ext:junit:1.1.3")
       androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")

       implementation ("androidx.compose.ui:ui:1.2.0")
       implementation ("androidx.compose.material:material:1.2.0")
       implementation ("androidx.compose.ui:ui-tooling-preview:1.2.0")
       implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
       implementation ("androidx.activity:activity-compose:1.5.1")
       debugImplementation ("androidx.compose.ui:ui-tooling:1.2.0")
       implementation ("androidx.navigation:navigation-compose:2.5.1")
       implementation ("androidx.paging:paging-compose:1.0.0-alpha15")
       implementation ("javax.inject:javax.inject:1")
       implementation ("androidx.constraintlayout:constraintlayout-compose:1.1.0-alpha03")

       implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.6.2")
       implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
       implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.2")*/

    implementation ("com.google.dagger:hilt-android:2.40")
    kapt ("com.google.dagger:hilt-android-compiler:2.40.4")
    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01")
//    implementation  'androidx.hilt:hilt-lifecycle-viewmodel:x.x.x'
    kapt ("androidx.hilt:hilt-compiler:1.0.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")

    addNavigationDependencies()
}