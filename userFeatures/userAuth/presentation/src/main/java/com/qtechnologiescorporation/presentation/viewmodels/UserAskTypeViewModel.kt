package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.qtechnologiescorporation.navigation.UserAuthNavigation
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class UserAskTypeViewModel(
    private val navigation: UserAuthNavigation
) : ViewModel() {

    fun userAskTypeEvents(events: UserAskTypeEvents) {
        when (events) {
            is UserAskTypeEvents.NavigateTo -> {
                onUserAskTypeClicked(events.userAskType)
            }
        }
    }

    private fun onUserAskTypeClicked(userAskTypes: UserAskTypes) {
        when (userAskTypes) {
            UserAskTypes.USER -> {
                navigation.navigateToUserPortal()
            }

            UserAskTypes.BUSINESS -> {
                navigation.navigateToBusinessPortal()
            }
        }
    }
}


sealed class UserAskTypeEvents {
    data class NavigateTo(val userAskType: UserAskTypes) : UserAskTypeEvents()
}

enum class UserAskTypes {
    USER, BUSINESS
}