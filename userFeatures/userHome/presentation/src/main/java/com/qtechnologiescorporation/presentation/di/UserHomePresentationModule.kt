package com.qtechnologiescorporation.presentation.di

//@Module
//@ComponentScan("com.qtechnologiescorporation.features.userHome.presentation")
//class UserHomePresentationModule


import com.qtechnologiescorporation.presentation.UserHomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val UserHomePresentationModule = module {
    viewModelOf(::UserHomeViewModel)
}

