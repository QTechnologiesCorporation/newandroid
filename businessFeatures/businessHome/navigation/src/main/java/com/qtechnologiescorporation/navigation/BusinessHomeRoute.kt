package com.qtechnologiescorporation.navigation

import com.qtechnologiescorporation.api.NavigationRoute
import kotlinx.serialization.Serializable

@Serializable
data object HealthQuestionnaire: NavigationRoute
@Serializable
data object QMedicalRecords : NavigationRoute

@Serializable
data object Prescriptions : NavigationRoute

@Serializable
data object BusinessNotes : NavigationRoute

@Serializable
data object BusinessUploadDocument : NavigationRoute
