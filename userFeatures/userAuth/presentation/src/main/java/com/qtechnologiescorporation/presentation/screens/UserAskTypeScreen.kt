package com.qtechnologiescorporation.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.designsystem.R
import com.qtechnologiescorporation.designsystem.components.PrimaryButton
import com.qtechnologiescorporation.designsystem.components.SecondaryButton
import com.qtechnologiescorporation.designsystem.components.primaryGradientBackground
import com.qtechnologiescorporation.designsystem.spacing
import com.qtechnologiescorporation.presentation.viewmodels.UserAskTypeEvents
import com.qtechnologiescorporation.presentation.viewmodels.UserAskTypeViewModel
import com.qtechnologiescorporation.presentation.viewmodels.UserAskTypes
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserAskTypeScreen(
    viewModel: UserAskTypeViewModel = koinViewModel(),
) {
    UserAskTypeScreenContent(
        navigateToUser = { viewModel.userAskTypeEvents(UserAskTypeEvents.NavigateTo(UserAskTypes.USER)) },
        navigateToBusiness = { viewModel.userAskTypeEvents(UserAskTypeEvents.NavigateTo(UserAskTypes.BUSINESS)) }
    )
}

@Composable
fun UserAskTypeScreenContent(navigateToUser: () -> Unit, navigateToBusiness: () -> Unit) {

    Scaffold { innerPadding ->
        val backgroundBrush = primaryGradientBackground()
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
                Icon(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(100.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
                Text(
                    text = "Q Life",
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
                Text(
                    buildAnnotatedString {
                        append("A ")

                        withStyle(
                            style = SpanStyle(
                                fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
                                fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        ) {
                            append("Centralized Platform")
                        }

                        append(" for Your Health Needs.")
                    },
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.W200, fontSize = 12.sp
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraLarge))
                Text(
                    text = "How do you want to get started?",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.W200
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.mediumLarge))
                PrimaryButton(
                    label = "I'm a User",
                    onClick = { navigateToUser.invoke() }
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
                SecondaryButton(
                    label = "I'm a Business",
                    onClick = { navigateToBusiness.invoke() }
                )
            }
        }
    }
}
@Composable
@PreviewLightDark
fun UserAskTypePreview() {
    QTechHealthTheme {
        UserAskTypeScreenContent(
            navigateToUser = {},
            navigateToBusiness = {}
        )
    }
}
