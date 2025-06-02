package com.qtechnologiescorporation.designsystem.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush

@Composable
fun primaryGradient(gradientOffsetY: Float = 900f): Brush {
    val background = MaterialTheme.colorScheme.background
    val container = MaterialTheme.colorScheme.primaryContainer

    return Brush.verticalGradient(
        colors = listOf(
            background,
            container,
        ),
        startY = gradientOffsetY,
        endY = Float.POSITIVE_INFINITY
    )
}