package com.qtechnologiescorporation.presentation.viewmodels

// Events for user interactions
sealed class MedicalFormEvent {
    data class GenderChanged(val gender: String) : MedicalFormEvent()
    data class HeightUnitChanged(val unit: String) : MedicalFormEvent()
    data class BloodGroupChanged(val value: String) : MedicalFormEvent()
    data class FeetChanged(val value: String) : MedicalFormEvent()
    data class InchesChanged(val value: String) : MedicalFormEvent()
    data class WeightChanged(val value: String) : MedicalFormEvent()
    data class CurrentTreatmentChanged(val value: String) : MedicalFormEvent()
    data class VisionProblemChanged(val value: String) : MedicalFormEvent()
    data class DiagnosedConditionChanged(val value: String) : MedicalFormEvent()
    data class SurgeryHistoryChanged(val value: String) : MedicalFormEvent()
    data class FamilyHistoryChanged(val value: String) : MedicalFormEvent()
    data class SmokingChanged(val value: String) : MedicalFormEvent()
    data class ExerciseChanged(val value: String) : MedicalFormEvent()
    data class PhysicalDisabilityChanged(val value: String) : MedicalFormEvent()
    data class CurrentMedicationChanged(val value: String) : MedicalFormEvent()
    data class AllergiesChanged(val value: String) : MedicalFormEvent()
    data class MentalHealthChanged(val value: String) : MedicalFormEvent()

    data class TreatmentAnswerChanged(val value: String) : MedicalFormEvent()
    data class SmokeAnswerChanged(val value: String) : MedicalFormEvent()
    data class ExerciseAnswerChanged(val value: String) : MedicalFormEvent()

    object SubmitStep1 : MedicalFormEvent()
    object SubmitStep2 : MedicalFormEvent()
}



// Wrapper class for input + error
data class FieldState(
    val text: String = "",
    val error: String? = null
)

// App UI State for Medical Form
data class MedicalFormState(
    val gender: Gender? = null,  // Use enum for strong typing
    val bloodGroup: FieldState = FieldState(),
    val feet: FieldState = FieldState(),
    val inches: FieldState = FieldState(),
    val weight: FieldState = FieldState(),
    val heightUnit: String = "ft",

    val currentTreatment: FieldState = FieldState(),
    val visionProblem: FieldState = FieldState(),
    val diagnosedCondition: FieldState = FieldState(),
    val surgeryHistory: FieldState = FieldState(),
    val familyHistory: FieldState = FieldState(),
    val smoking: FieldState = FieldState(),
    val exercise: FieldState = FieldState(),
    val physicalDisability: FieldState = FieldState(),

    val currentMedication: FieldState = FieldState(),
    val allergies: FieldState = FieldState(),
    val mentalHealth: FieldState = FieldState(),

    val treatmentAnswer: String = "", // "Yes" or "No"
    val smokeAnswer: String = "",
    val exerciseAnswer: String = ""

)

// Enum for Gender options
enum class Gender(val displayName: String) {
    Male("Male"),
    Female("Female"),
    Other("Other");

    companion object {
        fun fromString(value: String): Gender? {
            return entries.firstOrNull { it.displayName.equals(value, ignoreCase = true) }
        }
    }
}
