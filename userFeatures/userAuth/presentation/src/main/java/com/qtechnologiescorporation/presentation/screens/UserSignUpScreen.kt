package com.qtechnologiescorporation.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.designsystem.components.BaseScreen
import com.qtechnologiescorporation.designsystem.components.OutlinedInputField
import com.qtechnologiescorporation.designsystem.components.PrimaryButton
import com.qtechnologiescorporation.designsystem.components.PrimaryHeading
import com.qtechnologiescorporation.designsystem.spacing
import com.qtechnologiescorporation.presentation.components.TermsAndConditionsCheckbox
import com.qtechnologiescorporation.presentation.components.qTechTextFieldColors
import com.qtechnologiescorporation.presentation.stateAndEvents.SignUpTextFieldEvents
import com.qtechnologiescorporation.presentation.stateAndEvents.SignUpTextFieldStates
import com.qtechnologiescorporation.presentation.viewmodels.UserSignUpViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserSignUpScreen(
    viewModel: UserSignUpViewModel = koinViewModel(),
) {
    val signUpTextFieldStates by viewModel.signUpTextFieldState.collectAsStateWithLifecycle()
    UserSignUpScreenContent(
        signUpTextFieldStates = signUpTextFieldStates,
        signUpTextFieldEvent = viewModel::signUpEvents
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UserSignUpScreenContent(
    signUpTextFieldStates: SignUpTextFieldStates,
    signUpTextFieldEvent: (SignUpTextFieldEvents) -> Unit,
) {
    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }
    val textFieldColors = qTechTextFieldColors()
    val labelColor = MaterialTheme.colorScheme.onBackground

    Scaffold { innerPadding ->
        BaseScreen(innerPadding = innerPadding, backgroundOffset = 1900f) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                PrimaryHeading(
                    heading = "Create Account",
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(
                            horizontal = MaterialTheme.spacing.large,
                            vertical = MaterialTheme.spacing.extraLarge
                        )
                )

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
                OutlinedInputField(
                    label = "Username",
                    value = signUpTextFieldStates.username,
                    onChange = { signUpTextFieldEvent(SignUpTextFieldEvents.UsernameChanged(it)) },
                    modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
                    placeholder = {
                        Text("JhonDoe12@")
                    },
                    labelColor = labelColor,
                    colors = textFieldColors,
                    error = signUpTextFieldStates.usernameError
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
                OutlinedInputField(
                    label = "Full Name",
                    value = signUpTextFieldStates.name,
                    onChange = { signUpTextFieldEvent(SignUpTextFieldEvents.NameChanged(it)) },
                    modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
                    placeholder = {
                        Text("John Doe")
                    },
                    labelColor = labelColor,
                    colors = textFieldColors,
                    error = signUpTextFieldStates.nameError
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

                OutlinedInputField(
                    label = "Email",
                    value = signUpTextFieldStates.email,
                    onChange = { signUpTextFieldEvent(SignUpTextFieldEvents.EmailChanged(it)) },
                    modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
                    placeholder = {
                        Text("placeholder@mail.com")
                    },
                    labelColor = labelColor,
                    colors = textFieldColors,
                    error = signUpTextFieldStates.emailError
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
                OutlinedInputField(
                    label = "Mobile Number",
                    value = signUpTextFieldStates.phone,
                    onChange = { signUpTextFieldEvent(SignUpTextFieldEvents.PhoneChanged(it)) },
                    modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
                    placeholder = {
                        Text("+1234567890")
                    },
                    labelColor = labelColor,
                    colors = textFieldColors,
                    error = signUpTextFieldStates.phoneError
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
                OutlinedInputField(
                    label = "Password",
                    value = signUpTextFieldStates.password,
                    onChange = { signUpTextFieldEvent(SignUpTextFieldEvents.PasswordChanged(it)) },
                    modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
                    placeholder = {
                        Text("Alex@123")
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val icon =
                            if (passwordVisibility) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
                        IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                            Icon(
                                imageVector = icon,
                                contentDescription = "Toggle password visibility"
                            )
                        }
                    },
                    labelColor = labelColor,
                    colors = textFieldColors,
                    error = signUpTextFieldStates.passwordError
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
                OutlinedInputField(
                    label = "Confirm Password",
                    value = signUpTextFieldStates.confirmPassword,
                    onChange = {
                        signUpTextFieldEvent(
                            SignUpTextFieldEvents.ConfirmPasswordChanged(
                                it
                            )
                        )
                    },
                    modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
                    placeholder = {
                        Text("Alex@123")
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = if (confirmPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val icon =
                            if (confirmPasswordVisibility) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
                        IconButton(onClick = {
                            confirmPasswordVisibility = !confirmPasswordVisibility
                        }) {
                            Icon(
                                imageVector = icon,
                                contentDescription = "Toggle password visibility"
                            )
                        }
                    },
                    labelColor = labelColor,
                    colors = textFieldColors,
                    error = signUpTextFieldStates.confirmPasswordError
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
                TermsAndConditionsCheckbox(
                    isChecked = signUpTextFieldStates.termsAccepted,
                    onCheckedChange = { signUpTextFieldEvent(SignUpTextFieldEvents.TermsAccepted(it)) },
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraLarge))

                PrimaryButton(
                    label = "Sign Up",
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = MaterialTheme.colorScheme.onSecondary
                    ),
                    modifier = Modifier.width(266.dp),
                    shape = RoundedCornerShape(10.dp),
                )
            }
        }
    }
}

@Composable
@PreviewLightDark
fun UserSignUpPreview() {
    QTechHealthTheme {
        UserSignUpScreenContent(
            signUpTextFieldStates = SignUpTextFieldStates(),
            signUpTextFieldEvent = {}
        )
    }
}