package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.qtechnologiescorporation.navigation.UserAskTypeNavigation
import org.koin.android.annotation.KoinViewModel


@KoinViewModel
class UserSignInViewModel(
    private val navigation: UserAskTypeNavigation
) : ViewModel() {

}
