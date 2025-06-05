package com.qtechnologiescorporation.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.designsystem.components.PrimaryButton
import com.qtechnologiescorporation.designsystem.components.primaryContainerGradientBackground
import com.qtechnologiescorporation.designsystem.components.primaryGradientBackground
import com.qtechnologiescorporation.presentation.viewmodels.UserSignInViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun UserSignInScreen(
    viewModel: UserSignInViewModel = koinViewModel(),
) {
    UserSignInScreenContent()
}

@Composable
fun UserSignInScreenContent() {

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
                    //colors = CardDefaults.cardColors(containerColor = Color.Transparent),
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
                                fontSize = 18.sp,
                                fontWeight = FontWeight.W700
                            ),
                            modifier = Modifier
                                .align(Alignment.Start)
                                .padding(start = 16.dp, top = 16.dp)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        PrimaryButton(
                            label = "Log In",
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary,
                                contentColor = MaterialTheme.colorScheme.onSecondary
                            ),
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
        UserSignInScreenContent()
    }
}
