package com.qtechnologiescorporation.presentation.viewmodels

data class SignInTextFieldStates(
    val username: String = "",
    val usernameError: String? = null,

    val password: String = "",
    val passwordError: String? = null,
)

sealed class SignInTextFieldEvents {
    data class UsernameChanged(val username: String) : SignInTextFieldEvents()
    data class PasswordChanged(val password: String) : SignInTextFieldEvents()
}

sealed class SignInEvents {
    data object NavigateToSignUp : SignInEvents()
}