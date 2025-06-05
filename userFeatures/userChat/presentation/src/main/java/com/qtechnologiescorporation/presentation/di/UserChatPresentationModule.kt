package com.qtechnologiescorporation.presentation.di

import com.qtechnologiescorporation.presentation.viewmodels.ChatScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val UserChatPresentationModule = module {
    viewModelOf(::ChatScreenViewModel)
}