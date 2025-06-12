package com.qtechnologiescorporation.presentation.viewmodels


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ManageProfileViewModel : ViewModel() {
    private val _state = MutableStateFlow(ManageProfileState())
    val state: StateFlow<ManageProfileState> = _state

    fun onEvent(event: ManageProfileEvent) {
        _state.update {
            when (event) {
                is ManageProfileEvent.UsernameChanged -> it.copy(username = it.username.copy(text = event.value))
                is ManageProfileEvent.FirstNameChanged -> it.copy(firstName = it.firstName.copy(text = event.value))
                is ManageProfileEvent.LastNameChanged -> it.copy(lastName = it.lastName.copy(text = event.value))
                is ManageProfileEvent.DobChanged -> it.copy(dob = it.dob.copy(text = event.value))
                is ManageProfileEvent.AgeChanged -> it.copy(age = it.age.copy(text = event.value))
                is ManageProfileEvent.GenderChanged -> it.copy(gender = it.gender.copy(text = event.value))
                is ManageProfileEvent.EmailChanged -> it.copy(email = it.email.copy(text = event.value))
                is ManageProfileEvent.PhoneChanged -> it.copy(phone = it.phone.copy(text = event.value))
            }
        }
    }
}
