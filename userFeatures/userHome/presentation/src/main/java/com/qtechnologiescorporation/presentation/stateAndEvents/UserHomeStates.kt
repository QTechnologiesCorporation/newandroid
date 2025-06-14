package com.qtechnologiescorporation.presentation.stateAndEvents

data class UserHomeStates(
    val isLoading: Boolean = false,
    val selectedDocumentUri: String? = null,
    val selectedDocumentUriError: String? = null,
    val selectedDocumentName: String = "",
)

sealed class UserHomeEvents {
    object NavigateToHealthData: UserHomeEvents()
    data class OnDocumentSelected(val uri: String, val documentName: String) : UserHomeEvents()

}