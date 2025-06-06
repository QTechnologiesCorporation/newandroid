package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.qtechnologiescorporation.navigation.BusinessChatNavigation
import org.koin.android.annotation.KoinViewModel


@KoinViewModel
class BusinessChatViewModel(
    private val navigation: BusinessChatNavigation
) : ViewModel() {

}
