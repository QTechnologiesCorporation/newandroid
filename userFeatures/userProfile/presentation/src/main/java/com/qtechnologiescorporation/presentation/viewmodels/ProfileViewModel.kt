package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.qtechnologiescorporation.navigation.DetailsNavigation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.android.annotation.KoinViewModel

// UI State
data class ProfileUiState(
    val userName: String = "User name",
    val userId: String = "34968337",
    val isChatEnabled: Boolean = true
)

// Navigation Events
sealed class ProfileNavigationEvent {
    object ManageProfile : ProfileNavigationEvent()
    object Connections : ProfileNavigationEvent()
    object Subscription : ProfileNavigationEvent()
    object Activity : ProfileNavigationEvent()
    object BlockedAccounts : ProfileNavigationEvent()
    object Accessibility : ProfileNavigationEvent()
    object Settings : ProfileNavigationEvent()
    object AccountStatus : ProfileNavigationEvent()
    object QrScan : ProfileNavigationEvent()
    object Chat : ProfileNavigationEvent()
    object Support : ProfileNavigationEvent()
    object About : ProfileNavigationEvent()
    object Terms : ProfileNavigationEvent()
    object Logout : ProfileNavigationEvent()
    object AddAccount : ProfileNavigationEvent()
}

@KoinViewModel
class ProfileViewModel(
    private val navigation: DetailsNavigation
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState()) // ✅ Fixed name
    val uiState = _uiState.asStateFlow()

    fun toggleChat(enabled: Boolean) {
        _uiState.update { it.copy(isChatEnabled = enabled) }
    }

    fun onNavigationClick(route: ProfileNavigationEvent) {
        when (route) {
            ProfileNavigationEvent.ManageProfile -> navigation.navigateToManageProfile()
            ProfileNavigationEvent.Connections -> navigation.navigateToConnections()
            ProfileNavigationEvent.Subscription -> navigation.navigateToSubscription()
            ProfileNavigationEvent.Activity -> navigation.navigateToActivity()
            ProfileNavigationEvent.BlockedAccounts -> navigation.navigateToBlockedAccounts()
            ProfileNavigationEvent.Accessibility -> navigation.navigateToAccessibility()
            ProfileNavigationEvent.Settings -> navigation.navigateToSettings()
            ProfileNavigationEvent.AccountStatus -> navigation.navigateToAccountStatus()
            ProfileNavigationEvent.QrScan -> navigation.navigateToQrScan()
            ProfileNavigationEvent.Chat -> navigation.navigateToChat()
            ProfileNavigationEvent.Support -> navigation.navigateToSupportAndHelp()
            ProfileNavigationEvent.About -> navigation.navigateToAboutUs()
            ProfileNavigationEvent.Terms -> navigation.navigateToTermsAndPrivacyPolicy()
            ProfileNavigationEvent.Logout -> navigation.navigateToLogout()
            ProfileNavigationEvent.AddAccount -> navigation.navigateToAddAccount()
        }
    }
}
