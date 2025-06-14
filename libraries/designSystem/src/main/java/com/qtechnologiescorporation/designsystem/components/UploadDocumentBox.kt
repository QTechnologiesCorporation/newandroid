package com.qtechnologiescorporation.designsystem.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.qtechnologiescorporation.designsystem.R
import com.qtechnologiescorporation.designsystem.spacing

@Composable
fun UploadDocumentBox(
    modifier: Modifier = Modifier,
    documentSelectedStatus: Boolean,
    selectedDocumentName: String,
    onSelectFile: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable { onSelectFile() }
            .fillMaxWidth()
            .height(160.dp)
            .dashedBorder(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(12.dp),
                strokeWidth = 2.dp,
                dashLength = 8.dp,
                gapLength = 6.dp,
            ),
        contentAlignment = Alignment.Center
    ) {
        if (documentSelectedStatus) {
            IconButton(
                onClick = { onSelectFile() },
                modifier = Modifier
                    .align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Document",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_upload),
                contentDescription = "Upload",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .height(40.dp)
                    .width(55.dp)
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
            Text(
                text = "Upload Document from your device",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSecondary
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))
            Text(
                text = if (documentSelectedStatus) "Update Document" else "Upload Document",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                color = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
            Text(
                text = selectedDocumentName,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }

    Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "Supported Formats: JPG, JPEG, PNG, PDF",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.6f)
        )
    }
}