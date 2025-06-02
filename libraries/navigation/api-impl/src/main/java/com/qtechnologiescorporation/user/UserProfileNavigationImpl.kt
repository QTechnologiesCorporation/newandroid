package com.qtechnologiescorporation.user

import com.qtechnologiescorporation.api_impl.manager.NavigationCommand
import com.qtechnologiescorporation.api_impl.manager.NavigationManager
import com.qtechnologiescorporation.navigation.DetailsNavigation
import com.qtechnologiescorporation.navigation.ScreenARoute
import org.koin.core.annotation.Single


@Single(binds = [DetailsNavigation::class])
class UserProfileNavigationImpl(
    private val navigationManager: NavigationManager
) : DetailsNavigation {

    override fun navigateToScreenA() {
        navigationManager.navigate(
            command = NavigationCommand.NavigateToRoute(
                route = ScreenARoute
            )
        )
    }
}
