package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.qtechnologiescorporation.navigation.UserAuthNavigation
import com.qtechnologiescorporation.presentation.stateAndEvents.UploadDocumentsEvents
import com.qtechnologiescorporation.presentation.stateAndEvents.UploadDocumentsStates
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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
        }
    }
}
