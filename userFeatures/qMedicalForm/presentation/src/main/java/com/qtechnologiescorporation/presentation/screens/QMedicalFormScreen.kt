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
import com.qtechnologiescorporation.designsystem.components.HeightInputField
import com.qtechnologiescorporation.designsystem.components.OutlinedInputField
import com.qtechnologiescorporation.designsystem.components.PrimaryButton
import com.qtechnologiescorporation.designsystem.components.YesNoDropdown
import com.qtechnologiescorporation.designsystem.spacing
import com.qtechnologiescorporation.presentation.components.qTechTextFieldColors
import com.qtechnologiescorporation.presentation.viewmodels.*
import org.koin.androidx.compose.koinViewModel

@Composable
fun QMedicalFormScreen(
    viewModel: QMedicalFormViewModel = koinViewModel()
) {
    val formState by viewModel.state.collectAsStateWithLifecycle()

    QMedicalFormScreenContent(
        state = formState,
        onEvent = viewModel::onEvent,
        validateAndProceed = { viewModel.onEvent(MedicalFormEvent.SubmitStep1) }
    )
}

@Composable
fun QMedicalFormScreenContent(
    state: MedicalFormState,
    onEvent: (MedicalFormEvent) -> Unit,
    validateAndProceed: () -> Unit
) {
    val textFieldColors = qTechTextFieldColors()
    val labelColor = MaterialTheme.colorScheme.onBackground

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Gender*", style = MaterialTheme.typography.labelLarge)
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Gender.values().forEach { genderOption ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = state.gender == genderOption,
                            onClick = { onEvent(MedicalFormEvent.GenderChanged(genderOption.name)) }
                        )
                        Text(genderOption.displayName)
                    }
                }


            }

            OutlinedInputField(
                label = "Blood Group*",
                value = state.bloodGroup.text,
                onChange = { onEvent(MedicalFormEvent.BloodGroupChanged(it)) },
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
                placeholder = { Text("A") },
                labelColor = labelColor,
                colors = textFieldColors,
                error = state.bloodGroup.error
            )

            HeightInputField(
                value = state.weight.text,
                selectedUnit = state.heightUnit,
                onValueChange = { onEvent(MedicalFormEvent.WeightChanged(it)) },
                onUnitChange = { onEvent(MedicalFormEvent.HeightUnitChanged(it)) },
                error = state.weight.error,
                labelColor = labelColor,
                textFieldColors = textFieldColors,
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large)
            )

//            OutlinedInputField(
//                label = "Are you currently under any medical treatment?*",
//                value = state.currentTreatment.text,
//                onChange = { onEvent(MedicalFormEvent.CurrentTreatmentChanged(it)) },
//                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
//                placeholder = { Text("None") },
//                labelColor = labelColor,
//                colors = textFieldColors,
//                error = state.currentTreatment.error
//            )

            YesNoDropdown(
                label = "Are you currently under any medical treatment?*",
                selected = state.treatmentAnswer,
                onSelectedChange = { onEvent(MedicalFormEvent.TreatmentAnswerChanged(it)) },
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large)
            )

            if (state.treatmentAnswer == "Yes") {
                OutlinedInputField(
                    label = "Please specify treatment details",
                    value = state.currentTreatment.text,
                    onChange = { onEvent(MedicalFormEvent.CurrentTreatmentChanged(it)) },
                    modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
                    placeholder = { Text("e.g., diabetes, asthma meds") },
                    labelColor = labelColor,
                    colors = textFieldColors,
                    error = state.currentTreatment.error
                )
            }

            OutlinedInputField(
                label = "Do you have any known phobias?*",
                value = state.visionProblem.text,
                onChange = { onEvent(MedicalFormEvent.VisionProblemChanged(it)) },
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
                placeholder = { Text("Heights, darkness...") },
                labelColor = labelColor,
                colors = textFieldColors,
                error = state.visionProblem.error
            )

            OutlinedInputField(
                label = "Have you been diagnosed with a condition?*",
                value = state.diagnosedCondition.text,
                onChange = { onEvent(MedicalFormEvent.DiagnosedConditionChanged(it)) },
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
                placeholder = { Text("None") },
                labelColor = labelColor,
                colors = textFieldColors,
                error = state.diagnosedCondition.error
            )

            OutlinedInputField(
                label = "Major surgeries or serious illnesses?*",
                value = state.surgeryHistory.text,
                onChange = { onEvent(MedicalFormEvent.SurgeryHistoryChanged(it)) },
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
                placeholder = { Text("No") },
                labelColor = labelColor,
                colors = textFieldColors,
                error = state.surgeryHistory.error
            )

            OutlinedInputField(
                label = "Family history of chronic conditions?*",
                value = state.familyHistory.text,
                onChange = { onEvent(MedicalFormEvent.FamilyHistoryChanged(it)) },
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
                placeholder = { Text("Diabetes, Heart") },
                labelColor = labelColor,
                colors = textFieldColors,
                error = state.familyHistory.error
            )

//            OutlinedInputField(
//                label = "Do you Smoke?*",
//                value = state.smoking.text,
//                onChange = { onEvent(MedicalFormEvent.SmokingChanged(it)) },
//                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
//                placeholder = { Text("No") },
//                labelColor = labelColor,
//                colors = textFieldColors,
//                error = state.smoking.error
//            )
            YesNoDropdown(
                label = "Do you Smoke?*",
                selected = state.smokeAnswer,
                onSelectedChange = { onEvent(MedicalFormEvent.SmokeAnswerChanged(it)) },
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large)
            )


//            OutlinedInputField(
//                label = "Do you exercise regularly?*",
//                value = state.exercise.text,
//                onChange = { onEvent(MedicalFormEvent.ExerciseChanged(it)) },
//                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
//                placeholder = { Text("Yes") },
//                labelColor = labelColor,
//                colors = textFieldColors,
//                error = state.exercise.error
//            )

            YesNoDropdown(
                label = "Do you exercise regularly?*",
                selected = state.exerciseAnswer,
                onSelectedChange = { onEvent(MedicalFormEvent.ExerciseAnswerChanged(it)) },
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large)
            )

            OutlinedInputField(
                label = "Any physical disabilities?*",
                value = state.physicalDisability.text,
                onChange = { onEvent(MedicalFormEvent.PhysicalDisabilityChanged(it)) },
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
                placeholder = { Text("None") },
                labelColor = labelColor,
                colors = textFieldColors,
                error = state.physicalDisability.error
            )

            Spacer(modifier = Modifier.height(24.dp))

            PrimaryButton(
                label = "Proceed",
                onClick = validateAndProceed,

                modifier = Modifier
                    .width(266.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(26.dp),
            )
//            PrimaryButton(
//                label = "Sign Up",
//                onClick = { },
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = MaterialTheme.colorScheme.secondary,
//                    contentColor = MaterialTheme.colorScheme.onSecondary
//                ),
//                modifier = Modifier.width(266.dp),
//                shape = RoundedCornerShape(10.dp),
//            )
        }
    }
}
