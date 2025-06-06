package com.qtechnologiescorporation.user

import com.qtechnologiescorporation.api_impl.manager.NavigationCommand
import com.qtechnologiescorporation.api_impl.manager.NavigationManager
import com.qtechnologiescorporation.navigation.BusinessSignInScreenRoute
import com.qtechnologiescorporation.navigation.QMedicalFormNavigation
import com.qtechnologiescorporation.navigation.ScreenARoute
import com.qtechnologiescorporation.navigation.ScreenBRoute
import com.qtechnologiescorporation.navigation.UserRecordsNavigation
import org.koin.core.annotation.Single

@Single(binds = [UserRecordsNavigation::class])
class UserRecordsNavigationImpl(
    private val navigationManager: NavigationManager
) : UserRecordsNavigation {
    override fun navigateToQMedicalFormScreen1() {
        TODO("Not yet implemented")
    }

    override fun navigateToMedicalRecords() {
        TODO("Not yet implemented")
    }

    override fun navigateToMedicine() {
        TODO("Not yet implemented")
    }

    override fun navigateToUserNotes() {
        TODO("Not yet implemented")
    }

    override fun userUploadDocument() {
        TODO("Not yet implemented")
    }

    override fun userSubscription() {
        TODO("Not yet implemented")
    }


}