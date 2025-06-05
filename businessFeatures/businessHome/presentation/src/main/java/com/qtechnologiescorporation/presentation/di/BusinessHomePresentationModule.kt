package com.qtechnologiescorporation.presentation.di

import com.qtechnologiescorporation.presentation.viewmodels.BusinessHomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val BusinessHomePresentationModule = module {
    viewModelOf(::BusinessHomeViewModel)
}