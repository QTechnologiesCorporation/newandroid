package com.qtechnologiescorporation.user

import com.qtechnologiescorporation.api_impl.manager.NavigationCommand
import com.qtechnologiescorporation.api_impl.manager.NavigationManager
import com.qtechnologiescorporation.navigation.BusinessSignInScreenRoute
import com.qtechnologiescorporation.navigation.UserAuthNavigation
import com.qtechnologiescorporation.navigation.UserForgotPasswordRoute
import com.qtechnologiescorporation.navigation.UserSignInRoute
import com.qtechnologiescorporation.navigation.UserSignUpRoute
import com.qtechnologiescorporation.navigation.UserUploadDocumentRoute
import org.koin.core.annotation.Single

@Single(binds = [UserAuthNavigation::class])
class UserAuthNavigationImpl(
    private val navigationManager: NavigationManager
) : UserAuthNavigation {

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

    override fun navigateToSignUp() {
        navigationManager.navigate(
            command = NavigationCommand.NavigateToRoute(
                route = UserSignUpRoute
            )
        )
    }

    override fun navigateToForgotPassword() {
        navigationManager.navigate(
            command = NavigationCommand.NavigateToRoute(
                route = UserForgotPasswordRoute
            )
        )
    }

    override fun navigateToLogin() {
        navigationManager.navigate(
            command = NavigationCommand.NavigateUp
        )
    }

    override fun navigateToUploadDocument() {
        navigationManager.navigate(
            command = NavigationCommand.NavigateToRoute(
                route = UserUploadDocumentRoute
            )
        )
    }
}
