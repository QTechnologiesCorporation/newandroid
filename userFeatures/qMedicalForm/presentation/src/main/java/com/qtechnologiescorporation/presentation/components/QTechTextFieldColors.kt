package com.qtechnologiescorporation.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun qTechTextFieldColors(): TextFieldColors = OutlinedTextFieldDefaults.colors(
    focusedContainerColor = Color.Transparent,
    unfocusedContainerColor = Color.Transparent,
    focusedTextColor = MaterialTheme.colorScheme.onBackground,
    unfocusedTextColor = MaterialTheme.colorScheme.onBackground,
    unfocusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
    focusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
    unfocusedTrailingIconColor = MaterialTheme.colorScheme.onBackground,
    focusedTrailingIconColor = MaterialTheme.colorScheme.onBackground,
    focusedPlaceholderColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
    unfocusedPlaceholderColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
    unfocusedBorderColor = MaterialTheme.colorScheme.primary,
    disabledBorderColor = MaterialTheme.colorScheme.primary,
    focusedBorderColor = MaterialTheme.colorScheme.primary,
    errorBorderColor = MaterialTheme.colorScheme.errorContainer,
)