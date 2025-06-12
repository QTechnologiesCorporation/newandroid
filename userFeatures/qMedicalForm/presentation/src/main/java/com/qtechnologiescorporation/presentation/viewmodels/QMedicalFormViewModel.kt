package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.qtechnologiescorporation.navigation.QMedicalFormNavigation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class QMedicalFormViewModel(
    private val navigation: QMedicalFormNavigation
) : ViewModel() {

    private val _state = MutableStateFlow(MedicalFormState())
    val state = _state.asStateFlow()
    private val _showSuccessModal = MutableStateFlow(false)
    val showSuccessModal = _showSuccessModal.asStateFlow()

    fun onEvent(event: MedicalFormEvent) {
        when (event) {
            is MedicalFormEvent.GenderChanged -> {
                Gender.fromString(event.gender)?.let { selectedGender ->
                    _state.update { currentState -> currentState.copy(gender = selectedGender) }
                }
            }
            is MedicalFormEvent.HeightUnitChanged -> {
                _state.update { it.copy(heightUnit = event.unit) }
            }
            is MedicalFormEvent.BloodGroupChanged -> {
                _state.update { it.copy(bloodGroup = FieldState(event.value)) }
            }
            is MedicalFormEvent.FeetChanged -> {
                _state.update { it.copy(feet = FieldState(event.value)) }
            }
            is MedicalFormEvent.InchesChanged -> {
                _state.update { it.copy(inches = FieldState(event.value)) }
            }
            is MedicalFormEvent.WeightChanged -> {
                _state.update { it.copy(weight = FieldState(event.value)) }
            }
            is MedicalFormEvent.CurrentTreatmentChanged -> {
                _state.update { it.copy(currentTreatment = FieldState(event.value)) }
            }
            is MedicalFormEvent.VisionProblemChanged -> {
                _state.update { it.copy(visionProblem = FieldState(event.value)) }
            }
            is MedicalFormEvent.DiagnosedConditionChanged -> {
                _state.update { it.copy(diagnosedCondition = FieldState(event.value)) }
            }
            is MedicalFormEvent.SurgeryHistoryChanged -> {
                _state.update { it.copy(surgeryHistory = FieldState(event.value)) }
            }
            is MedicalFormEvent.FamilyHistoryChanged -> {
                _state.update { it.copy(familyHistory = FieldState(event.value)) }
            }
            is MedicalFormEvent.SmokingChanged -> {
                _state.update { it.copy(smoking = FieldState(event.value)) }
            }
            is MedicalFormEvent.ExerciseChanged -> {
                _state.update { it.copy(exercise = FieldState(event.value)) }
            }
            is MedicalFormEvent.PhysicalDisabilityChanged -> {
                _state.update { it.copy(physicalDisability = FieldState(event.value)) }
            }
            is MedicalFormEvent.CurrentMedicationChanged -> {
                _state.update { it.copy(currentMedication = FieldState(event.value)) }
            }
            is MedicalFormEvent.AllergiesChanged -> {
                _state.update { it.copy(allergies = FieldState(event.value)) }
            }
            is MedicalFormEvent.MentalHealthChanged -> {
                _state.update { it.copy(mentalHealth = FieldState(event.value)) }
            }

            is MedicalFormEvent.TreatmentAnswerChanged -> {
                _state.update { it.copy(treatmentAnswer = event.value) }
            }
            is MedicalFormEvent.SmokeAnswerChanged -> {
                _state.update { it.copy(smokeAnswer = event.value) }
            }
            is MedicalFormEvent.ExerciseAnswerChanged -> {
                _state.update { it.copy(exerciseAnswer = event.value) }
            }
            MedicalFormEvent.SubmitStep1 -> validateStep1AndProceed()

            MedicalFormEvent.SubmitStep2 -> validateStep2AndSave()
        }
    }

    fun validateStep1AndProceed() {
        val current = _state.value
        var hasError = false

        fun validateField(value: String, fieldName: String): FieldState {
            return if (value.isBlank()) {
                hasError = true
                FieldState(value, error = "$fieldName is required")
            } else {
                FieldState(value)
            }
        }

        _state.update {
            it.copy(
                bloodGroup = validateField(current.bloodGroup.text, "Blood Group"),
                weight = validateField(current.weight.text, "Weight"),
                currentTreatment = validateField(current.currentTreatment.text, "Current Treatment"),
                visionProblem = validateField(current.visionProblem.text, "Phobias"),
                diagnosedCondition = validateField(current.diagnosedCondition.text, "Condition"),
                surgeryHistory = validateField(current.surgeryHistory.text, "Surgery History"),
                familyHistory = validateField(current.familyHistory.text, "Family History"),
                smoking = validateField(current.smoking.text, "Smoking Info"),
                exercise = validateField(current.exercise.text, "Exercise Info"),
                physicalDisability = validateField(current.physicalDisability.text, "Physical Disability")
            )
        }

        if (current.gender == null) {
            hasError = true
        }

        if (!hasError) {
            navigation.navigateToQMedicalFormScreen2()
        }
    }

    fun dismissSuccessModal() {
        _showSuccessModal.value = false
    }

    fun validateStep2AndSave() {
        val current = _state.value
        var hasError = false

        fun validateField(value: String, fieldName: String): FieldState {
            return if (value.isBlank()) {
                hasError = true
                FieldState(value, error = "$fieldName is required")
            } else {
                FieldState(value)
            }
        }

        _state.update {
            it.copy(
                currentMedication = validateField(current.currentMedication.text, "Medication"),
                allergies = FieldState(current.allergies.text), // optional, skip validation
                mentalHealth = FieldState(current.mentalHealth.text) // optional, skip validation
            )
        }

        if (!hasError) {
//            println("✅ Form Step 2 saved successfully with data: ${_state.value}")
            _showSuccessModal.value = true // 👈 Show the modal
        }
    }

}
