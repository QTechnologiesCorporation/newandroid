plugins {
    alias(libs.plugins.module.android.library)
    alias(libs.plugins.module.android.presentation)
}

android {
    namespace = "com.qtechnologiescorporation.presentation"
}

dependencies {
    implementation(project(":businessFeatures:auth:navigation"))
    implementation(project(":libraries:designSystem"))
}