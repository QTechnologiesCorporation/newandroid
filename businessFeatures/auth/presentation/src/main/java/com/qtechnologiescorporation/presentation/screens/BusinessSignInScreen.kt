package com.qtechnologiescorporation.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.designsystem.components.primaryGradientBackground
import com.qtechnologiescorporation.presentation.viewmodels.BusinessSignInViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun BusinessSignInScreen(
    viewModel: BusinessSignInViewModel = koinViewModel(),
) {
    BusinessSignInScreenContent()
}

@Composable
fun BusinessSignInScreenContent() {

    Scaffold { innerPadding ->
        val backgroundBrush = primaryGradientBackground()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundBrush)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Business Sign In Screen", fontSize = 24.sp)
            }
        }
    }
}

@Composable
@PreviewLightDark
fun BusinessSignInPreview() {
    QTechHealthTheme {
        BusinessSignInScreenContent()
    }
}
