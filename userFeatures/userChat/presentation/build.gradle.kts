plugins {
    alias(libs.plugins.module.android.library)
    alias(libs.plugins.module.android.presentation)
}

android {
    namespace = "com.qtechnologiescorporation.presentation"

}

dependencies {
    implementation(project(":userFeatures:userChat:navigation"))
    implementation(project(":libraries:designSystem"))
}