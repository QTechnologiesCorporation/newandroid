package com.qtechnologiescorporation.user

import com.qtechnologiescorporation.api_impl.manager.NavigationCommand
import com.qtechnologiescorporation.api_impl.manager.NavigationManager
import com.qtechnologiescorporation.navigation.BusinessSignInScreenRoute
import com.qtechnologiescorporation.navigation.QMedicalFormNavigation
import com.qtechnologiescorporation.navigation.ScreenARoute
import com.qtechnologiescorporation.navigation.ScreenBRoute
import com.qtechnologiescorporation.navigation.UserChatNavigation
import org.koin.core.annotation.Single

@Single(binds = [UserChatNavigation::class])
class UserChatNavigationImpl(
    private val navigationManager: NavigationManager
) : UserChatNavigation {

    override fun navigateToUserChatInnerScreen() {
        TODO("Not yet implemented")
    }


}