package com.qtechnologiescorporation.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.qtechnologiescorporation.designsystem.components.OutlinedInputField
import com.qtechnologiescorporation.designsystem.components.PrimaryButton
import com.qtechnologiescorporation.presentation.components.qTechTextFieldColors
import com.qtechnologiescorporation.presentation.viewmodels.MedicalFormEvent
import com.qtechnologiescorporation.presentation.viewmodels.QMedicalFormViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun QMedicalFormScreen2(
    viewModel: QMedicalFormViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val showSuccessModal by viewModel.showSuccessModal.collectAsStateWithLifecycle()

    QMedicalFormScreen2Content(
        state = state,
        onEvent = viewModel::onEvent
    )

    if (showSuccessModal) {
        AlertDialog(
            onDismissRequest = { viewModel.dismissSuccessModal() },
            title = { Text("Success") },
            text = { Text("Form submitted successfully!") },
            confirmButton = {
                TextButton(onClick = { viewModel.dismissSuccessModal() }) {
                    Text("OK")
                }
            },
            shape = RoundedCornerShape(16.dp)
        )
    }
}


@Composable
fun QMedicalFormScreen2Content(
    state: com.qtechnologiescorporation.presentation.viewmodels.MedicalFormState,
    onEvent: (MedicalFormEvent) -> Unit
) {
    val textFieldColors = qTechTextFieldColors()
    val labelColor = MaterialTheme.colorScheme.onBackground

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Current Medication
            OutlinedInputField(
                label = "Are you currently taking any prescribed or over-the-counter medications? *",
                value = state.currentMedication.text,
                onChange = { onEvent(MedicalFormEvent.CurrentMedicationChanged(it)) },
                placeholder = { Text("Lorem ipsum") },
                labelColor = labelColor,
                colors = textFieldColors,
                error = state.currentMedication.error
            )

            // Allergies
            OutlinedInputField(
                label = "Do you have any known allergies?",
                value = state.allergies.text,
                onChange = { onEvent(MedicalFormEvent.AllergiesChanged(it)) },
                placeholder = { Text("Lorem") },
                labelColor = labelColor,
                colors = textFieldColors,
                error = state.allergies.error
            )

            // Mental Health
            OutlinedInputField(
                label = "Do you have any history of mental health conditions or treatments",
                value = state.mentalHealth.text,
                onChange = { onEvent(MedicalFormEvent.MentalHealthChanged(it)) },
                placeholder = { Text("56") },
                labelColor = labelColor,
                colors = textFieldColors,
                error = state.mentalHealth.error
            )

            Spacer(modifier = Modifier.height(32.dp))

            PrimaryButton(
                label = "Save",
                onClick = { onEvent(MedicalFormEvent.SubmitStep2) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.onSecondary
                ),
                modifier = Modifier
                    .width(200.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(26.dp)
            )
        }
    }
}
