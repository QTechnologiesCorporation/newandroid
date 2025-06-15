package com.qtechnologiescorporation.qtechhealth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.DisposableEffect
import androidx.navigation.compose.rememberNavController
import com.qtechnologiescorporation.api.NavControllerAccessor
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.navigation.UserAskTypeRoute
import com.qtechnologiescorporation.qtechhealth.navigation.QTechApp
import org.koin.android.ext.android.get

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QTechHealthTheme {
                val qTechNavController = rememberNavController()
                val navigationManager: NavControllerAccessor = get()

                DisposableEffect(qTechNavController) {
                    navigationManager.setController(qTechNavController)
                    onDispose {
                        navigationManager.clear()
                    }
                }
                QTechApp(
                    // this is wrong way to achieve this but for now it is for temporary purpose
                    //i must need to achieve this using navigation manager
                    qTechNavController = qTechNavController,
                    startDestination = UserAskTypeRoute
                )
            }
        }
    }
}