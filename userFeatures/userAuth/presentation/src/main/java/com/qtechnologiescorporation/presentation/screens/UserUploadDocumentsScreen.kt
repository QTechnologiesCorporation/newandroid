package com.qtechnologiescorporation.presentation.screens

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.designsystem.R
import com.qtechnologiescorporation.designsystem.components.BaseScreen
import com.qtechnologiescorporation.designsystem.components.DescriptionText
import com.qtechnologiescorporation.designsystem.components.OutlinedDropdownField
import com.qtechnologiescorporation.designsystem.components.PrimaryButton
import com.qtechnologiescorporation.designsystem.components.PrimaryHeading
import com.qtechnologiescorporation.designsystem.components.PrimaryCustomAlertDialog
import com.qtechnologiescorporation.designsystem.components.UploadDocumentBox
import com.qtechnologiescorporation.designsystem.components.dashedBorder
import com.qtechnologiescorporation.designsystem.spacing
import com.qtechnologiescorporation.designsystem.utils.rememberFilePickerLauncher
import com.qtechnologiescorporation.presentation.stateAndEvents.UploadDocumentsEvents
import com.qtechnologiescorporation.presentation.stateAndEvents.UploadDocumentsStates
import com.qtechnologiescorporation.presentation.viewmodels.UserUploadDocumentsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserUploadDocumentsScreen(
    viewModel: UserUploadDocumentsViewModel = koinViewModel(),
) {
    val uploadDocumentsStates by viewModel.uploadDocumentsState.collectAsStateWithLifecycle()

    val launchFilePicker = rememberFilePickerLauncher { uri, fileName ->
        viewModel.uploadDocumentsEvents(
            UploadDocumentsEvents.OnDocumentSelected(uri = uri, documentName = fileName)
        )
    }

    UserUploadDocumentsScreenContent(
        uploadDocumentsStates = uploadDocumentsStates,
        uploadDocumentsEvents = viewModel::uploadDocumentsEvents,
        onSelectFile = {
            launchFilePicker()
        }
    )
}
@Composable
fun UserUploadDocumentsScreenContent(
    uploadDocumentsStates: UploadDocumentsStates,
    uploadDocumentsEvents: (UploadDocumentsEvents) -> Unit,
    onSelectFile: () -> Unit
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
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.mediumLarge))
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
                        Text("Choose document", color = MaterialTheme.colorScheme.onSecondary)
                    },
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
                UploadDocumentBox(
                    onSelectFile = { onSelectFile.invoke() },
                    documentSelectedStatus = uploadDocumentsStates.selectedDocumentUri != null,
                    selectedDocumentName = uploadDocumentsStates.selectedDocumentName,
                )

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ){
                    PrimaryButton(
                        label = "Upload Document",
                        modifier = Modifier
                            .width(266.dp).padding(bottom = MaterialTheme.spacing.extraLarge*2),
                        shape = RoundedCornerShape(25.dp),
                        onClick = {
                            uploadDocumentsEvents(UploadDocumentsEvents.OnDocumentUpload)
                        },
                    )
                }
                if (uploadDocumentsStates.isDocumentUploadedSuccessfully){
                    PrimaryCustomAlertDialog(
                        title = "Successfully Uploaded",
                        description = null,
                        onDismiss = { },
                        dismissOnBackPress = false,
                        dismissOnClickOutside = false
                    )
                }
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
            uploadDocumentsEvents = {},
            onSelectFile = {}
        )
    }
}