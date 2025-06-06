package com.qtechnologiescorporation.business

import com.qtechnologiescorporation.api_impl.manager.NavigationCommand
import com.qtechnologiescorporation.api_impl.manager.NavigationManager
import com.qtechnologiescorporation.navigation.BusinessChatNavigation
import com.qtechnologiescorporation.navigation.BusinessHomeNavigation
import com.qtechnologiescorporation.navigation.BusinessSignInNavigation
import com.qtechnologiescorporation.navigation.ScreenBRoute
import org.koin.core.annotation.Single

@Single(binds = [BusinessChatNavigation::class])
class BusinessChatNavigationImpl(
    private val navigationManager: NavigationManager
) : BusinessChatNavigation {


    override fun navigateBusinessChatInnerScreen() {
        TODO("Not yet implemented")
    }


}