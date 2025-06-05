package com.qtechnologiescorporation.designsystem.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.qtechnologiescorporation.designsystem.QTechHealthTheme

@Composable
fun PrimaryButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    elevation: ButtonElevation = ButtonDefaults.buttonElevation(
        defaultElevation = 1.dp,
        pressedElevation = 1.dp
    ),
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ),
    isLoading: Boolean = false,
    shape: Shape = RoundedCornerShape(35.dp),
    contentPadding: PaddingValues = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
) {
    Button(
        onClick = onClick,
        modifier = modifier.width(220.dp),
        enabled = enabled,
        elevation = elevation,
        colors = colors,
        shape = shape,
        contentPadding = contentPadding
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(23.dp)
            )
        } else {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun SecondaryButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(
        contentColor = MaterialTheme.colorScheme.onBackground,
    ),
    border: BorderStroke = BorderStroke(
        width = 1.dp,
        color = MaterialTheme.colorScheme.onBackground
    ),
    shape: Shape = RoundedCornerShape(35.dp),
    contentPadding: PaddingValues = PaddingValues(horizontal = 12.dp, vertical = 12.dp)
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.width(220.dp),
        enabled = enabled,
        colors = colors,
        border = border,
        shape = shape,
        contentPadding = contentPadding
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
        )
    }
}
@PreviewLightDark
@Preview(showBackground = true)
@Composable
private fun ButtonsPreview() {
    QTechHealthTheme {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            PrimaryButton(
                label = "Primary Button",
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            )

            SecondaryButton(
                label = "Secondary Button",
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}