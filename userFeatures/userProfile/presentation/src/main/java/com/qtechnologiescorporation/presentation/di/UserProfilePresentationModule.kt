package com.qtechnologiescorporation.presentation.di



import com.qtechnologiescorporation.presentation.UserProfileViewModel
import com.qtechnologiescorporation.presentation.viewmodels.ConnectionsViewModel
import com.qtechnologiescorporation.presentation.viewmodels.ManageProfileViewModel
import com.qtechnologiescorporation.presentation.viewmodels.ProfileViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val UserProfilePresentationModule = module {
    viewModelOf(::UserProfileViewModel)
    viewModelOf(::ProfileViewModel)
    viewModelOf(::ManageProfileViewModel)
    viewModelOf(::ConnectionsViewModel)


}