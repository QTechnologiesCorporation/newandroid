package com.qtechnologiescorporation.designsystem.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun primaryGradientBackground(offsetY: Float = 1200f): Brush {
    val isDark = isSystemInDarkTheme()

    return if (isDark) {
        Brush.verticalGradient(
            colors = listOf(
                Color(0xFF141416),
                Color(0xFF007351).copy(alpha = 0.8f),
                Color(0xFF00D998).copy(alpha = 0.5f)
            ),
            startY = offsetY,
            endY = Float.POSITIVE_INFINITY
        )
    } else {
        Brush.verticalGradient(
            colors = listOf(
                Color(0xFFEBEBEB),
                Color(0xFFB4F4E0),
                Color(0xFF00D998).copy(alpha = 0.5f)
            ),
            startY = offsetY,
            endY = Float.POSITIVE_INFINITY
        )
    }
}

@Composable
fun primaryContainerGradientBackground(offsetY: Float = 800f): Brush {
    val isDark = isSystemInDarkTheme()

    return if (isDark) {
        Brush.horizontalGradient(
            colors = listOf(
                Color(0xFF007351).copy(.4f),
                Color(0xFF000F0B)
            )
        )
    } else {
        Brush.verticalGradient(
            colors = listOf(
                Color(0xFF00D998).copy(alpha = 0.7f),
                Color(0xFF00D998).copy(alpha = 0.7f),

            ),
            startY = offsetY,
            endY = Float.POSITIVE_INFINITY
        )
    }
}