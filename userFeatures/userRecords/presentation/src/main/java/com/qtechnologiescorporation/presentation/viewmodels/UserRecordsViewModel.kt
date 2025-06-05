package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.qtechnologiescorporation.navigation.UserRecordsNavigation
import org.koin.android.annotation.KoinViewModel


@KoinViewModel
class UserRecordsViewModel(
    private val navigation: UserRecordsNavigation
) : ViewModel() {

}
