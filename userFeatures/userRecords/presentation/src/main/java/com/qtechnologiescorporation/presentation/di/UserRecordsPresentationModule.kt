package com.qtechnologiescorporation.presentation.di

import com.qtechnologiescorporation.presentation.viewmodels.UserRecordsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val UserRecordsPresentationModule = module {
    viewModelOf(::UserRecordsViewModel)
}