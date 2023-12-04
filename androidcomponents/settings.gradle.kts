pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

apply(Pair("from", file("../shared-settings.gradle")))
dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "android-components"
include(":app")
include("plugins:dependencies")
findProject(":plugins:dependencies")?.name = "dependencies"
