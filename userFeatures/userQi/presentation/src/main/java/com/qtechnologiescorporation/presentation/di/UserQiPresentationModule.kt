package com.qtechnologiescorporation.presentation.di

import com.qtechnologiescorporation.presentation.viewmodels.UserQiViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val UserQiPresentationModule = module {
    viewModelOf(::UserQiViewModel)
}