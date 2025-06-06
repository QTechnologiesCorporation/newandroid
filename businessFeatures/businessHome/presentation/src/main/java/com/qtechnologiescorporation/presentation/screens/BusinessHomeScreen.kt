package com.qtechnologiescorporation.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.designsystem.components.primaryContainerGradientBackground
import com.qtechnologiescorporation.designsystem.components.primaryGradientBackground
import com.qtechnologiescorporation.presentation.viewmodels.BusinessHomeViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun BusinessHomeScreen(
    viewModel: BusinessHomeViewModel = koinViewModel(),
) {
    BusinessHomeScreenContent()
}

@Composable
fun BusinessHomeScreenContent() {

    Scaffold { innerPadding ->
        val backgroundBrush = primaryGradientBackground(1900f)
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
                Card(
                    shape = RoundedCornerShape(20.dp),
                    //colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .fillMaxHeight(0.6f)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(primaryContainerGradientBackground()),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {


                    }
                }
            }
        }
    }
}

@Composable
@PreviewLightDark
fun BusinessHomeScreenContentPreview() {
    QTechHealthTheme {
        BusinessHomeScreenContent()
    }
}
