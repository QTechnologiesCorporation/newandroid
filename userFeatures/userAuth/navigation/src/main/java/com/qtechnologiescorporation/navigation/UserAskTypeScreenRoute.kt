package com.qtechnologiescorporation.navigation

import com.qtechnologiescorporation.api.NavigationRoute
import kotlinx.serialization.Serializable

@Serializable
data object UserAskTypeRoute : NavigationRoute
@Serializable
data object UserSignInRoute : NavigationRoute

@Serializable
data object UserSignUpRoute : NavigationRoute
