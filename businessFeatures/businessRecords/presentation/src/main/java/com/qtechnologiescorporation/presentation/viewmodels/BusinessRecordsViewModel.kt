package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.qtechnologiescorporation.navigation.BusinessRecordsNavigation
import org.koin.android.annotation.KoinViewModel


@KoinViewModel
class BusinessRecordsViewModel(
    private val navigation: BusinessRecordsNavigation
) : ViewModel() {

}
