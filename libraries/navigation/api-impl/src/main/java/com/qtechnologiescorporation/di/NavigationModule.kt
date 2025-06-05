package com.qtechnologiescorporation.di


import com.qtechnologiescorporation.api.NavControllerAccessor
import com.qtechnologiescorporation.user.UserHomeNavigationImpl
import com.qtechnologiescorporation.user.UserProfileNavigationImpl
import com.qtechnologiescorporation.user.UserAskTypeNavigationImpl
import com.qtechnologiescorporation.business.BusinessSignInNavigationImpl
import com.qtechnologiescorporation.api_impl.manager.NavigationManager
import com.qtechnologiescorporation.api_impl.manager.NavigationManagerImpl
import com.qtechnologiescorporation.navigation.BusinessSignInNavigation
import com.qtechnologiescorporation.navigation.DetailsNavigation
import com.qtechnologiescorporation.navigation.HomeNavigation
import com.qtechnologiescorporation.navigation.UserAskTypeNavigation
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

//@Module
//@ComponentScan("com.qtechnologiescorporation.api_impl")
//class NavigationModule

val NavigationModule = module {
    // Register NavigationManagerImpl as itself and bind to both interfaces
    singleOf(::NavigationManagerImpl) {
        bind<NavigationManager>()
        bind<NavControllerAccessor>()
    }

    // Register feature-specific navigation implementations
    singleOf(::UserAskTypeNavigationImpl) { bind<UserAskTypeNavigation>() }
    singleOf(::UserHomeNavigationImpl) { bind<HomeNavigation>() }
    singleOf(::UserProfileNavigationImpl) { bind<DetailsNavigation>() }
    singleOf(::BusinessSignInNavigationImpl) { bind<BusinessSignInNavigation>() }
}
