package com.qtechnologiescorporation.qtechhealth.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.imePadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.qtechnologiescorporation.navigation.BusinessSignInScreenRoute
import com.qtechnologiescorporation.navigation.ScreenBRoute
import com.qtechnologiescorporation.navigation.UserAskTypeRoute
import com.qtechnologiescorporation.navigation.UserSignInRoute
import com.qtechnologiescorporation.navigation.UserSignUpRoute
import com.qtechnologiescorporation.presentation.ScreenB
import com.qtechnologiescorporation.presentation.screens.BusinessSignInScreen
import com.qtechnologiescorporation.presentation.screens.UserAskTypeScreen
import com.qtechnologiescorporation.presentation.screens.UserSignInScreen
import com.qtechnologiescorporation.presentation.screens.UserSignUpScreen


@Composable
fun QTechNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = UserAskTypeRoute,
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
        composable<ScreenBRoute> {
            ScreenB()
        }
    }
}