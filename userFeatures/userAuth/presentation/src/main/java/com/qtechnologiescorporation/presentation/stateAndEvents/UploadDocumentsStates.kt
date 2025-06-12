package com.qtechnologiescorporation.presentation.stateAndEvents

data class UploadDocumentsStates(
    val username: String = "",
    val selectedDocumentType: String = "",
    val selectedDocumentError: String? = null,
)

sealed class UploadDocumentsEvents {
    data object NavigateToSignUp : UploadDocumentsEvents()
    data class OnDocumentTypeSelected(val documentType: String) : UploadDocumentsEvents()
}