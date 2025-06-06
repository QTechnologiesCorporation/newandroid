plugins {
    alias(libs.plugins.module.android.library)
}

android {
    namespace = "com.qtechnologiescorporation.api_impl"
}

dependencies {
    implementation(libs.androidx.navigation.compose)
    implementation(project(":libraries:navigation:api"))
    implementation(project(":libraries:common"))

    implementation(project(":userFeatures:userAuth:navigation"))
    implementation(project(":userFeatures:userHome:navigation"))
    implementation(project(":userFeatures:userProfile:navigation"))
    implementation(project(":userFeatures:qMedicalForm:navigation"))
    implementation(project(":userFeatures:userChat:navigation"))
    implementation(project(":businessFeatures:auth:navigation"))
    implementation(project(":userFeatures:userQi:navigation"))
    implementation(project(":userFeatures:userRecords:navigation"))


    implementation(project(":businessFeatures:businessHome:navigation"))
    implementation(project(":businessFeatures:businessRecords:navigation"))
    implementation(project(":businessFeatures:businessChat:navigation"))


}