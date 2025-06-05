package com.qtechnologiescorporation.qtechhealth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.compose.rememberNavController
import com.qtechnologiescorporation.api.NavControllerAccessor
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.presentation.viewmodels.UserAskTypeViewModel
import com.qtechnologiescorporation.qtechhealth.navigation.QTechNavGraph
import org.koin.android.ext.android.get
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QTechHealthTheme {
                val navController = rememberNavController()
                val navigationManager: NavControllerAccessor = get()

                DisposableEffect(navController) {
                    navigationManager.setController(navController)
                    onDispose {
                        navigationManager.clear()

                    }
                }

                QTechNavGraph(navController)
            }
        }
    }
}