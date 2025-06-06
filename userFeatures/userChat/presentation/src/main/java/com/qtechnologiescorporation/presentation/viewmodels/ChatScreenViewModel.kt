package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.qtechnologiescorporation.navigation.UserChatNavigation
import org.koin.android.annotation.KoinViewModel


@KoinViewModel
class ChatScreenViewModel(
    private val navigation: UserChatNavigation
) : ViewModel() {

}
