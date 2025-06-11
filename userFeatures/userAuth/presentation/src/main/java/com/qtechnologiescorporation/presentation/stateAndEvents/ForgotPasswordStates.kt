package com.qtechnologiescorporation.presentation.stateAndEvents

data class ForgotPasswordStates(
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val confirmPassword: String = "",
    val confirmPasswordError: String? = null,
)

sealed class ForgotPasswordEvents {
    data class EmailChanged(val email: String) : ForgotPasswordEvents()
    data class PasswordChanged(val password: String) : ForgotPasswordEvents()
    data class ConfirmPasswordChanged(val confirmPassword: String) : ForgotPasswordEvents()
    data object NavigateToLogin : ForgotPasswordEvents()
}