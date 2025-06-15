package com.qtechnologiescorporation.qtechhealth.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.qtechnologiescorporation.api.NavigationRoute
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.navigation.MedicalRecords
import com.qtechnologiescorporation.navigation.ScreenBRoute
import com.qtechnologiescorporation.navigation.UserChatInnerScreen
import com.qtechnologiescorporation.navigation.UserHomeScreenRoute
import com.qtechnologiescorporation.navigation.UserQiHistory
import com.qtechnologiescorporation.qtechhealth.R

/**
 * Composable function that displays a Bottom Navigation Bar for navigation within the app.
 *
 * This function uses Material Design 3's BottomAppBar and NavigationBarItem components.
 * It navigates between different sections of the app defined by the provided `items`.
 *
 * @param qTechNavController The [NavHostController] used for navigation.
 * @param currentDestination The current destination in the navigation graph. Used to determine
 *  which navigation item should be selected.
 */
@SuppressLint("RestrictedApi") // this is because hasRoute is not allowed use
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    qTechNavController: NavHostController,
    currentDestination: NavDestination?
) {
    val items = listOf(
        NavigationItem(
            route = UserHomeScreenRoute,
            icon = painterResource(R.drawable.ic_home),
            label = "Home"
        ),
        NavigationItem(
            route = UserChatInnerScreen,
            icon = painterResource(R.drawable.ic_chat),
            label = "Chat"
        ),
        NavigationItem(
            route = ScreenBRoute, // Please replace ScreenBRoute with your actual route AI Services
            icon = painterResource(R.drawable.ic_mic),
            label = "AI"
        ),
        NavigationItem(
            route = UserQiHistory,
            icon = painterResource(R.drawable.ic_qi),
            label = "QI"
        ),
        NavigationItem(
            route = MedicalRecords,
            icon = painterResource(R.drawable.ic_records),
            label = "Records"
        ),
    )
    BottomAppBar(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .padding(bottom = 20.dp)
            .clip(RoundedCornerShape(20.dp)),
        windowInsets = WindowInsets(0, 0, 0, 0),
        //containerColor = Color.Transparent,
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onPrimary,
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.hasRoute(item.route::class) } == true,
                onClick = {
                    qTechNavController.navigate(item.route) {
                        popUpTo(qTechNavController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.label,
                        modifier = Modifier.size(20.dp)
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        fontSize = 12.sp,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.surfaceVariant,
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                )
            )
        }
    }
}

data class NavigationItem(val route: NavigationRoute, val icon: Painter, val label: String)

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@PreviewLightDark
@Composable
fun BottomNavigationBarPreview() {
    QTechHealthTheme {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        BottomNavigationBar(
            navController, currentDestination = currentDestination
        )
    }
}