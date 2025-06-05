package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.qtechnologiescorporation.navigation.BusinessHomeNavigation
import org.koin.android.annotation.KoinViewModel


@KoinViewModel
class BusinessHomeViewModel(
    private val navigation: BusinessHomeNavigation
) : ViewModel() {

}
