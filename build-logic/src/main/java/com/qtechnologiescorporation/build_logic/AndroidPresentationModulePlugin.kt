package com.qtechnologiescorporation.build_logic

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidPresentationModulePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                alias(libs.plugins.kotlin.compose)
            }
            dependencies {
                implementation(libs.androidx.lifecycle.runtime.ktx)
                implementation(platform(libs.androidx.compose.bom))
                implementation(libs.androidx.activity.compose)
                implementation(libs.androidx.ui.asProvider())
                implementation(libs.androidx.ui.graphics)
                implementation(libs.androidx.ui.tooling.asProvider())
                implementation(libs.androidx.material3)
                implementation(libs.androidx.ui.tooling.preview)

                implementation(libs.androidx.navigation.compose)
                implementation(libs.androidx.lifecycle.runtime.compose)
                implementation(libs.kotlinx.collections.immutable)
            }
        }
    }
}