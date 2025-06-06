package com.qtechnologiescorporation.presentation.di

import com.qtechnologiescorporation.presentation.viewmodels.QMedicalFormViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val QMedicalFormPresentationModule = module {
    viewModelOf(::QMedicalFormViewModel)
}