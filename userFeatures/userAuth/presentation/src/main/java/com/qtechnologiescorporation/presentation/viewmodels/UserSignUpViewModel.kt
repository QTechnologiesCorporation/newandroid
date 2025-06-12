package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.qtechnologiescorporation.navigation.UserAuthNavigation
import com.qtechnologiescorporation.presentation.stateAndEvents.SignUpTextFieldEvents
import com.qtechnologiescorporation.presentation.stateAndEvents.SignUpTextFieldStates
import com.qtechnologiescorporation.presentation.utils.Validator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.android.annotation.KoinViewModel


@KoinViewModel
class UserSignUpViewModel(
    private val navigation: UserAuthNavigation
) : ViewModel() {

    private val _signUpTextFieldState = MutableStateFlow(SignUpTextFieldStates())
    val signUpTextFieldState = _signUpTextFieldState.asStateFlow()

    fun signUpEvents(event: SignUpTextFieldEvents) {
        when (event) {
            is SignUpTextFieldEvents.UsernameChanged -> {
                val error = Validator.validateUsername(event.username)
                _signUpTextFieldState.update {
                    it.copy(
                        username = event.username,
                        usernameError = error?.message
                    )
                }
            }

            is SignUpTextFieldEvents.NameChanged -> {
                val error = Validator.validateName(event.name)
                _signUpTextFieldState.update {
                    it.copy(
                        name = event.name,
                        nameError = error?.message
                    )
                }
            }

            is SignUpTextFieldEvents.EmailChanged -> {
                val error = Validator.validateEmail(event.email)
                _signUpTextFieldState.update {
                    it.copy(
                        email = event.email,
                        emailError = error?.message
                    )
                }
            }

            is SignUpTextFieldEvents.PhoneChanged -> {
                val error = Validator.validatePhoneNumber(event.phone)
                _signUpTextFieldState.update {
                    it.copy(
                        phone = event.phone,
                        phoneError = error?.message
                    )
                }
            }

            is SignUpTextFieldEvents.PasswordChanged -> {
                val error = Validator.validatePassword(event.password)
                _signUpTextFieldState.update {
                    it.copy(
                        password = event.password,
                        passwordError = error?.message
                    )
                }
            }

            is SignUpTextFieldEvents.ConfirmPasswordChanged -> {
                val error = Validator.validateConfirmPassword(
                    password = _signUpTextFieldState.value.password,
                    confirmPassword = event.confirmPassword
                )
                _signUpTextFieldState.update {
                    it.copy(
                        confirmPassword = event.confirmPassword,
                        confirmPasswordError = error?.message
                    )
                }
            }

            is SignUpTextFieldEvents.TermsAccepted -> {
                val error = Validator.validateTermsAccepted(event.termsAccepted)
                _signUpTextFieldState.update {
                    it.copy(
                        termsAccepted = event.termsAccepted,
                        termsError = error?.message
                    )
                }
            }

            SignUpTextFieldEvents.NavigateToUploadDocument -> {
                navigation.navigateToUploadDocument()
            }
        }
    }
}
