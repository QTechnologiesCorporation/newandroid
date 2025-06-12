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
import com.qtechnologiescorporation.navigation.ConnectionsRoute
import com.qtechnologiescorporation.navigation.ManageProfileRoute
import com.qtechnologiescorporation.navigation.ProfileRoute
import com.qtechnologiescorporation.navigation.QMedicalFormScreen1
import com.qtechnologiescorporation.navigation.QMedicalFormScreen2
import com.qtechnologiescorporation.navigation.ScreenBRoute
import com.qtechnologiescorporation.navigation.UserAskTypeRoute
import com.qtechnologiescorporation.navigation.UserSignInRoute
import com.qtechnologiescorporation.navigation.UserSignUpRoute
import com.qtechnologiescorporation.navigation.UserForgotPasswordRoute
import com.qtechnologiescorporation.navigation.UserUploadDocumentRoute
import com.qtechnologiescorporation.presentation.ScreenB
import com.qtechnologiescorporation.presentation.screens.BusinessSignInScreen
import com.qtechnologiescorporation.presentation.screens.ConnectionsScreen
import com.qtechnologiescorporation.presentation.screens.ManageProfileScreen
import com.qtechnologiescorporation.presentation.screens.ManageProfileUserScreen
import com.qtechnologiescorporation.presentation.screens.QMedicalFormScreen
import com.qtechnologiescorporation.presentation.screens.QMedicalFormScreen2
import com.qtechnologiescorporation.presentation.screens.UserAskTypeScreen
import com.qtechnologiescorporation.presentation.screens.UserForgotPasswordScreen
import com.qtechnologiescorporation.presentation.screens.UserSignInScreen
import com.qtechnologiescorporation.presentation.screens.UserSignUpScreen
import com.qtechnologiescorporation.presentation.screens.UserUploadDocumentsScreen


@Composable
fun QTechNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        //startDestination = UserAskTypeRoute,
        startDestination = UserUploadDocumentRoute,
//        startDestination = UserAskTypeRoute,
        startDestination = ProfileRoute,

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
        composable<ScreenBRoute> {
            ScreenB()
        }
        composable<QMedicalFormScreen1> {
            QMedicalFormScreen()
        }
        composable<QMedicalFormScreen2> {
            QMedicalFormScreen2()
        }
        composable<ProfileRoute> {
            ManageProfileUserScreen()
        }
        composable<ManageProfileRoute> {
            ManageProfileScreen()
        }
        composable<ConnectionsRoute> {
            ConnectionsScreen()
        }
    }
}