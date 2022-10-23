import extensions.*
import org.gradle.kotlin.dsl.implementation

plugins {
    id("commons.android-library")
    id("commons.android-compose")
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")
}

dependencies {


    implementation("junit:junit:4.12")
    testImplementation("org.jetbrains.kotlin:kotlin-coroutines-test-jvm:1.6.1")
    //    addComposeDependencies()
//    addTestDependencies()
    addCommonDependencies()
    addHiltDependencies()
//    testImplementation(TestingLib.Junit)
//    testImplementation(TestingLib.Coroutine)
//    testImplementation(TestingLib.mockitoKotlin)
    implementation(SupportLib.CoroutineCore)
    implementation(SupportLib.CoroutineAndroid)

    testImplementation("io.kotest:kotest-assertions-core:5.3.1")
    implementation("com.jakewharton.timber:timber:4.7.1")
}