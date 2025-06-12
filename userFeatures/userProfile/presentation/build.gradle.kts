plugins {
    alias(libs.plugins.module.android.library)
    alias(libs.plugins.module.android.presentation)
}

android {
    namespace = "com.qtechnologiescorporation.presentation"
}

dependencies {
    implementation(project(":userFeatures:userProfile:navigation"))
    implementation(project(":libraries:designSystem"))
    implementation("io.github.sceneview:arsceneview:2.3.0")
    implementation("io.github.sceneview:sceneview:2.3.0")
}