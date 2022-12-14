import extensions.androidTestImplementation
import extensions.testImplementation

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
//    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test-jvm:1.6.4")
    implementation("junit:junit:4.12")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")
    testImplementation(TestingLib.Junit)
    androidTestImplementation(AndroidTestingLib.JunitExt)
    androidTestImplementation(AndroidTestingLib.EspressoCore)
//    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")
    testImplementation(TestingLib.Truth)
    testImplementation(TestingLib.Robolectric)
    testImplementation(TestingLib.Turbine)
//    testImplementation(TestingLib.Mockk)
//    testImplementation(TestingLib.mockitoKotlin)
//    testImplementation(TestingLib.mockitoInline)

    testImplementation          ("junit:junit:4.13.2")
    testImplementation          ("org.mockito:mockito-inline:4.4.0")
    testImplementation          ("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
    testImplementation          ("org.mockito:mockito-core:4.4.0")
    testImplementation          ("org.hamcrest:hamcrest-library:2.2")
    testImplementation          ("io.kotest:kotest-assertions-core:5.3.1")
    testImplementation          ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.1")
    androidTestImplementation   ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation   ("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation   ("androidx.compose.ui:ui-test-junit4:1.1.1")
}