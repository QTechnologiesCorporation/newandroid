package com.qtechnologiescorporation.designsystem

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.qtechnologiescorporation.designsystem.R as Res


val SoraFontFamily = FontFamily(
    Font(Res.font.sora_w200_extralight, FontWeight.W200),
    Font(Res.font.sora_w400_regular, FontWeight.W400),
    Font(Res.font.sora_w500_medium, FontWeight.W500),
    Font(Res.font.sora_w600_semibold, FontWeight.W600),
    Font(Res.font.sora_w700_bold, FontWeight.W700)
)


val InterFontFamily = FontFamily(
    Font(Res.font.inter_w400_regular, FontWeight.W400),
    Font(Res.font.inter_w700_bold, FontWeight.W700)
)


@Composable
fun myCustomTypography(): Typography {
    return Typography(
        displaySmall = TextStyle(
            fontFamily = SoraFontFamily,
            fontWeight = FontWeight.W700,
            fontSize = 32.sp
        ),
        headlineLarge = TextStyle(
            fontFamily = SoraFontFamily,
            fontWeight = FontWeight.W700,
            fontSize = 24.sp
        ),
        headlineMedium = TextStyle(
            fontFamily = SoraFontFamily,
            fontWeight = FontWeight.W600,
            fontSize = 20.sp
        ),
        headlineSmall = TextStyle(
            fontFamily = SoraFontFamily,
            fontWeight = FontWeight.W500,
            fontSize = 18.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = InterFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 16.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = InterFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 14.sp
        ),
        bodySmall = TextStyle(
            fontFamily = InterFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 12.sp
        ),
        titleLarge = TextStyle(
            fontFamily = SoraFontFamily,
            fontWeight = FontWeight.W600,
            fontSize = 14.sp
        ),
        labelLarge = TextStyle(
            fontFamily = InterFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 16.sp
        ),
        labelMedium = TextStyle(
            fontFamily = InterFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 14.sp
        ),
        labelSmall = TextStyle(
            fontFamily = InterFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 10.sp
        )
    )
}