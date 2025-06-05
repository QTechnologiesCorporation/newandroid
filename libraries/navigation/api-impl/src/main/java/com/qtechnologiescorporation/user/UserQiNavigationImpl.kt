package com.qtechnologiescorporation.user

import com.qtechnologiescorporation.api_impl.manager.NavigationCommand
import com.qtechnologiescorporation.api_impl.manager.NavigationManager
import com.qtechnologiescorporation.navigation.BusinessSignInScreenRoute
import com.qtechnologiescorporation.navigation.QMedicalFormNavigation
import com.qtechnologiescorporation.navigation.ScreenARoute
import com.qtechnologiescorporation.navigation.ScreenBRoute
import com.qtechnologiescorporation.navigation.UserQiNavigation
import org.koin.core.annotation.Single

@Single(binds = [UserQiNavigation::class])
class UserQiNavigationImpl(
    private val navigationManager: NavigationManager
) : UserQiNavigation {
    override fun navigateToUserQiHistory() {
        TODO("Not yet implemented")
    }


}