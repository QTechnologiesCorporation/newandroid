package com.qtechnologiescorporation.user

import com.qtechnologiescorporation.api_impl.manager.NavigationCommand
import com.qtechnologiescorporation.api_impl.manager.NavigationManager
import com.qtechnologiescorporation.navigation.BusinessSignInScreenRoute
import com.qtechnologiescorporation.navigation.QMedicalFormNavigation
import com.qtechnologiescorporation.navigation.QMedicalFormScreen2
import com.qtechnologiescorporation.navigation.ScreenARoute
import com.qtechnologiescorporation.navigation.ScreenBRoute
import org.koin.core.annotation.Single

@Single(binds = [QMedicalFormNavigation::class])
class QMedicalFormNavigationImpl(
    private val navigationManager: NavigationManager
) : QMedicalFormNavigation {

    override fun navigateToQMedicalFormScreen2() {
        navigationManager.navigate(
            command = NavigationCommand.NavigateToRoute(
                route = QMedicalFormScreen2
            )
        )
    }

    override fun navigateToQMedicalFormScreen3() {
        TODO("Not yet implemented")
    }

    override fun navigateToQMedicalFormScreen4() {
        TODO("Not yet implemented")
    }


}
