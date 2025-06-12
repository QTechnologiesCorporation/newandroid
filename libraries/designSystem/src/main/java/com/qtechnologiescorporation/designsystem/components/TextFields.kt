package com.qtechnologiescorporation.designsystem.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
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
    labelColor: Color = MaterialTheme.colorScheme.onPrimary,
    iconColor: Color = MaterialTheme.colorScheme.primary,
    menuItemIcon: (T) -> ImageVector? = { null }
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxWidth()) {
        OutlinedInputField(
            label = label,
            value = value?.let(displayText) ?: "",
            onChange = {},
            placeholder = placeholder,
            readOnly = true,
            enabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .pointerInput(Unit) { detectTapGestures { expanded = true } },
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon ?: {
                Icon(
                    Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    tint = iconColor
                )
            },
            error = error,
            shape = shape
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = displayText(item),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.tertiary
                        )
                    },
                    onClick = {
                        expanded = false
                        onValueChange(item)
                    },
                    leadingIcon = menuItemIcon(item)?.let {
                        {
                            Icon(
                                imageVector = it,
                                contentDescription = null,
                                tint = iconColor
                            )
                        }
                    }
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
        }
    }
}