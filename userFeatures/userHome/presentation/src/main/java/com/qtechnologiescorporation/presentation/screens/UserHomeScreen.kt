package com.qtechnologiescorporation.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.designsystem.components.BaseScreen
import com.qtechnologiescorporation.designsystem.components.UploadDocumentBox
import com.qtechnologiescorporation.designsystem.spacing
import com.qtechnologiescorporation.designsystem.utils.rememberFilePickerLauncher
import com.qtechnologiescorporation.designsystem.utils.CustomPaddingValues.bottomBarPaddingForScaffold
import com.qtechnologiescorporation.presentation.R
import com.qtechnologiescorporation.presentation.components.HealthIndexComponent
import com.qtechnologiescorporation.presentation.components.HomeScreenTopBar
import com.qtechnologiescorporation.presentation.stateAndEvents.UserHomeEvents
import com.qtechnologiescorporation.presentation.stateAndEvents.UserHomeStates
import com.qtechnologiescorporation.presentation.viewmodels.UserHomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserHomeScreen(
    viewModel: UserHomeViewModel = koinViewModel(),
) {
    val homeStates by viewModel.homeState.collectAsStateWithLifecycle()

    val launchFilePicker = rememberFilePickerLauncher { uri, fileName ->
        viewModel.userHomeEvents(
            UserHomeEvents.OnDocumentSelected(uri = uri, documentName = fileName)
        )
    }
    UserHomeScreenContent(
        userHomeStates = homeStates,
        homeEvents = viewModel::userHomeEvents,
        onSelectFile = {
            launchFilePicker()
        },
    )
}

@Composable
fun UserHomeScreenContent(
    userHomeStates: UserHomeStates,
    homeEvents: (UserHomeEvents) -> Unit,
    onSelectFile: () -> Unit
) {
    Scaffold(
        contentWindowInsets = bottomBarPaddingForScaffold,
        topBar = {
            HomeScreenTopBar(
                onProfileClick = { },
                onNotificationClick = { }
            )
        }
    ) { innerPadding ->
        BaseScreen(innerPadding = innerPadding, backgroundOffset = 1900f) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(MaterialTheme.spacing.medium)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                HumanBodyHighlight()
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
                HealthIndexComponent()
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
                UploadDocumentBox(
                    onSelectFile = { onSelectFile.invoke() },
                    documentSelectedStatus = userHomeStates.selectedDocumentUri != null,
                    selectedDocumentName = userHomeStates.selectedDocumentName,
                )
            }
        }
    }
}


@Composable
fun HumanBodyHighlight() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .background(
                brush = if (isSystemInDarkTheme()) {
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF0C1B16),
                            Color(0xFF00362E),
                            Color(0xFF0C1B16)
                        )
                    )
                } else {
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF00D998).copy(alpha = 0.5f),
                            Color.White.copy(alpha = 0.5f),
                            Color(0xFF00D998).copy(alpha = 0.5f)
                        )
                    )
                },
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.human),
            contentDescription = "Human Body",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )

//        // Example red dots on joints
//        val red = Color.Red
//        val dotSize = 12.dp
//
//        Box(
//            modifier = Modifier
//                .size(dotSize)
//                .background(red, CircleShape)
//                .align(Alignment.TopCenter)
//                .offset(y = 80.dp)
//        )
//
//        Box(
//            modifier = Modifier
//                .size(dotSize)
//                .background(red, CircleShape)
//                .align(Alignment.CenterStart)
//                .offset(x = 40.dp)
//        )
//
//        Box(
//            modifier = Modifier
//                .size(dotSize)
//                .background(red, CircleShape)
//                .align(Alignment.CenterEnd)
//                .offset(x = (-40).dp)
//        )
    }
}

@Composable
@PreviewLightDark
fun UserHomeScreenPreview() {
    QTechHealthTheme {
        UserHomeScreenContent(
            userHomeStates = UserHomeStates(),
            homeEvents = {},
            onSelectFile = {}
        )
    }
}