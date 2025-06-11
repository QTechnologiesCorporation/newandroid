package com.qtechnologiescorporation.presentation.stateAndEvents

data class SignUpTextFieldStates(
    val username: String = "",
    val usernameError: String? = null,
    val name: String = "",
    val nameError: String? = null,
    val email: String = "",
    val emailError: String? = null,
    val phone: String = "",
    val phoneError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val confirmPassword: String = "",
    val confirmPasswordError: String? = null,
    val termsAccepted: Boolean = false,
    val termsError: String? = null
)

sealed class SignUpTextFieldEvents {
    data class UsernameChanged(val username: String) : SignUpTextFieldEvents()
    data class NameChanged(val name: String) : SignUpTextFieldEvents()
    data class EmailChanged(val email: String) : SignUpTextFieldEvents()
    data class PhoneChanged(val phone: String) : SignUpTextFieldEvents()
    data class PasswordChanged(val password: String) : SignUpTextFieldEvents()
    data class ConfirmPasswordChanged(val confirmPassword: String) : SignUpTextFieldEvents()
    data class TermsAccepted(val termsAccepted: Boolean) : SignUpTextFieldEvents()
}