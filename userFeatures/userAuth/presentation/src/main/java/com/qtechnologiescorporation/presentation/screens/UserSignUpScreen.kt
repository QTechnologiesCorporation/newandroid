package com.qtechnologiescorporation.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.designsystem.components.OutlinedInputField
import com.qtechnologiescorporation.designsystem.components.PrimaryButton
import com.qtechnologiescorporation.designsystem.components.PrimaryHeading
import com.qtechnologiescorporation.designsystem.components.primaryGradientBackground
import com.qtechnologiescorporation.designsystem.spacing
import com.qtechnologiescorporation.presentation.viewmodels.SignUpTextFieldEvents
import com.qtechnologiescorporation.presentation.viewmodels.SignUpTextFieldStates
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

@Composable
fun UserSignUpScreenContent(
    signUpTextFieldStates: SignUpTextFieldStates,
    signUpTextFieldEvent: (SignUpTextFieldEvents) -> Unit,
) {

    Scaffold { innerPadding ->
        val backgroundBrush = primaryGradientBackground(1900f)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundBrush)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                PrimaryHeading(
                    heading = "Create Account",
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(
                            horizontal = MaterialTheme.spacing.large,
                            vertical = MaterialTheme.spacing.large
                        )
                )

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
                OutlinedInputField(
                    label = "Username",
                    value = signUpTextFieldStates.username,
                    onChange = { signUpTextFieldEvent(SignUpTextFieldEvents.UsernameChanged(it)) },
                    modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
                    placeholder = {
                        Text("JhonDoe12@")
                    },
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
                    error = signUpTextFieldStates.phoneError
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
                OutlinedInputField(
                    label = "Password",
                    value = signUpTextFieldStates.password,
                    onChange = { signUpTextFieldEvent(SignUpTextFieldEvents.PasswordChanged(it)) },
                    modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
                    placeholder = {
                        Text("+1234567890")
                    },
                    error = signUpTextFieldStates.passwordError
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
                OutlinedInputField(
                    label = "Confirm Password",
                    value = signUpTextFieldStates.confirmPassword,
                    onChange = { signUpTextFieldEvent(SignUpTextFieldEvents.ConfirmPasswordChanged(it)) },
                    modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
                    placeholder = {
                        Text("+1234567890")
                    },
                    error = signUpTextFieldStates.confirmPasswordError
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