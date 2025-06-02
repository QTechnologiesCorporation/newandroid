plugins {
    alias(libs.plugins.module.android.library)
    alias(libs.plugins.module.android.presentation)
}

android {
    namespace = "com.qtechnologiescorporation.presentation"
}

dependencies {
    implementation(project(":userFeatures:userAuth:navigation"))
    implementation(project(":libraries:designSystem"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}