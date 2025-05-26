pluginManagement {
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
        google()
        mavenCentral()
    }
}

rootProject.name = "Q Tech Health"
include(":app")
include(":core:designSystem")
include(":features:ear")
include(":core:navigation")
include(":features:face")
include(":features:userAuth")
include(":features:businessAuth")
include(":features:oral")
include(":features:eyes")
include(":features:medicalForm")
include(":features:forgotPassword")
include(":features:userHome")
include(":features:chat")
include(":features:qiAssist")
include(":features:userHealthRecords")
include(":features:notification")
include(":features:userProfile")
include(":features:businessProfile")
include(":features:userMedicalRecords")
include(":features:userMedicationReminder")
include(":features:userNotes")
include(":features:businessHome")
include(":features:businessMedicalForm")
include(":features:businesssMedicalRecords")
