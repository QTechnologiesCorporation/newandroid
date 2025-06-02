package com.qtechnologiescorporation.presentation.di

//@Module
//@ComponentScan("com.qtechnologiescorporation.features.userProfile.presentation")
//class UserProfilePresentationModule

import com.qtechnologiescorporation.presentation.UserProfileViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val UserProfilePresentationModule = module {
    viewModelOf(::UserProfileViewModel)
}