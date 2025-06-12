package com.qtechnologiescorporation.designsystem.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.qtechnologiescorporation.designsystem.spacing

@Composable
fun YesNoDropdown(
    label: String,
    selected: String,
    onSelectedChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    labelColor: Color = MaterialTheme.colorScheme.onSurface,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        focusedTextColor = MaterialTheme.colorScheme.onSurface,
        unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
        unfocusedLeadingIconColor = MaterialTheme.colorScheme.onSurface,
        focusedLeadingIconColor = MaterialTheme.colorScheme.onSurface,
        unfocusedTrailingIconColor = MaterialTheme.colorScheme.onSurface,
        focusedTrailingIconColor = MaterialTheme.colorScheme.onSurface,
        focusedPlaceholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
        unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
        unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
        disabledBorderColor =  MaterialTheme.colorScheme.secondary,
        focusedBorderColor = MaterialTheme.colorScheme.secondary, // or .onSurface if you prefer
        errorBorderColor = MaterialTheme.colorScheme.errorContainer,
    )
) {
    val options = listOf("Yes", "No")
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            color = labelColor,
            modifier = Modifier.padding(bottom = MaterialTheme.spacing.small)
        )

        Box {
            OutlinedTextField(
                value = selected,
                onValueChange = {},
                readOnly = true,
                placeholder = {
                    if (selected.isBlank()) {
                        Text("Select")
                    }
                },
                textStyle = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    IconButton(onClick = { expanded = true }) {
                        Icon(Icons.Default.KeyboardArrowDown, contentDescription = null)
                    }
                },
                colors = colors
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            onSelectedChange(option)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}
