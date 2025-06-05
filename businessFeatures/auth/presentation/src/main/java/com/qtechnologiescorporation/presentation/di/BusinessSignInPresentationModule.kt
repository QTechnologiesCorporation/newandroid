package com.qtechnologiescorporation.presentation.di

import com.qtechnologiescorporation.presentation.viewmodels.BusinessSignInViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val BusinessSignInPresentationModule = module {
    viewModelOf(::BusinessSignInViewModel)
}