package com.qtechnologiescorporation.presentation.di

import com.qtechnologiescorporation.presentation.viewmodels.BusinessRecordsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val BusinessRecordsPresentationModule = module {
    viewModelOf(::BusinessRecordsViewModel)
}