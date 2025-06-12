package com.qtechnologiescorporation.presentation.viewmodels


import androidx.compose.runtime.Immutable

@Immutable
data class FieldStateManageProfile(val text: String = "", val error: String? = null)


data class ManageProfileState(
    val username: FieldStateManageProfile = FieldStateManageProfile(),
    val firstName: FieldStateManageProfile = FieldStateManageProfile(),
    val lastName: FieldStateManageProfile = FieldStateManageProfile(),
    val dob: FieldStateManageProfile = FieldStateManageProfile(),
    val age: FieldStateManageProfile = FieldStateManageProfile(),
    val gender: FieldStateManageProfile = FieldStateManageProfile(),
    val email: FieldStateManageProfile = FieldStateManageProfile(),
    val phone: FieldStateManageProfile = FieldStateManageProfile()
)

sealed class ManageProfileEvent {
    data class UsernameChanged(val value: String) : ManageProfileEvent()
    data class FirstNameChanged(val value: String) : ManageProfileEvent()
    data class LastNameChanged(val value: String) : ManageProfileEvent()
    data class DobChanged(val value: String) : ManageProfileEvent()
    data class AgeChanged(val value: String) : ManageProfileEvent()
    data class GenderChanged(val value: String) : ManageProfileEvent()
    data class EmailChanged(val value: String) : ManageProfileEvent()
    data class PhoneChanged(val value: String) : ManageProfileEvent()
}
