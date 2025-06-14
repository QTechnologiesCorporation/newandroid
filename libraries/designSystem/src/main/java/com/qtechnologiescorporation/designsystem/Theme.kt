package com.qtechnologiescorporation.designsystem

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    error = errorLight,
    onError = onErrorLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
)

private val DarkColorScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    error = errorDark,
    onError = onErrorDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
)

@Composable
fun QTechHealthTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // darkTheme: Boolean = false,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = myCustomTypography(),
    ) {
        CompositionLocalProvider(
            LocalSpacing provides Spacing.Companion.Default,
        ) {
            content()
        }
    }
}