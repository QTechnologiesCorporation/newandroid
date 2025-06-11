package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.qtechnologiescorporation.navigation.UserAuthNavigation
import com.qtechnologiescorporation.presentation.stateAndEvents.ForgotPasswordEvents
import com.qtechnologiescorporation.presentation.stateAndEvents.ForgotPasswordStates
import com.qtechnologiescorporation.presentation.stateAndEvents.SignInEvents
import com.qtechnologiescorporation.presentation.utils.Validator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.android.annotation.KoinViewModel


@KoinViewModel
class UserForgotPasswordViewModel(
    private val navigation: UserAuthNavigation
) : ViewModel() {

    private val _forgotPasswordStates = MutableStateFlow(ForgotPasswordStates())
    val forgotPasswordState = _forgotPasswordStates.asStateFlow()

    fun forgotPasswordEvents(event: ForgotPasswordEvents) {
        when (event) {
            is ForgotPasswordEvents.EmailChanged -> {
                val error = Validator.validateEmail(event.email)
                _forgotPasswordStates.update {
                    it.copy(
                        email = event.email,
                        emailError = error?.message
                    )
                }
            }
            is ForgotPasswordEvents.PasswordChanged -> {
                val error = Validator.validatePassword(event.password)
                _forgotPasswordStates.update {
                    it.copy(
                        password = event.password,
                        passwordError = error?.message
                    )
                }
            }
            is ForgotPasswordEvents.ConfirmPasswordChanged -> {
                val error = Validator.validateConfirmPassword(
                    password = _forgotPasswordStates.value.password,
                    confirmPassword = event.confirmPassword
                )
                _forgotPasswordStates.update {
                    it.copy(
                        confirmPassword = event.confirmPassword,
                        confirmPasswordError = error?.message
                    )
                }
            }

            ForgotPasswordEvents.NavigateToLogin -> {
                navigation.navigateToLogin()
            }
        }
    }
}
