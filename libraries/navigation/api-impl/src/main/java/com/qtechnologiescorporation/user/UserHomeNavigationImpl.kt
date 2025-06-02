package com.qtechnologiescorporation.user

import com.qtechnologiescorporation.api_impl.manager.NavigationCommand
import com.qtechnologiescorporation.api_impl.manager.NavigationManager
import com.qtechnologiescorporation.navigation.HomeNavigation
import com.qtechnologiescorporation.navigation.ScreenBRoute
import org.koin.core.annotation.Single

@Single(binds = [HomeNavigation::class])
class UserHomeNavigationImpl(
    private val navigationManager: NavigationManager
) : HomeNavigation {

    override fun navigateToScreenB() {
        navigationManager.navigate(
            command = NavigationCommand.NavigateToRoute(
                route = ScreenBRoute
            )
        )
    }
}
