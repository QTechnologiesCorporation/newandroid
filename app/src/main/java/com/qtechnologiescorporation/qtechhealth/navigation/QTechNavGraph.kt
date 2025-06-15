package com.qtechnologiescorporation.qtechhealth.navigation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HourglassEmpty
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.qtechnologiescorporation.api.NavigationRoute
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.designsystem.components.BaseScreen
import com.qtechnologiescorporation.navigation.BusinessSignInScreenRoute
import com.qtechnologiescorporation.navigation.MedicalRecords
import com.qtechnologiescorporation.navigation.ScreenBRoute
import com.qtechnologiescorporation.navigation.UserAskTypeRoute
import com.qtechnologiescorporation.navigation.UserChatInnerScreen
import com.qtechnologiescorporation.navigation.UserForgotPasswordRoute
import com.qtechnologiescorporation.navigation.UserHomeScreenRoute
import com.qtechnologiescorporation.navigation.UserQiHistory
import com.qtechnologiescorporation.navigation.UserSignInRoute
import com.qtechnologiescorporation.navigation.UserSignUpRoute
import com.qtechnologiescorporation.navigation.UserUploadDocumentRoute
import com.qtechnologiescorporation.navigation.UserVerifyFaceRoute
import com.qtechnologiescorporation.presentation.screens.BusinessSignInScreen
import com.qtechnologiescorporation.presentation.screens.UserAskTypeScreen
import com.qtechnologiescorporation.presentation.screens.UserForgotPasswordScreen
import com.qtechnologiescorporation.presentation.screens.UserHomeScreen
import com.qtechnologiescorporation.presentation.screens.UserSignInScreen
import com.qtechnologiescorporation.presentation.screens.UserSignUpScreen
import com.qtechnologiescorporation.presentation.screens.UserUploadDocumentsScreen
import com.qtechnologiescorporation.presentation.screens.UserVerifyFaceScreen


@Composable
fun QTechNavGraph(
    qTechNavController: NavHostController,
    startDestination: NavigationRoute,
    modifier: Modifier
) {
    NavHost(
        modifier = modifier,
        navController = qTechNavController,
        //startDestination = startDestination,
        startDestination = UserAskTypeRoute,
        //startDestination = UserUploadDocumentRoute,
        enterTransition = { slideInHorizontally { it } },
        exitTransition = { slideOutHorizontally { -it } },
        popEnterTransition = { slideInHorizontally { -it } },
        popExitTransition = { slideOutHorizontally { it } },
    ) {
        composable<UserAskTypeRoute> {
            UserAskTypeScreen()
        }
        composable<BusinessSignInScreenRoute> {
            BusinessSignInScreen()
        }
        composable<UserSignInRoute> {
            UserSignInScreen()
        }
        composable<UserSignUpRoute> {
            UserSignUpScreen()
        }
        composable<UserForgotPasswordRoute> {
            UserForgotPasswordScreen()
        }
        composable<UserUploadDocumentRoute> {
            UserUploadDocumentsScreen()
        }
        composable<UserVerifyFaceRoute> {
            UserVerifyFaceScreen()
        }
        composable<UserHomeScreenRoute> {
            UserHomeScreen()
        }
        composable<UserChatInnerScreen> {
            TemporaryScreen(purposeScreenName = "Q Chat")
        }
        composable<ScreenBRoute> { // Please replace ScreenBRoute with your actual route AI Services
            TemporaryScreen(purposeScreenName = "AI Services")
        }
        composable<UserQiHistory> {
            TemporaryScreen(purposeScreenName = "QI History")
        }
        composable<MedicalRecords> {
            TemporaryScreen(purposeScreenName = "Q Medical Records")
        }
//        composable<ScreenBRoute> {
//            ScreenB()
//        }
    }
}

//Temporary code

@Composable
fun TemporaryScreen(
    purposeScreenName: String,
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "icon_animation")
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "icon_rotation"
    )

    val alphaAnimation = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        alphaAnimation.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )
    }
    Scaffold { innerPadding ->
        BaseScreen(
            innerPadding = innerPadding,
            backgroundOffset = 1900f
        ) {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.alpha(alphaAnimation.value)
                ) {
                    Icon(
                        imageVector = Icons.Filled.HourglassEmpty,
                        contentDescription = "Coming Soon Icon",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .size(80.dp)
                            .rotate(angle)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "Coming Soon!",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = purposeScreenName,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "This section is under construction. We're working hard to bring it to you!",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

// --- Preview ---
@Preview(showBackground = true)
@PreviewLightDark
@Composable
fun TemporaryScreenPreviewDark() {
    QTechHealthTheme {
        TemporaryScreen(purposeScreenName = "Advanced Settings")
    }
}