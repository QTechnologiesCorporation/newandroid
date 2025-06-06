package com.qtechnologiescorporation.navigation

import com.qtechnologiescorporation.api.NavigationRoute
import kotlinx.serialization.Serializable


@Serializable
data object MedicalRecords : NavigationRoute

@Serializable
data object Medicine : NavigationRoute

@Serializable
data object UserNotes : NavigationRoute

@Serializable
data object UserUploadDocument : NavigationRoute

@Serializable
data object UserSubscription : NavigationRoute