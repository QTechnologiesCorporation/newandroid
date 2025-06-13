package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qtechnologiescorporation.navigation.UserAuthNavigation
import com.qtechnologiescorporation.presentation.stateAndEvents.UploadDocumentsEvents
import com.qtechnologiescorporation.presentation.stateAndEvents.UploadDocumentsStates
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel


@KoinViewModel
class UserUploadDocumentsViewModel(
    private val navigation: UserAuthNavigation
) : ViewModel() {

    private val _uploadDocumentsState = MutableStateFlow(UploadDocumentsStates())
    val uploadDocumentsState = _uploadDocumentsState.asStateFlow()


    fun uploadDocumentsEvents(event: UploadDocumentsEvents) {
        when (event) {
            UploadDocumentsEvents.NavigateToSignUp -> {}
            is UploadDocumentsEvents.OnDocumentTypeSelected -> {
                _uploadDocumentsState.update {
                    it.copy(
                        selectedDocumentType = event.documentType
                    )
                }
            }

            is UploadDocumentsEvents.OnDocumentSelected -> {
                _uploadDocumentsState.update {
                    it.copy(
                        selectedDocumentUri = event.uri,
                        selectedDocumentName = event.documentName
                    )
                }
            }

            UploadDocumentsEvents.OnDocumentUpload -> {
                _uploadDocumentsState.update {
                    it.copy(
                        isDocumentUploadedSuccessfully = !uploadDocumentsState.value.isDocumentUploadedSuccessfully
                    )
                }
                uploadDocument()
            }
        }
    }

    private fun uploadDocument() {
        viewModelScope.launch {
            delay(2000)
            _uploadDocumentsState.update {
                it.copy(
                    isDocumentUploadedSuccessfully = false
                )
            }
            navigation.navigateToVerifyFace()
        }
    }
}
