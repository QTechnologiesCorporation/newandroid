package com.qtechnologiescorporation.designsystem.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun PrimaryHeading(
    heading: String,
    color: Color = MaterialTheme.colorScheme.onSecondary,
    style: TextStyle = MaterialTheme.typography.headlineLarge,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = heading,
        style = style,
        color = color
    )
}