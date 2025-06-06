package com.qtechnologiescorporation.business

import com.qtechnologiescorporation.api_impl.manager.NavigationCommand
import com.qtechnologiescorporation.api_impl.manager.NavigationManager
import com.qtechnologiescorporation.navigation.BusinessHomeNavigation
import com.qtechnologiescorporation.navigation.BusinessSignInNavigation
import com.qtechnologiescorporation.navigation.ScreenBRoute
import org.koin.core.annotation.Single

@Single(binds = [BusinessHomeNavigation::class])
class BusinessHomeNavigationImpl(
    private val navigationManager: NavigationManager
) : BusinessHomeNavigation {
    override fun navigateHealthQuestionnaire() {
        TODO("Not yet implemented")
    }

    override fun navigateQMedicalRecords() {
        TODO("Not yet implemented")
    }

    override fun navigatePrescriptions() {
        TODO("Not yet implemented")
    }

    override fun navigateBusinessUploadDocument() {
        TODO("Not yet implemented")
    }

    override fun navigateBusinessNotes() {
        TODO("Not yet implemented")
    }


}