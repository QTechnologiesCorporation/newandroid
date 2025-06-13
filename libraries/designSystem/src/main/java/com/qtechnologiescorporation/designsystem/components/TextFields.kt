package com.qtechnologiescorporation.designsystem.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.compose.ui.zIndex
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.designsystem.spacing

@Composable
fun OutlinedInputField(
    label: String,
    value: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    error: String? = null,
    shape: Shape = MaterialTheme.shapes.small,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    labelColor: Color = MaterialTheme.colorScheme.onPrimary,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        focusedTextColor = MaterialTheme.colorScheme.onPrimary,
        unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
        unfocusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
        focusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
        unfocusedTrailingIconColor = MaterialTheme.colorScheme.onPrimary,
        focusedTrailingIconColor = MaterialTheme.colorScheme.onPrimary,
        focusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f),
        unfocusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f),
        unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
        disabledBorderColor = MaterialTheme.colorScheme.secondary,
        focusedBorderColor = MaterialTheme.colorScheme.secondary,
        errorBorderColor = MaterialTheme.colorScheme.errorContainer,
    )
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            color = labelColor
        )

        OutlinedTextField(
            value = value,
            onValueChange = onChange,
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyLarge,
            placeholder = placeholder,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            isError = error != null,
            shape = shape,
            enabled = enabled,
            readOnly = readOnly,
            visualTransformation = visualTransformation,
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions,
            singleLine = singleLine,
            maxLines = maxLines,
            minLines = minLines,
            colors = colors
        )

        InputFieldError(error)
    }
}


@OptIn(ExperimentalMaterial3Api::class) // Or androidx.compose.material.ExposedDropdownMenuBox for M2
@Composable
fun <T> OutlinedDropdownField2(
    label: String,
    value: T?,
    onValueChange: (T) -> Unit,
    items: List<T>,
    modifier: Modifier = Modifier,
    displayText: (T) -> String = { it.toString() },
    placeholderText: String? = null, // Simpler placeholder
    leadingIcon: @Composable (() -> Unit)? = null,
    // trailingIcon is usually handled by ExposedDropdownMenuBox
    error: String? = null,
    shape: Shape = RoundedCornerShape(8.dp), // Consider MaterialTheme.shapes.small/medium
    labelColor: Color = MaterialTheme.colorScheme.onSecondary,
    // ... other colors
    menuItemIcon: (T) -> ImageVector? = { null }
) {
    var expanded by remember { mutableStateOf(false) } // Initial state should be false
    val borderColor =
        if (error != null) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        OutlinedTextField(
            // Or a custom Surface + Text if OutlinedTextField doesn't fit
            value = value?.let(displayText) ?: "",
            onValueChange = { /* This OutlinedTextField is often read-only here */ },
            readOnly = true, // Important for dropdown behavior
            label = { Text(label, color = labelColor) },
            placeholder = placeholderText?.let { { Text(it) } },
            leadingIcon = leadingIcon,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            isError = error != null,
            shape = shape,
            modifier = Modifier
                .menuAnchor(
                    ExposedDropdownMenuAnchorType.PrimaryEditable,
                    true
                ) // Crucial for positioning the dropdown
                .fillMaxWidth(),
            // Apply colors and other styles as needed
        )

        ExposedDropdownMenu(
            border = BorderStroke(1.dp, borderColor),
            expanded = expanded,
            onDismissRequest = { expanded = false },
            containerColor = MaterialTheme.colorScheme.background,
            tonalElevation = 0.dp,
            shadowElevation = 0.dp,
            modifier = Modifier.exposedDropdownSize(true) // Adjust sizing
        ) {
            items.forEachIndexed { index, item ->
                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            menuItemIcon(item)?.let {
                                Icon(
                                    imageVector = it,
                                    contentDescription = null,
                                    // tint = ...,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(Modifier.width(8.dp))
                            }
                            Text(displayText(item))
                        }
                    },
                    onClick = {
                        onValueChange(item)
                        expanded = false
                    },
                    trailingIcon = if (value == item) { // Optional: Show a checkmark
                        { Icon(Icons.Filled.Check, contentDescription = "Selected") }
                    } else null
                )
                if (index < items.size - 1) {
                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = MaterialTheme.spacing.medium
                            ),
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.2f)
                    )
                }
            }
        }
    }
    // Display error text below the ExposedDropdownMenuBox if needed
    error?.let {
        Text(
            text = it,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier.padding(start = 16.dp, top = 4.dp) // Adjust padding
        )
    }
}

@Composable
fun <T> OutlinedDropdownField(
    label: String,
    value: T?,
    onValueChange: (T) -> Unit,
    items: List<T>,
    modifier: Modifier = Modifier,
    displayText: (T) -> String = { it.toString() },
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    error: String? = null,
    shape: Shape = RoundedCornerShape(8.dp),
    labelColor: Color = MaterialTheme.colorScheme.onSecondary,
    iconColor: Color = MaterialTheme.colorScheme.onSecondary,
    menuItemIcon: (T) -> ImageVector? = { null }
) {
    var expanded by remember { mutableStateOf(false) }
    val borderColor =
        if (error != null) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
    val rotationState by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f, label = "Dropdown Arrow Rotation"
    )

    Box(modifier = modifier.zIndex(2f)) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelLarge,
                color = labelColor
            )
            Spacer(Modifier.height(MaterialTheme.spacing.small))
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = shape,
                border = BorderStroke(1.dp, borderColor),
                color = Color.Transparent,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .zIndex(3f)
                        .clickable { expanded = !expanded }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            leadingIcon?.let {
                                it()
                                Spacer(Modifier.width(8.dp))
                            }
                            if ((value == null || (value is String && value.isEmpty())) && placeholder != null) {
                                placeholder()
                            } else {
                                Text(
                                    text = value?.let(displayText) ?: "",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.onSecondary
                                )
                            }
                        }

                        trailingIcon?.let {
                            it()
                        } ?: Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = null,
                            tint = iconColor,
                            modifier = Modifier.rotate(rotationState)
                        )
                    }

                    AnimatedVisibility(visible = expanded) {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            items.forEachIndexed { index, item ->
                                val isSelected = value == item
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable {
                                            expanded = false
                                            onValueChange(item)
                                        }
                                        .padding(horizontal = 12.dp, vertical = 10.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    menuItemIcon(item)?.let {
                                        Icon(
                                            imageVector = it,
                                            contentDescription = null,
                                            tint = iconColor,
                                            modifier = Modifier.size(20.dp)
                                        )
                                        Spacer(Modifier.width(8.dp))
                                    }
                                    Text(
                                        text = displayText(item),
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = MaterialTheme.colorScheme.onSecondary,
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(vertical = MaterialTheme.spacing.extraSmall)
                                    )
                                    if (isSelected) {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = "Selected",
                                            tint = iconColor
                                        )
                                    }
                                }
                                if (index < items.size - 1) {
                                    HorizontalDivider(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(
                                                horizontal = MaterialTheme.spacing.medium
                                            ),
                                        thickness = 1.dp,
                                        color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.2f)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            error?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

@Composable
private fun InputFieldError(
    error: String?,
) {
    AnimatedVisibility(
        visible = error != null,
        enter = slideInVertically(),
        exit = slideOutVertically()
    ) {
        if (error != null) {
            Text(
                text = error,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.errorContainer,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.spacing.small),
            )
        }
    }
}

@Preview(showBackground = true)
@PreviewLightDark
@Composable
private fun InputFieldsPreview() {
    QTechHealthTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedInputField(
                label = "Email",
                value = "",
                onChange = {},
                placeholder = {
                    Text("placeholder@mail.com")
                },
                error = null
            )

            OutlinedInputField(
                label = "Password",
                value = "",
                onChange = {},
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Visibility,
                        contentDescription = null
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Lock,
                        contentDescription = null
                    )
                }
            )

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
            OutlinedDropdownField(
                label = "Select Document",
                value = "ldjfdsf df",
                onValueChange = {
                },
                items = listOf("National ID", "Passport", "Driving License"),
                displayText = { it },
                placeholder = {
                    Text("Choose document")
                },
            )

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
        }
    }
}