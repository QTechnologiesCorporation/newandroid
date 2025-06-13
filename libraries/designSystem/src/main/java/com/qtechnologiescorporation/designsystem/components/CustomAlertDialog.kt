package com.qtechnologiescorporation.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.qtechnologiescorporation.designsystem.R as Res
import com.qtechnologiescorporation.designsystem.spacing


@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun PrimaryCustomAlertDialog(
    title: String,
    description: String? = null,
    successIcon: Int = Res.drawable.success,
    onDismiss: () -> Unit,
    dismissOnBackPress: Boolean = false,
    dismissOnClickOutside: Boolean = false,
    iconSize: Dp = 80.dp,
    backgroundBrush: Brush = primaryContainerGradientBackground(),
    shape: Shape = RoundedCornerShape(20.dp),
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false,
            dismissOnBackPress = dismissOnBackPress,
            dismissOnClickOutside = dismissOnClickOutside
        )
    ) {
        Card(
            shape = shape,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .wrapContentHeight(),
        ) {
            Column(
                modifier = Modifier
                    .background(backgroundBrush)
                    .padding(horizontal = 24.dp, vertical = MaterialTheme.spacing.extraLarge*2),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                SecondaryHeadingAndSubHeading(title)
                Spacer(Modifier.height(MaterialTheme.spacing.mediumLarge))
                Icon(
                    painter = painterResource(successIcon),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(iconSize)
                )
                Spacer(Modifier.height(MaterialTheme.spacing.mediumLarge))
                description?.let { DescriptionText(it) }
            }
        }
    }
}

@PreviewLightDark
@Composable
fun SuccessDialogPreview() {
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        PrimaryCustomAlertDialog(
            title = "Success!",
            description = null,
            onDismiss = { showDialog = false },
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    }

}