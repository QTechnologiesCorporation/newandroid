@file:Suppress("UnstableApiUsage")

include(":businessFeatures:businessChat:presentation")


include(":businessFeatures:businessChat:navigation")


include(":businessFeatures:businessRecords:presentation")


include(":businessFeatures:businessRecords:navigation")


include(":businessFeatures:businessHome:presentation")


include(":businessFeatures:businessHome:navigation")


include(":userFeatures:userRecords:presentation")


include(":userFeatures:userRecords:navigation")


include(":userFeatures:userQi:presentation")


include(":userFeatures:userQi:navigation")


include(":userFeatures:userChat:presentation")


include(":userFeatures:userChat:navigation")


include(":userFeatures:qMedicalForm:presentation")


include(":userFeatures:qMedicalForm:navigation")


include(":businessFeatures:auth:presentation")


include(":businessFeatures:auth:navigation")


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


