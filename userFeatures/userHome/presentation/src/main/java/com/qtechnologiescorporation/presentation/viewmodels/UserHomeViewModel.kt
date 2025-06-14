package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qtechnologiescorporation.navigation.HomeNavigation
import com.qtechnologiescorporation.presentation.stateAndEvents.UserHomeEvents
import com.qtechnologiescorporation.presentation.stateAndEvents.UserHomeStates
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel


@KoinViewModel
class UserHomeViewModel(
    private val navigation: HomeNavigation
) : ViewModel() {

    private val _homeState = MutableStateFlow(UserHomeStates())
    val homeState = _homeState.asStateFlow()

    fun userHomeEvents(event: UserHomeEvents) {
        when (event) {
            UserHomeEvents.NavigateToHealthData -> {

            }

            is UserHomeEvents.OnDocumentSelected -> {
                _homeState.update {
                    it.copy(
                        selectedDocumentUri = event.uri,
                        selectedDocumentName = event.documentName
                    )
                }

            }
        }
    }

    private fun temp() {
        viewModelScope.launch {
            delay(1000)
        }
    }
}
