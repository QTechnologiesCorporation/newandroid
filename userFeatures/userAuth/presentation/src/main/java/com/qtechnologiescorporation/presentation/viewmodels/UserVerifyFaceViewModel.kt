package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.qtechnologiescorporation.navigation.UserAuthNavigation
import com.qtechnologiescorporation.presentation.stateAndEvents.UploadDocumentsEvents
import com.qtechnologiescorporation.presentation.stateAndEvents.UploadDocumentsStates
import com.qtechnologiescorporation.presentation.stateAndEvents.VerifyFaceEvents
import com.qtechnologiescorporation.presentation.stateAndEvents.VerifyFaceStates
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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
            }
        }
    }
}
