package com.qtechnologiescorporation.presentation.di

import com.qtechnologiescorporation.presentation.viewmodels.BusinessChatViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val BusinessChatPresentationModule = module {
    viewModelOf(::BusinessChatViewModel)
}