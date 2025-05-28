package com.qtechnologiescorporation.designsystem

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.qtechnologiescorporation.designsystem.R as Res


@Composable
private fun soraFontFamily(): FontFamily = FontFamily(
    Font(Res.font.sora_semibold, weight = FontWeight.SemiBold),
    Font(Res.font.sora_thin, weight = FontWeight.Thin),
)

private val defaultTypography = Typography()

@Composable
internal fun myCustomTypography(): Typography {
    val soraFontFamily = soraFontFamily()

    return Typography(
        displayLarge = defaultTypography.displayLarge.copy(
            fontFamily = soraFontFamily,
            fontWeight = FontWeight.Bold,
        ),
        displayMedium = defaultTypography.displayMedium.copy(
            fontFamily = soraFontFamily,
            fontWeight = FontWeight.Bold,
        ),
        displaySmall = defaultTypography.displaySmall.copy(
            fontFamily = soraFontFamily,
            fontWeight = FontWeight.Bold,
        ),
        headlineLarge = defaultTypography.headlineLarge.copy(
            fontFamily = soraFontFamily,
            fontWeight = FontWeight.Bold,
        ),
        headlineMedium = defaultTypography.headlineMedium.copy(
            fontFamily = soraFontFamily,
            fontWeight = FontWeight.Bold,
        ),
        headlineSmall = defaultTypography.headlineSmall.copy(
            fontFamily = soraFontFamily,
            fontWeight = FontWeight.Bold,
        ),
        titleLarge = defaultTypography.titleLarge.copy(
            fontFamily = soraFontFamily,
            fontWeight = FontWeight.Bold,
        ),
        titleMedium = defaultTypography.titleMedium.copy(
            fontFamily = soraFontFamily,
            fontWeight = FontWeight.Bold,
        ),
        titleSmall = defaultTypography.titleSmall.copy(
            fontFamily = soraFontFamily,
            fontWeight = FontWeight.Bold,
        ),
        bodyLarge = defaultTypography.bodyLarge.copy(
            fontFamily = soraFontFamily,
        ),
        bodyMedium = defaultTypography.bodyMedium.copy(
            fontFamily = soraFontFamily,
        ),
        bodySmall = defaultTypography.bodySmall.copy(
            fontFamily = soraFontFamily,
        ),
        labelLarge = defaultTypography.labelLarge.copy(
            fontFamily = soraFontFamily,
            fontWeight = FontWeight.Bold,
        ),
        labelMedium = defaultTypography.labelMedium.copy(
            fontFamily = soraFontFamily,
        ),
        labelSmall = defaultTypography.labelSmall.copy(
            fontFamily = soraFontFamily,
        ),
    )
}