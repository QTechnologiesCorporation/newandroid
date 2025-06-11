package com.qtechnologiescorporation.presentation.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.designsystem.components.BaseCardScreen
import com.qtechnologiescorporation.designsystem.components.DescriptionText
import com.qtechnologiescorporation.designsystem.components.OutlinedInputField
import com.qtechnologiescorporation.designsystem.components.PrimaryButton
import com.qtechnologiescorporation.designsystem.components.SecondaryHeading
import com.qtechnologiescorporation.designsystem.spacing
import com.qtechnologiescorporation.presentation.R
import com.qtechnologiescorporation.presentation.stateAndEvents.ForgotPasswordEvents
import com.qtechnologiescorporation.presentation.stateAndEvents.ForgotPasswordStates
import com.qtechnologiescorporation.presentation.viewmodels.UserForgotPasswordViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel


@Composable
fun UserForgotPasswordScreen(
    viewModel: UserForgotPasswordViewModel = koinViewModel(),
) {
    val forgotPasswordStates by viewModel.forgotPasswordState.collectAsStateWithLifecycle()
    UserForgotPasswordScreenContent(
        forgotPasswordStates = forgotPasswordStates,
        forgotPasswordEvents = viewModel::forgotPasswordEvents,
    )
}

@Composable
fun UserForgotPasswordScreenContent(
    forgotPasswordStates: ForgotPasswordStates,
    forgotPasswordEvents: (ForgotPasswordEvents) -> Unit,
) {
    val pagerState = rememberPagerState(pageCount = { 4 })
    Scaffold { innerPadding ->
        ForgotPasswordPager(
            pagerState = pagerState,
            innerPadding = innerPadding,
            state = forgotPasswordStates,
            onEvent = forgotPasswordEvents,
            onSubmit = {
                forgotPasswordEvents(ForgotPasswordEvents.NavigateToLogin)
            },
            onBack = { /*TODO*/ }
        )
    }
}

@Composable
fun ForgotPasswordPager(
    pagerState: PagerState,
    innerPadding: PaddingValues = PaddingValues(0.dp),
    state: ForgotPasswordStates,
    onEvent: (ForgotPasswordEvents) -> Unit,
    onSubmit: () -> Unit,
    onBack: () -> Unit
) {
    val scope = rememberCoroutineScope()

    BackHandler(enabled = pagerState.currentPage > 0) {
        scope.launch { pagerState.animateScrollToPage(pagerState.currentPage - 1) }
        onBack()
    }

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        userScrollEnabled = false
    ) { page ->
        when (page) {
            0 -> ForgotPasswordEmailScreen(
                innerPadding = innerPadding,
                state = state,
                onEvent = onEvent,
                onProceed = { scope.launch { pagerState.animateScrollToPage(1) } }
            )

            1 -> ForgotPasswordOtpScreen(
                innerPadding = innerPadding,
                state = state,
                onProceed = { scope.launch { pagerState.animateScrollToPage(2) } }
            )

            2 -> ForgotPasswordResetScreen(
                innerPadding = innerPadding,
                state = state,
                onEvent = onEvent,
                onSubmit = { scope.launch { pagerState.animateScrollToPage(3) } }
            )

            3 -> ForgotPasswordSuccessScreen(innerPadding = innerPadding, onDone = onSubmit)
        }
    }
}

@Composable
fun ForgotPasswordEmailScreen(
    innerPadding: PaddingValues = PaddingValues(0.dp),
    state: ForgotPasswordStates,
    onEvent: (ForgotPasswordEvents) -> Unit,
    onProceed: () -> Unit
) {
    BaseCardScreen(innerPadding = innerPadding) {
        SecondaryHeading(
            "Forgot Password",
            "Enter your registered email address to receive a secure OTP. Verify it to reset your password safely and regain access."
        )
        Spacer(Modifier.height(MaterialTheme.spacing.mediumLarge))
        OutlinedInputField(
            label = "Email ID",
            value = state.email,
            onChange = { onEvent(ForgotPasswordEvents.EmailChanged(it)) },
            placeholder = { Text("Enter email") },
            error = state.emailError
        )
        Spacer(Modifier.height(MaterialTheme.spacing.mediumLarge))
        PrimaryButton(
            label = "Proceed", onClick = onProceed,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            ),
            modifier = Modifier.width(266.dp),
            shape = RoundedCornerShape(10.dp),
        )
    }
}

@Composable
fun ForgotPasswordOtpScreen(
    innerPadding: PaddingValues = PaddingValues(0.dp),
    state: ForgotPasswordStates,
    onProceed: () -> Unit
) {
    BaseCardScreen(innerPadding = innerPadding) {
        SecondaryHeading(
            "Enter OTP",
            "We’ve sent a one-time password to your registered email. Please enter it below to verify your identity and continue."
        )
        Spacer(Modifier.height(MaterialTheme.spacing.mediumLarge))

        OtpInputFields(otpLength = 4) { otp ->

        }
//        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
//            repeat(4) {
//                OutlinedInputField(
//                    label = "",
//                    value = "",
//                    onChange = {},
//                    modifier = Modifier.width(40.dp)
//                )
//            }
//        }
        Spacer(Modifier.height(MaterialTheme.spacing.mediumLarge))
        PrimaryButton(
            label = "Proceed", onClick = onProceed,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            ),
            modifier = Modifier.width(266.dp),
            shape = RoundedCornerShape(10.dp),
        )
    }
}

@Composable
fun OtpInputFields(
    otpLength: Int = 4,
    onOtpComplete: (String) -> Unit
) {
    val otpValues = remember { mutableStateListOf(*Array(otpLength) { "" }) }
    val focusRequesters = remember { List(otpLength) { FocusRequester() } }
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        otpValues.forEachIndexed { index, value ->
            OutlinedTextField(
                value = value,
                onValueChange = {
                    if (it.length <= 1 && it.all { char -> char.isDigit() }) {
                        otpValues[index] = it
                        if (it.isNotEmpty() && index < otpLength - 1) {
                            focusRequesters[index + 1].requestFocus()
                        }
                        if (otpValues.all { digit -> digit.length == 1 }) {
                            onOtpComplete(otpValues.joinToString(""))
                        }
                    }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .width(48.dp)
                    .focusRequester(focusRequesters[index])
                    .onKeyEvent {
                        if (it.type == KeyEventType.KeyDown && it.key == Key.Backspace && value.isEmpty() && index > 0) {
                            focusRequesters[index - 1].requestFocus()
                        }
                        false
                    },
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
            )
        }
    }
}

@Composable
fun ForgotPasswordResetScreen(
    innerPadding: PaddingValues = PaddingValues(0.dp),
    state: ForgotPasswordStates,
    onEvent: (ForgotPasswordEvents) -> Unit,
    onSubmit: () -> Unit
) {
    BaseCardScreen(innerPadding = innerPadding) {
        SecondaryHeading(
            "Reset Password",
            "Create a new password for your account. "
        )
        Spacer(Modifier.height(MaterialTheme.spacing.mediumLarge))
        OutlinedInputField(
            label = "New Password",
            value = state.password,
            onChange = { onEvent(ForgotPasswordEvents.PasswordChanged(it)) },
            placeholder = { Text("Enter password") },
            error = state.passwordError
        )
        Spacer(Modifier.height(MaterialTheme.spacing.medium))
        OutlinedInputField(
            label = "Confirm Password",
            value = state.confirmPassword,
            onChange = { onEvent(ForgotPasswordEvents.ConfirmPasswordChanged(it)) },
            placeholder = { Text("Confirm password") },
            error = state.confirmPasswordError
        )
        Spacer(Modifier.height(MaterialTheme.spacing.mediumLarge))
        PrimaryButton(
            label = "Submit", onClick = onSubmit,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            ),
            modifier = Modifier.width(266.dp),
            shape = RoundedCornerShape(10.dp),
        )
    }
}

@Composable
fun ForgotPasswordSuccessScreen(
    innerPadding: PaddingValues = PaddingValues(0.dp),
    onDone: () -> Unit
) {
    BaseCardScreen(innerPadding = innerPadding) {
        SecondaryHeading("Success")
        Spacer(Modifier.height(MaterialTheme.spacing.mediumLarge))
        Icon(
            painter = painterResource(R.drawable.success),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.size(80.dp)
        )

        Spacer(Modifier.height(MaterialTheme.spacing.mediumLarge))
        DescriptionText("Your Password has been successfully Updated")
        Spacer(Modifier.height(MaterialTheme.spacing.mediumLarge))
        PrimaryButton(
            label = "Login", onClick = onDone,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            ),
            modifier = Modifier.width(266.dp),
            shape = RoundedCornerShape(10.dp),
        )
    }
}


@Composable
@PreviewLightDark
fun UserForgotPasswordPreview() {
    QTechHealthTheme {
        UserForgotPasswordScreenContent(
            forgotPasswordStates = ForgotPasswordStates(),
            forgotPasswordEvents = {}
        )
    }
}
