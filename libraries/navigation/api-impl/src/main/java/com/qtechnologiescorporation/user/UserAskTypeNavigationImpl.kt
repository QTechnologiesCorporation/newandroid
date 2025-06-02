package com.qtechnologiescorporation.user

import com.qtechnologiescorporation.api_impl.manager.NavigationCommand
import com.qtechnologiescorporation.api_impl.manager.NavigationManager
import com.qtechnologiescorporation.navigation.ScreenARoute
import com.qtechnologiescorporation.navigation.ScreenBRoute
import com.qtechnologiescorporation.navigation.UserAskTypeNavigation
import org.koin.core.annotation.Single

@Single(binds = [UserAskTypeNavigation::class])
class UserAskTypeNavigationImpl(
    private val navigationManager: NavigationManager
) : UserAskTypeNavigation {

    override fun navigateToUserPortal() {
        navigationManager.navigate(
            command = NavigationCommand.NavigateToRoute(
                route = ScreenARoute
            )
        )
    }

    override fun navigateToBusinessPortal() {
        navigationManager.navigate(
            command = NavigationCommand.NavigateToRoute(
                route = ScreenBRoute
            )
        )
    }
}
