package com.qtechnologiescorporation.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.designsystem.components.BaseScreen
import com.qtechnologiescorporation.designsystem.components.DescriptionText
import com.qtechnologiescorporation.designsystem.components.OutlinedDropdownField
import com.qtechnologiescorporation.designsystem.components.PrimaryHeading
import com.qtechnologiescorporation.designsystem.spacing
import com.qtechnologiescorporation.presentation.stateAndEvents.UploadDocumentsEvents
import com.qtechnologiescorporation.presentation.stateAndEvents.UploadDocumentsStates
import com.qtechnologiescorporation.presentation.viewmodels.UserUploadDocumentsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserUploadDocumentsScreen(
    viewModel: UserUploadDocumentsViewModel = koinViewModel(),
) {
    val uploadDocumentsStates by viewModel.uploadDocumentsState.collectAsStateWithLifecycle()
    UserUploadDocumentsScreenContent(
        uploadDocumentsStates = uploadDocumentsStates,
        uploadDocumentsEvents = viewModel::uploadDocumentsEvents
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UserUploadDocumentsScreenContent(
    uploadDocumentsStates: UploadDocumentsStates,
    uploadDocumentsEvents: (UploadDocumentsEvents) -> Unit,
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
                    heading = "Upload Your Documents",
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(
                            top = MaterialTheme.spacing.extraLarge
                        )
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
                DescriptionText(
                    description = "Securely verify your identity by uploading a valid document.",
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colorScheme.onSecondary,
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
                OutlinedDropdownField(
                    label = "Select Document",
                    value = uploadDocumentsStates.selectedDocumentType,
                    onValueChange = {
                        uploadDocumentsEvents(
                            UploadDocumentsEvents.OnDocumentTypeSelected(
                                it
                            )
                        )
                    },
                    items = listOf("National ID", "Passport", "Driving License"),
                    displayText = { it },
                    placeholder = {
                        Text("Choose document")
                    },
                )
            }
        }
    }
}

@Composable
@PreviewLightDark
fun UserUploadDocumentsScreenPreview() {
    QTechHealthTheme {
        UserUploadDocumentsScreenContent(
            uploadDocumentsStates = UploadDocumentsStates(),
            uploadDocumentsEvents = {}
        )
    }
}