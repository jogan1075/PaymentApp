package extensions

import AccompanistLib
import AndroidTestingLib
import ComposeLib
import DaggerHiltLib
import FirebaseLib
import NavigationLib
import NetworkLib
import StorageLib
import SupportLib
import TestingLib
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * Adds a dependency to the `releaseImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.releaseImplementation(dependencyNotation: Any): Dependency? =
    add("releaseImplementation", dependencyNotation)

/**
 * Adds a dependency to the `debugImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)

/**
 * Adds a dependency to the `implementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

/**
 * Adds a dependency to the `api` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.api(dependencyNotation: Any): Dependency? =
    add("api", dependencyNotation)

/**
 * Adds a dependency to the `kapt` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

/**
 * Adds a dependency to the `testImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)


/**
 * Adds a dependency to the `androidTestImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

/**
 * Adds a dependency to the `ksp` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.ksp(dependencyNotation: Any): Dependency? =
    add("ksp", dependencyNotation)

fun DependencyHandler.addCommonDependencies() {
    implementation(SupportLib.CoreKtx)
    implementation(SupportLib.Appcompat)
    implementation(SupportLib.Material)
    implementation(SupportLib.CoroutineCore)
    implementation(SupportLib.CoroutineAndroid)
//    implementation(SupportLib.LifecycleRuntime)
    implementation(SupportLib.viewModelKtx)
    implementation(SupportLib.ActivityKtx)
}

fun DependencyHandler.addComposeDependencies() {
    implementation(ComposeLib.Ui)
    implementation(ComposeLib.Material)
    implementation(ComposeLib.Preview)
    implementation(ComposeLib.Runtime)
    implementation(ComposeLib.Foundation)
    implementation(ComposeLib.MaterialIconCore)
    implementation(ComposeLib.MaterialIconExtended)
    androidTestImplementation(AndroidTestingLib.ComposeTestJunit)
    debugImplementation(ComposeLib.Tooling)
    debugImplementation(ComposeLib.Manifest)
    //
    implementation(ComposeLib.Activity)
//    implementation(ComposeLib.ViewModel)
    implementation(ComposeLib.ConstraintLayout)
    implementation(ComposeLib.Lottie)
    implementation(ComposeLib.Paging)
    implementation(ComposeLib.Coil)

    // Accompanist
    implementation(AccompanistLib.Swiperefresh)
    implementation(AccompanistLib.Systemuicontroller)
    implementation(AccompanistLib.Insets)
    implementation(AccompanistLib.PlaceholderMaterial)
    implementation(AccompanistLib.NavigationMaterial)
    implementation(AccompanistLib.Permissions)
    implementation(AccompanistLib.Pager)
    implementation(AccompanistLib.Indicators)
    implementation(AccompanistLib.Webview)
}

fun DependencyHandler.addNavigationDependencies() {
    // Navigation
    implementation(NavigationLib.Navigation)
    implementation(NavigationLib.DestinationCore)
    ksp(NavigationLib.DestinationKsp)
    implementation(NavigationLib.DestinationAnimation)
}

fun DependencyHandler.addNetworkDependencies() {
    // Network
    implementation(NetworkLib.Moshi)
    ksp(NetworkLib.MoshiCodegen)
    implementation(NetworkLib.MoshiLazyAdapter)
    implementation(NetworkLib.Retrofit)
    implementation(NetworkLib.RetrofitMoshi)
    implementation(NetworkLib.Okhttp)
    implementation(NetworkLib.LoggingInterceptor)
    testImplementation(TestingLib.Okhttp)
    debugImplementation(NetworkLib.ChuckerDebug)
    releaseImplementation(NetworkLib.ChuckerRelease)
    implementation(NetworkLib.GsonConverter)
    implementation(NetworkLib.Gson)
}

fun DependencyHandler.addStorageDependencies() {
    // Storage
    implementation(StorageLib.RoomKtx)
    ksp(StorageLib.RoomCompiler)
    implementation(StorageLib.DatastorePref)
    implementation(StorageLib.Datastore)
    implementation(StorageLib.SecurityPref)
}

fun DependencyHandler.addFirebaseDependencies() {
    // Firebase
    implementation(FirebaseLib.Base)
    implementation(FirebaseLib.Analytic)
    implementation(FirebaseLib.Crashlytics)
    implementation(FirebaseLib.Push)
    implementation(FirebaseLib.Config)
}

fun DependencyHandler.addTestDependencies() {
    // Test
    testImplementation(TestingLib.Junit)
    androidTestImplementation(AndroidTestingLib.JunitExt)
    androidTestImplementation(AndroidTestingLib.EspressoCore)
    testImplementation(TestingLib.Coroutine)
    testImplementation(TestingLib.Truth)
    testImplementation(TestingLib.Robolectric)
    testImplementation(TestingLib.Turbine)
    testImplementation(TestingLib.Mockk)
}

fun DependencyHandler.addHiltDependencies(){
    implementation(DaggerHiltLib.Android)
    kapt(DaggerHiltLib.AndroidCompiler)
    kapt(DaggerHiltLib.HiltCompiler)
    implementation(DaggerHiltLib.Compose)
    implementation(DaggerHiltLib.ViewModel)
}

fun DependencyHandler.addModuleDependencies() {
    // Modules
    implementation(project(mapOf("path" to ":core:mvi")))
    implementation(project(mapOf("path" to ":core:network")))
    implementation(project(mapOf("path" to ":core:utils")))

}

val DependencyHandler.MVI
    get() = implementation(project(mapOf("path" to ":core:mvi")))

val DependencyHandler.NETWORK
    get() = implementation(project(mapOf("path" to ":core:network")))

val DependencyHandler.UTILS
    get() = implementation(project(mapOf("path" to ":core:utils")))
