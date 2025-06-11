package com.qtechnologiescorporation.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

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
        color = color,
        textAlign = TextAlign.Center
    )
}

@Composable
fun SecondaryHeading(
    heading: String,
    subheading: String? = null,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    style: TextStyle = MaterialTheme.typography.headlineLarge,
    subheadingStyle: TextStyle = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.W200),
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        // Heading
        Text(
            text = heading,
            style = style,
            color = color,
            textAlign = TextAlign.Center
        )

        // Subheading (if available)
        subheading?.let {
            Text(
                text = it,
                style = subheadingStyle,
                color = color,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun DescriptionText(
    description: String,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    style: TextStyle = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.W200),
    modifier: Modifier = Modifier
) {
    Text(
        text = description,
        style = style,
        color = color,
        textAlign = TextAlign.Center
    )
}