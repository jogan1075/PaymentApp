pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "PaymentApp"
include (":app")
include(":core:network")
include(":core:mvi")
include(":core:utils")
include(":feature:splash")
include(":feature:amount")
include(":feature:banks")
include(":feature:payment")
include(":feature:installments")
include(":feature:finished")
include(":libraries:navigation")
include(":libraries:testing")
