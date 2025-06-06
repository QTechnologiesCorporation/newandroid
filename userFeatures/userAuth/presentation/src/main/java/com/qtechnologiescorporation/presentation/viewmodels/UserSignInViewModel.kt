package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.qtechnologiescorporation.navigation.UserAskTypeNavigation
import com.qtechnologiescorporation.presentation.utils.Validator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.android.annotation.KoinViewModel


@KoinViewModel
class UserSignInViewModel(
    private val navigation: UserAskTypeNavigation
) : ViewModel() {

    private val _signInTextFieldState = MutableStateFlow(SignInTextFieldStates())
    val signInTextFieldState = _signInTextFieldState.asStateFlow()

    fun signInTextFieldEvents(event: SignInTextFieldEvents) {
        when (event) {

            is SignInTextFieldEvents.UsernameChanged -> {
                val error = Validator.validateSignInUsername(event.username)
                _signInTextFieldState.update {
                    it.copy(
                        username = event.username,
                        usernameError = error?.message
                    )
                }
            }

            is SignInTextFieldEvents.PasswordChanged -> {
                val error = Validator.validateSignInPassword(event.password)
                _signInTextFieldState.update {
                    it.copy(
                        password = event.password,
                        passwordError = error?.message
                    )
                }
            }
        }
    }

    fun signInEvents(event: SignInEvents) {
        when (event) {
            SignInEvents.NavigateToSignUp -> {
                navigation.navigateToSignUp()
            }
        }
    }
}
