package com.qtechnologiescorporation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.qtechnologiescorporation.navigation.QMedicalFormNavigation
import org.koin.android.annotation.KoinViewModel


@KoinViewModel
class QMedicalFormViewModel(
    private val navigation: QMedicalFormNavigation
) : ViewModel() {

}
