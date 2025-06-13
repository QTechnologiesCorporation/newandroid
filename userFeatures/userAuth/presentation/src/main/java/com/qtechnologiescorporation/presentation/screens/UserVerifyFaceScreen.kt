package com.qtechnologiescorporation.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.designsystem.components.BaseScreen
import com.qtechnologiescorporation.designsystem.components.DescriptionText
import com.qtechnologiescorporation.designsystem.components.PrimaryButton
import com.qtechnologiescorporation.designsystem.components.PrimaryCustomAlertDialog
import com.qtechnologiescorporation.designsystem.components.PrimaryHeading
import com.qtechnologiescorporation.designsystem.spacing
import com.qtechnologiescorporation.presentation.stateAndEvents.VerifyFaceEvents
import com.qtechnologiescorporation.presentation.stateAndEvents.VerifyFaceStates
import com.qtechnologiescorporation.presentation.viewmodels.UserVerifyFaceViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserVerifyFaceScreen(
    viewModel: UserVerifyFaceViewModel = koinViewModel(),
) {
    val verifyFaceStates by viewModel.verifyFaceState.collectAsStateWithLifecycle()

    UserVerifyFaceScreenContent(
        verifyFaceStates = verifyFaceStates,
        verifyFaceEvents = viewModel::verifyFaceEvents,
    )
}

@Composable
fun UserVerifyFaceScreenContent(
    verifyFaceStates: VerifyFaceStates,
    verifyFaceEvents: (VerifyFaceEvents) -> Unit,
) {
    Scaffold { innerPadding ->
        BaseScreen(innerPadding = innerPadding, backgroundOffset = 1900f) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(MaterialTheme.spacing.medium),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                PrimaryHeading(
                    heading = "Quick Face Scan to Verify You",
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(
                            top = MaterialTheme.spacing.extraLarge
                        )
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
                DescriptionText(
                    description = "To confirm your identity, please complete the following short tasks. Make sure your face is clearly visible and you're in a well-lit space.",
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colorScheme.onSecondary,
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.mediumLarge))

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    PrimaryButton(
                        label = "Submit",
                        modifier = Modifier
                            .width(266.dp)
                            .padding(bottom = MaterialTheme.spacing.extraLarge * 2),
                        shape = RoundedCornerShape(25.dp),
                        onClick = {
                            verifyFaceEvents(VerifyFaceEvents.OnVerifyFace)
                        },
                    )
                }
                if (verifyFaceStates.isFaceVerified) {
                    PrimaryCustomAlertDialog(
                        title = "Scan Successfully Done!",
                        description = "You’ll receive a notification through SMS and Email once the verification is complete. In the meantime, you can continue exploring the app.",
                        onDismiss = {
                            verifyFaceEvents(VerifyFaceEvents.OnVerifyFace)
                        },
                        dismissOnBackPress = false,
                        dismissOnClickOutside = true
                    )
                }
            }
        }
    }
}

@Composable
@PreviewLightDark
fun UserVerifyFaceScreenPreview() {
    QTechHealthTheme {
        UserVerifyFaceScreenContent(
            verifyFaceStates = VerifyFaceStates(),
            verifyFaceEvents = {}
        )
    }
}