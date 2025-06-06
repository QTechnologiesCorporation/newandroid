package com.qtechnologiescorporation.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.designsystem.components.OutlinedInputField
import com.qtechnologiescorporation.designsystem.components.PrimaryButton
import com.qtechnologiescorporation.designsystem.components.primaryContainerGradientBackground
import com.qtechnologiescorporation.designsystem.components.primaryGradientBackground
import com.qtechnologiescorporation.designsystem.spacing
import com.qtechnologiescorporation.presentation.viewmodels.SignInEvents
import com.qtechnologiescorporation.presentation.viewmodels.SignInTextFieldEvents
import com.qtechnologiescorporation.presentation.viewmodels.SignInTextFieldStates
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
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .fillMaxHeight(0.6f)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(primaryContainerGradientBackground()),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Welcome to Q Life!",
                            style = MaterialTheme.typography.headlineLarge,
                            color = MaterialTheme.colorScheme.onPrimary,
                        )

                        Text(
                            text = "Your Centralized Health Data Hub",
                            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.W200),
                            color = MaterialTheme.colorScheme.onPrimary,

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
                                    start = MaterialTheme.spacing.large,
                                    top = MaterialTheme.spacing.large
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
                            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
                            placeholder = {
                                Text("placeholder@mail.com")
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
                            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.large),
                            placeholder = {
                                Text("Abc@1234")
                            },
                            error = signInTextFieldStates.passwordError
                        )
                        TextButton(
                            onClick = { /* TODO: Handle forgot password */ },
                            modifier = Modifier
                                .align(Alignment.End)
                                .padding(end = MaterialTheme.spacing.large),
                            contentPadding = PaddingValues(0.dp)
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
                                append("Sign Up")
                            }
                        }
                        Text(
                            annotatedText,
                            Modifier.clickable {
                                signInEvent(SignInEvents.NavigateToSignUp)
                            },
                        )

                    }
                }
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
