package com.qtechnologiescorporation.designsystem

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.qtechnologiescorporation.designsystem.R as Res


@Composable
private fun soraFontFamily(): FontFamily = FontFamily(
    Font(Res.font.sora_bold),
)

@Composable
private fun interFontFamily(): FontFamily = FontFamily(
    Font(Res.font.inter_regular, weight = FontWeight.W400),
)

private val defaultTypography = Typography()

@Composable
internal fun myCustomTypography(): Typography {
    val soraFontFamily = soraFontFamily()
    val interFontFamily = interFontFamily()

    return Typography(
        displaySmall = defaultTypography.displaySmall.copy(
            fontFamily = soraFontFamily,
            fontWeight = FontWeight.W700,
            fontSize = 32.sp
        ),
        headlineLarge = defaultTypography.headlineLarge.copy(
            fontFamily = soraFontFamily,
            fontWeight = FontWeight.W700,
            fontSize = 24.sp
        ),
        headlineMedium = defaultTypography.headlineMedium.copy(
            fontFamily = soraFontFamily,
            fontWeight = FontWeight.W600,
            fontSize = 20.sp
        ),
        headlineSmall = defaultTypography.headlineSmall.copy(
            fontFamily = soraFontFamily,
            fontWeight = FontWeight.W500,
            fontSize = 18.sp
        ),
        bodyLarge = defaultTypography.bodyLarge.copy(
            fontFamily = interFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 16.sp

        ),
        bodyMedium = defaultTypography.bodyMedium.copy(
            fontFamily = interFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 14.sp
        ),
        bodySmall = defaultTypography.bodySmall.copy(
            fontFamily = interFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 12.sp
        ),
        titleLarge = defaultTypography.titleLarge.copy(
            fontFamily = soraFontFamily,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp
        ),
        labelLarge = defaultTypography.labelLarge.copy(
            fontFamily = interFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 16.sp
        ),
        labelMedium = defaultTypography.labelMedium.copy(
            fontFamily = interFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 14.sp
        ),
        labelSmall = defaultTypography.labelSmall.copy(
            fontFamily = interFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 10.sp
        ),
    )
}