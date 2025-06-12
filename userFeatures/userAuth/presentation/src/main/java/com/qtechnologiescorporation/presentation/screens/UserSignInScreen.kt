package com.qtechnologiescorporation.presentation.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.designsystem.components.BaseCardScreen
import com.qtechnologiescorporation.designsystem.components.OutlinedInputField
import com.qtechnologiescorporation.designsystem.components.PrimaryButton
import com.qtechnologiescorporation.designsystem.components.SecondaryHeadingAndSubHeading
import com.qtechnologiescorporation.designsystem.spacing
import com.qtechnologiescorporation.presentation.stateAndEvents.SignInEvents
import com.qtechnologiescorporation.presentation.stateAndEvents.SignInTextFieldEvents
import com.qtechnologiescorporation.presentation.stateAndEvents.SignInTextFieldStates
import com.qtechnologiescorporation.presentation.viewmodels.UserSignInViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun UserSignInScreen(
    viewModel: UserSignInViewModel = koinViewModel(),
) {
    val loginTextFieldStates by viewModel.signInTextFieldState.collectAsStateWithLifecycle()
    UserSignInScreenContent(
        signInTextFieldStates = loginTextFieldStates,
        signInTextFieldEvent = viewModel::signInTextFieldEvents,
        signInEvent = viewModel::signInEvents
    )
}

@Composable
fun UserSignInScreenContent(
    signInTextFieldStates: SignInTextFieldStates,
    signInTextFieldEvent: (SignInTextFieldEvents) -> Unit,
    signInEvent: (SignInEvents) -> Unit,
) {
    var passwordVisibility by remember { mutableStateOf(false) }

    Scaffold { innerPadding ->
        BaseCardScreen(innerPadding = innerPadding, backgroundOffset = 1900f) {
            SecondaryHeadingAndSubHeading(
                heading = "Welcome to Q Life!",
                subheading = "Your Centralized Health Data Hub"
            )

            Text(
                text = "Login",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W700
                ),
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(
                        top = MaterialTheme.spacing.large,
                    )
            )

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
            OutlinedInputField(
                label = "Username",
                value = signInTextFieldStates.username,
                onChange = {
                    signInTextFieldEvent(
                        SignInTextFieldEvents.UsernameChanged(
                            it
                        )
                    )
                },
                placeholder = {
                    Text("Alex@123")
                },
                error = signInTextFieldStates.usernameError
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
            OutlinedInputField(
                label = "Password",
                value = signInTextFieldStates.password,
                onChange = {
                    signInTextFieldEvent(
                        SignInTextFieldEvents.PasswordChanged(
                            it
                        )
                    )
                },
                placeholder = {
                    Text("Abc@1234")
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
                error = signInTextFieldStates.passwordError
            )
            TextButton(
                onClick = { signInEvent(SignInEvents.NavigateToForgotPassword) },
                modifier = Modifier
                    .align(Alignment.End),
                contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.small)
            ) {
                Text(
                    text = "Forgot Password?",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraLarge))

            PrimaryButton(
                label = "Log In",
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.onSecondary
                ),
                modifier = Modifier.width(266.dp),
                shape = RoundedCornerShape(10.dp),
            )

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
            val annotatedText = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f),
                        fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
                        fontWeight = MaterialTheme.typography.bodyLarge.fontWeight,
                    )
                ) {
                    append("Don’t have account? ")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                        fontWeight = MaterialTheme.typography.titleMedium.fontWeight
                    )
                ) {
                    pushStringAnnotation(tag = "SignUp", annotation = "SignUp")
                    append("Sign Up")
                    pop()
                }
            }
            TextButton(onClick = { signInEvent(SignInEvents.NavigateToSignUp) }) {
                Text(
                    text = annotatedText,
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
@PreviewLightDark
fun UserSignInPreview() {
    QTechHealthTheme {
        UserSignInScreenContent(
            signInTextFieldStates = SignInTextFieldStates(
                username = "",
                password = ""
            ),
            signInTextFieldEvent = {},
            signInEvent = {}
        )
    }
}
