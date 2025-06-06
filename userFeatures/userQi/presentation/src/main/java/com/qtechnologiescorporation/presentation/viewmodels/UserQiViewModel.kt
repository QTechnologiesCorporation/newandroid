package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.qtechnologiescorporation.navigation.UserQiNavigation
import org.koin.android.annotation.KoinViewModel


@KoinViewModel
class UserQiViewModel(
    private val navigation: UserQiNavigation
) : ViewModel() {

}
