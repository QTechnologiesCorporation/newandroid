package com.qtechnologiescorporation.user

import com.qtechnologiescorporation.api_impl.manager.NavigationCommand
import com.qtechnologiescorporation.api_impl.manager.NavigationManager
import com.qtechnologiescorporation.navigation.ConnectionsRoute
import com.qtechnologiescorporation.navigation.DetailsNavigation
import com.qtechnologiescorporation.navigation.ManageProfileRoute
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

    override fun navigateToManageProfile() {
        navigationManager.navigate(
            command = NavigationCommand.NavigateToRoute(
                route = ManageProfileRoute
            )
        )
    }

    override fun navigateToConnections() {
        navigationManager.navigate(
            command = NavigationCommand.NavigateToRoute(
                route = ConnectionsRoute
            )
        )
    }

    override fun navigateToSubscription() {
        TODO("Not yet implemented")
    }

    override fun navigateToActivity() {
        TODO("Not yet implemented")
    }

    override fun navigateToBlockedAccounts() {
        TODO("Not yet implemented")
    }

    override fun navigateToAccessibility() {
        TODO("Not yet implemented")
    }

    override fun navigateToSettings() {
        TODO("Not yet implemented")
    }

    override fun navigateToAccountStatus() {
        TODO("Not yet implemented")
    }

    override fun navigateToQrScan() {
        TODO("Not yet implemented")
    }

    override fun navigateToChat() {
        TODO("Not yet implemented")
    }

    override fun navigateToSupportAndHelp() {
        TODO("Not yet implemented")
    }

    override fun navigateToAboutUs() {
        TODO("Not yet implemented")
    }

    override fun navigateToTermsAndPrivacyPolicy() {
        TODO("Not yet implemented")
    }

    override fun navigateToLogout() {
        TODO("Not yet implemented")
    }

    override fun navigateToAddAccount() {
        TODO("Not yet implemented")
    }
}
