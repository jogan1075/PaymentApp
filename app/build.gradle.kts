import extensions.*

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.parcelize")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Configs.CompileSdk

    defaultConfig {
        applicationId = Configs.Id
        minSdk = Configs.MinSdk
        targetSdk = Configs.TargetSdk
        versionCode = Configs.VersionCode
        versionName = Configs.VersionName
        multiDexEnabled = true
        testInstrumentationRunner = Configs.AndroidJunitRunner
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            isTestCoverageEnabled = false
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
        freeCompilerArgs = Configs.FreeCompilerArgs
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1,gradle-plugins}"
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

android.applicationVariants.all {
    val variantName = name
    kotlin.sourceSets {
        getByName("main") {
            kotlin.srcDir(File("build/generated/ksp/$variantName/kotlin"))
        }
    }
}

dependencies {
    implementation(project(mapOf("path" to ":libraries:navigation")))
    implementation(project(mapOf("path" to ":feature:splash")))
    implementation(project(mapOf("path" to ":feature:amount")))
    implementation(project(mapOf("path" to ":feature:payment")))
    implementation(project(mapOf("path" to ":feature:banks")))
    implementation(project(mapOf("path" to ":feature:installments")))
    implementation(project(mapOf("path" to ":feature:finished")))

    // Common
    addCommonDependencies()
    // Compose
    addComposeDependencies()
    // Navigation
    addNavigationDependencies()
    // Network
    addNetworkDependencies()
    // Storage
    addStorageDependencies()
    // Firebase
    addFirebaseDependencies()
    // Core
    implementation(SupportLib.Splashscreen)
    implementation(SupportLib.Timber)
    implementation(SupportLib.Paging)
    // Dagger Hilt
    addHiltDependencies()
    // Test
    addTestDependencies()

    //modules
    addModuleDependencies()

    implementation("io.coil-kt:coil-gif:2.2.2")
    testImplementation(TestingLib.mockitoKotlin)
    testImplementation ("io.kotest:kotest-assertions-core:5.3.1")
}