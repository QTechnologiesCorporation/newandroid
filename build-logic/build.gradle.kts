import org.gradle.initialization.DependenciesAccessors
import org.gradle.kotlin.dsl.support.serviceOf

plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)

    gradle.serviceOf<DependenciesAccessors>().classes.asFiles.forEach {
        compileOnly(files(it.absolutePath))
    }
}

group = "com.qtechnologiescorporation.build-logic"

gradlePlugin {
    plugins {
        register("moduleAndroidApplication") {
            id = "com.qtechnologiescorporation.module.android.application"
            implementationClass = "com.qtechnologiescorporation.build_logic.AndroidApplicationModulePlugin"
        }
        register("moduleAndroidLibrary") {
            id = "com.qtechnologiescorporation.module.android.library"
            implementationClass = "com.qtechnologiescorporation.build_logic.AndroidLibraryModulePlugin"
        }
        register("moduleAndroidPresentation") {
            id = "com.qtechnologiescorporation.module.android.presentation"
            implementationClass = "com.qtechnologiescorporation.build_logic.AndroidPresentationModulePlugin"
        }
    }
}
