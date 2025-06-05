package com.qtechnologiescorporation.user

import com.qtechnologiescorporation.api_impl.manager.NavigationCommand
import com.qtechnologiescorporation.api_impl.manager.NavigationManager
import com.qtechnologiescorporation.navigation.BusinessSignInScreenRoute
import com.qtechnologiescorporation.navigation.ScreenARoute
import com.qtechnologiescorporation.navigation.ScreenBRoute
import com.qtechnologiescorporation.navigation.UserAskTypeNavigation
import com.qtechnologiescorporation.navigation.UserSignInRoute
import org.koin.core.annotation.Single

@Single(binds = [UserAskTypeNavigation::class])
class UserAskTypeNavigationImpl(
    private val navigationManager: NavigationManager
) : UserAskTypeNavigation {

    override fun navigateToUserPortal() {
        navigationManager.navigate(
            command = NavigationCommand.NavigateToRoute(
                route = UserSignInRoute
            )
        )
    }

    override fun navigateToBusinessPortal() {
        navigationManager.navigate(
            command = NavigationCommand.NavigateToRoute(
                route = BusinessSignInScreenRoute
            )
        )
    }
}
