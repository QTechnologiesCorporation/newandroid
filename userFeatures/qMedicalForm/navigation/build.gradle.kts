plugins {
    alias(libs.plugins.module.android.library)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.qtechnologiescorporation.navigation"

}

dependencies {
    implementation(libs.kotlinx.serialization)
    implementation(project(":libraries:navigation:api"))
}