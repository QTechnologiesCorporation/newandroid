package com.qtechnologiescorporation.presentation.stateAndEvents

data class UploadDocumentsStates(
    val selectedDocumentUri: String? = null,
    val selectedDocumentUriError: String? = null,
    val selectedDocumentName: String = "",
    val selectedDocumentType: String = "",
    val selectedDocumentTypeError: String? = null,
    val isDocumentUploadedSuccessfully: Boolean = false
)

sealed class UploadDocumentsEvents {
    data object NavigateToSignUp : UploadDocumentsEvents()
    data class OnDocumentTypeSelected(val documentType: String) : UploadDocumentsEvents()
    data class OnDocumentSelected(val uri: String, val documentName: String) : UploadDocumentsEvents()
    data object OnDocumentUpload : UploadDocumentsEvents()

}