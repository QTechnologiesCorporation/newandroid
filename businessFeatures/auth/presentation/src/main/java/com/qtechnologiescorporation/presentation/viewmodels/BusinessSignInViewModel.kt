package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.qtechnologiescorporation.navigation.BusinessSignInNavigation
import org.koin.android.annotation.KoinViewModel


@KoinViewModel
class BusinessSignInViewModel(
    private val navigation: BusinessSignInNavigation
) : ViewModel() {

}
