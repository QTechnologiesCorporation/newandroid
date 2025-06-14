package com.qtechnologiescorporation.presentation.di


import com.qtechnologiescorporation.presentation.viewmodels.UserHomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val UserHomePresentationModule = module {
    viewModelOf(::UserHomeViewModel)
}

