package com.qtechnologiescorporation.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.qtechnologiescorporation.designsystem.spacing

/**
 * A reusable screen layout with a gradient background and a centered Card container.
 * Useful for forms, dialogs, or content that needs elevation and visual separation.
 *
 * @param modifier Optional Modifier for outer Box.
 * @param backgroundOffset Y-offset to control gradient start.
 * @param innerPadding Padding values for inner column layout.
 * @param cardModifier Modifier for the Card.
 * @param cardShape Shape of the Card (default: RoundedCornerShape).
 * @param cardBackground Brush background for inside the Card.
 * @param content The content to display inside the Card.
 */
@Composable
fun BaseCardScreen(
    modifier: Modifier = Modifier,
    backgroundOffset: Float = 1900f,
    innerPadding: PaddingValues = PaddingValues(0.dp),
    cardModifier: Modifier = Modifier
        .fillMaxWidth(0.8f)
        .fillMaxHeight(0.6f),
    cardShape: Shape = RoundedCornerShape(20.dp),
    cardBackground: Brush = primaryContainerGradientBackground(),
    content: @Composable ColumnScope.() -> Unit
) {
    val backgroundBrush = primaryGradientBackground(backgroundOffset)
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundBrush)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                shape = cardShape,
                modifier = cardModifier
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(cardBackground)
                        .padding(horizontal = MaterialTheme.spacing.large),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    content = content
                )
            }
        }
    }
}

/**
 * A simple reusable screen layout with a gradient background and centered content.
 * Suitable for full-screen pages without a Card container.
 *
 * @param modifier Optional Modifier for outer Box.
 * @param backgroundOffset Y-offset to control gradient start.
 * @param innerPadding Padding values for content placement.
 * @param content The content to display directly within the screen.
 */
@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    backgroundOffset: Float = 1900f,
    innerPadding: PaddingValues = PaddingValues(0.dp),
    content: @Composable ColumnScope.() -> Unit
) {
    val backgroundBrush = primaryGradientBackground(backgroundOffset)
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundBrush)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            content = content
        )
    }
}