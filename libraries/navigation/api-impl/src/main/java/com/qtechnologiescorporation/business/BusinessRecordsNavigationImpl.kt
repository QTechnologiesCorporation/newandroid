package com.qtechnologiescorporation.business

import com.qtechnologiescorporation.api_impl.manager.NavigationCommand
import com.qtechnologiescorporation.api_impl.manager.NavigationManager
import com.qtechnologiescorporation.navigation.BusinessHomeNavigation
import com.qtechnologiescorporation.navigation.BusinessRecordsNavigation
import com.qtechnologiescorporation.navigation.ScreenBRoute
import org.koin.core.annotation.Single

@Single(binds = [BusinessRecordsNavigation::class])
class BusinessRecordsNavigationImpl(
    private val navigationManager: NavigationManager
) : BusinessRecordsNavigation {
    override fun navigateUserRecords() {
        TODO("Not yet implemented")
    }


}