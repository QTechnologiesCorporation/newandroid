package com.qtechnologiescorporation.presentation.di

import com.qtechnologiescorporation.presentation.viewmodels.UserAskTypeViewModel
import com.qtechnologiescorporation.presentation.viewmodels.UserSignInViewModel
import com.qtechnologiescorporation.presentation.viewmodels.UserSignUpViewModel
import com.qtechnologiescorporation.presentation.viewmodels.UserForgotPasswordViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val UserAskTypePresentationModule = module {
    viewModelOf(::UserAskTypeViewModel)
    viewModelOf(::UserSignInViewModel)
    viewModelOf(::UserSignUpViewModel)
    viewModelOf(::UserForgotPasswordViewModel)

}