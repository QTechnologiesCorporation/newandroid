package com.qtechnologiescorporation.di


import com.qtechnologiescorporation.api.NavControllerAccessor
import com.qtechnologiescorporation.user.UserHomeNavigationImpl
import com.qtechnologiescorporation.user.UserProfileNavigationImpl
import com.qtechnologiescorporation.user.UserAuthNavigationImpl
import com.qtechnologiescorporation.business.BusinessSignInNavigationImpl
import com.qtechnologiescorporation.api_impl.manager.NavigationManager
import com.qtechnologiescorporation.api_impl.manager.NavigationManagerImpl
import com.qtechnologiescorporation.business.BusinessChatNavigationImpl
import com.qtechnologiescorporation.business.BusinessHomeNavigationImpl
import com.qtechnologiescorporation.business.BusinessRecordsNavigationImpl
import com.qtechnologiescorporation.navigation.BusinessChatNavigation
import com.qtechnologiescorporation.navigation.BusinessHomeNavigation
import com.qtechnologiescorporation.navigation.BusinessRecordsNavigation
import com.qtechnologiescorporation.navigation.BusinessSignInNavigation
import com.qtechnologiescorporation.navigation.DetailsNavigation
import com.qtechnologiescorporation.navigation.HomeNavigation
import com.qtechnologiescorporation.navigation.QMedicalFormNavigation
import com.qtechnologiescorporation.navigation.UserAuthNavigation
import com.qtechnologiescorporation.navigation.UserChatNavigation
import com.qtechnologiescorporation.navigation.UserQiNavigation
import com.qtechnologiescorporation.navigation.UserRecordsNavigation
import com.qtechnologiescorporation.user.QMedicalFormNavigationImpl
import com.qtechnologiescorporation.user.UserChatNavigationImpl
import com.qtechnologiescorporation.user.UserQiNavigationImpl
import com.qtechnologiescorporation.user.UserRecordsNavigationImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val NavigationModule = module {
    // Register NavigationManagerImpl as itself and bind to both interfaces
    singleOf(::NavigationManagerImpl) {
        bind<NavigationManager>()
        bind<NavControllerAccessor>()
    }

    // Register feature-specific navigation implementations
    singleOf(::UserAuthNavigationImpl) { bind<UserAuthNavigation>() }
    singleOf(::UserHomeNavigationImpl) { bind<HomeNavigation>() }
    singleOf(::UserProfileNavigationImpl) { bind<DetailsNavigation>() }
    singleOf(::BusinessSignInNavigationImpl) { bind<BusinessSignInNavigation>() }
    singleOf(::QMedicalFormNavigationImpl) { bind<QMedicalFormNavigation>() }
    singleOf(::UserChatNavigationImpl) { bind<UserChatNavigation>() }
    singleOf(::UserQiNavigationImpl) { bind<UserQiNavigation>() }
    singleOf(::UserRecordsNavigationImpl) { bind<UserRecordsNavigation>() }

    singleOf(::BusinessHomeNavigationImpl) { bind<BusinessHomeNavigation>() }
    singleOf(::BusinessRecordsNavigationImpl) { bind<BusinessRecordsNavigation>() }
    singleOf(::BusinessChatNavigationImpl) { bind<BusinessChatNavigation>() }


}
