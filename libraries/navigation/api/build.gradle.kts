plugins {
    alias(libs.plugins.module.android.library)
}

android {
    namespace = "com.qtechnologiescorporation.api"
}

dependencies {
    implementation(libs.androidx.navigation.compose)
}