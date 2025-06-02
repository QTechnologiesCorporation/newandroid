package com.qtechnologiescorporation.qtechhealth.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.qtechnologiescorporation.navigation.ScreenARoute
import com.qtechnologiescorporation.navigation.ScreenBRoute
import com.qtechnologiescorporation.navigation.UserAskTypeRoute
import com.qtechnologiescorporation.presentation.ScreenA
import com.qtechnologiescorporation.presentation.ScreenB
import com.qtechnologiescorporation.presentation.screens.UserAskTypeScreen
import com.qtechnologiescorporation.presentation.viewmodels.UserAskTypes


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
        composable<ScreenARoute> {
            ScreenA()
        }
        composable<ScreenBRoute> {
            ScreenB()
        }
    }
}