package com.qtechnologiescorporation.business

import com.qtechnologiescorporation.api_impl.manager.NavigationCommand
import com.qtechnologiescorporation.api_impl.manager.NavigationManager
import com.qtechnologiescorporation.navigation.BusinessSignInNavigation
import com.qtechnologiescorporation.navigation.ScreenBRoute
import org.koin.core.annotation.Single

@Single(binds = [BusinessSignInNavigation::class])
class BusinessSignInNavigationImpl(
    private val navigationManager: NavigationManager
) : BusinessSignInNavigation {

    override fun navigateToBusinessSignUp() {
        navigationManager.navigate(
            command = NavigationCommand.NavigateToRoute(
                route = ScreenBRoute
            )
        )
    }
}