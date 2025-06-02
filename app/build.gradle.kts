plugins {
    alias(libs.plugins.module.android.application)
    alias(libs.plugins.module.android.presentation)
}

android {
    namespace = "com.qtechnologiescorporation.qtechhealth"

    defaultConfig {
        applicationId = "com.qtechnologiescorporation.qtechhealth"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    //Project Modules
    implementation(project(":userFeatures:userAuth:navigation"))
    implementation(project(":userFeatures:userAuth:presentation"))

    implementation(project(":userFeatures:userHome:navigation"))
    implementation(project(":userFeatures:userHome:presentation"))

    implementation(project(":userFeatures:userProfile:navigation"))
    implementation(project(":userFeatures:userProfile:presentation"))


    implementation(project(":libraries:designSystem"))

    implementation(project(":libraries:navigation:api"))
    implementation(project(":libraries:navigation:api-impl"))
    implementation(project(":libraries:common"))

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}