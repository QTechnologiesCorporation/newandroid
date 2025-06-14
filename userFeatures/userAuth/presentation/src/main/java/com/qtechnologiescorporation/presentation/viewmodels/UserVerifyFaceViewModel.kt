package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qtechnologiescorporation.navigation.UserAuthNavigation
import com.qtechnologiescorporation.presentation.stateAndEvents.UploadDocumentsEvents
import com.qtechnologiescorporation.presentation.stateAndEvents.UploadDocumentsStates
import com.qtechnologiescorporation.presentation.stateAndEvents.VerifyFaceEvents
import com.qtechnologiescorporation.presentation.stateAndEvents.VerifyFaceStates
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel


@KoinViewModel
class UserVerifyFaceViewModel(
    private val navigation: UserAuthNavigation
) : ViewModel() {

    private val _verifyFaceState = MutableStateFlow(VerifyFaceStates())
    val verifyFaceState = _verifyFaceState.asStateFlow()

    fun verifyFaceEvents(event: VerifyFaceEvents) {
        when (event) {
            VerifyFaceEvents.OnVerifyFace -> {
                _verifyFaceState.update {
                    it.copy(
                        isFaceVerified = !it.isFaceVerified
                    )
                }
                verifyFace()
            }
        }
    }

    private fun verifyFace() {
        viewModelScope.launch {
            delay(1000)
            _verifyFaceState.update {
                it.copy(
                    isFaceVerified = false
                )
            }
            navigation.navigateToHomeScreen()
        }
    }
}
