package com.qtechnologiescorporation.presentation

import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.qtechnologiescorporation.navigation.DetailsNavigation
import io.github.sceneview.Scene
import io.github.sceneview.animation.Transition.animateRotation
import io.github.sceneview.node.ModelNode
import io.github.sceneview.rememberCameraNode
import io.github.sceneview.rememberEngine
import io.github.sceneview.rememberEnvironmentLoader
import io.github.sceneview.rememberModelLoader
import io.github.sceneview.rememberNode
import org.koin.android.annotation.KoinViewModel
import org.koin.androidx.compose.koinViewModel
import kotlin.time.Duration.Companion.seconds
import kotlin.time.DurationUnit


@Composable
fun ScreenB(
    viewModel: UserProfileViewModel = koinViewModel(),
) {
    Box(modifier = Modifier.fillMaxSize().background(
        MaterialTheme.colorScheme.secondary
    ), contentAlignment = Alignment.Center) {
        Button(onClick = {
            viewModel.navigateToScreenA()
        }) {
            Text("Go to Screen A")
        }
    }
    MyScene()
}

@Composable
fun MyScene() {
    Box(modifier = Modifier.fillMaxSize()) {
        val engine = rememberEngine()
        val modelLoader = rememberModelLoader(engine)
        val environmentLoader = rememberEnvironmentLoader(engine)

        val cameraNode = rememberCameraNode(engine).apply {
            position = _root_ide_package_.io.github.sceneview.math.Position(z = 4.0f)
        }
        val centerNode = rememberNode(engine)
            .addChildNode(cameraNode)
        val cameraTransition = rememberInfiniteTransition(label = "CameraTransition")
        val cameraRotation by cameraTransition.animateRotation(
            initialValue = _root_ide_package_.io.github.sceneview.math.Rotation(y = 0.0f),
            targetValue = _root_ide_package_.io.github.sceneview.math.Rotation(y = 360.0f),
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 7.seconds.toInt(DurationUnit.MILLISECONDS))
            )
        )
        val modelNode = ModelNode(
            modelInstance = modelLoader.createModelInstance(
                assetFileLocation = "models/earth_hologram.glb"
            ),
            scaleToUnits = 1.0f
        )
        Scene(
            modifier = Modifier.fillMaxSize(),
            engine = engine,
            modelLoader = modelLoader,
            cameraNode = cameraNode,
            childNodes = listOf(
                centerNode,
                modelNode.also { node ->
                    DisposableEffect(node) {
                        onDispose {
                            node.destroy()
                        }
                    }
                }),
            environment = environmentLoader.createHDREnvironment(
                assetFileLocation = "environments/sky_2k.hdr"
            )!!,
            onFrame = {
                //centerNode.rotation = cameraRotation
                cameraNode.lookAt(centerNode)
            }
        )

    }
}

@KoinViewModel
class UserProfileViewModel(
    private val navigation: DetailsNavigation,
) : ViewModel() {

    fun navigateToScreenA() {
        navigation.navigateToScreenA()
    }
}