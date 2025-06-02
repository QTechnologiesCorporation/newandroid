@file:Suppress("UnstableApiUsage")

include(":userFeatures:userAuth:presentation")


include(":userFeatures:userAuth:navigation")


include(":features:userAuth:navigation")


pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
    }
}


rootProject.name = "Q Tech Health"
include(":app")

include(":libraries:designSystem")

include(":userFeatures:userProfile:navigation")
include(":userFeatures:userProfile:presentation")

include(":userFeatures:userHome:navigation")
include(":userFeatures:userHome:presentation")

include(":libraries:common")
include(":libraries:navigation:api-impl")
include(":libraries:navigation:api")


