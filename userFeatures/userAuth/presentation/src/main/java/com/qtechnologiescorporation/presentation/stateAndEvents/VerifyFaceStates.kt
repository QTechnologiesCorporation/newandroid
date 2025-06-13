package com.qtechnologiescorporation.presentation.stateAndEvents

data class VerifyFaceStates(
    val faceImageUri: String = "",
    val isFaceVerified: Boolean = false
)

sealed class VerifyFaceEvents {
    object OnVerifyFace: VerifyFaceEvents()
}