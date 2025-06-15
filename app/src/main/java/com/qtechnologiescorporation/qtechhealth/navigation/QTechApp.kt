package com.qtechnologiescorporation.qtechhealth.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.qtechnologiescorporation.api.NavigationRoute
import com.qtechnologiescorporation.navigation.MedicalRecords
import com.qtechnologiescorporation.navigation.ScreenBRoute
import com.qtechnologiescorporation.navigation.UserChatInnerScreen
import com.qtechnologiescorporation.navigation.UserHomeScreenRoute
import com.qtechnologiescorporation.navigation.UserQiHistory

/**
 * Main Composable function for the QTech application.
 *
 * This function sets up the navigation graph and the bottom navigation bar.
 * It uses a NavHost (QTechNavGraph) to manage navigation between different screens
 * and an AnimatedVisibility to show/hide the bottom navigation bar
 * based on the current destination.
 *
 * The bottom navigation bar is displayed only when the current destination is one of:
 * - UserHomeScreenRoute
 * - UserChatInnerScreen
 * - UserAI
 * - UserQiHistory
 * - MedicalRecords
 *
 * The bottom navigation bar animates in and out vertically using slideInVertically and slideOutVertically with a duration of 800 milliseconds.
 *
 * @param qTechNavController The NavHostController used for navigation.
 * Defaults to a new rememberNavController.
 * @param startDestination The initial destination for the navigation graph.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QTechApp(
    qTechNavController: NavHostController,
    startDestination: NavigationRoute
) {
    val navBackStackEntry by qTechNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val showBottomNavigation = listOf(
        UserHomeScreenRoute,
        UserChatInnerScreen,
        ScreenBRoute, // Please replace ScreenBRoute with your actual route AI Services
        UserQiHistory,
        MedicalRecords,
    ).any { newRoute -> currentDestination?.hierarchy?.any { it.hasRoute(newRoute::class) } == true }


    Box(modifier = Modifier.fillMaxSize()) {
        QTechNavGraph(
            qTechNavController = qTechNavController,
            startDestination = startDestination,
            modifier = Modifier.align(Alignment.TopCenter)
        )

        AnimatedVisibility(
            visible = showBottomNavigation,
            enter = slideInVertically(
                animationSpec = tween(durationMillis = 800)
            ) { fullHeight -> fullHeight },
            exit = slideOutVertically(
                animationSpec = tween(durationMillis = 800)
            ) { fullHeight -> fullHeight },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(90.dp)
        ) {
            BottomNavigationBar(
                qTechNavController = qTechNavController,
                currentDestination = currentDestination
            )
        }
    }
}