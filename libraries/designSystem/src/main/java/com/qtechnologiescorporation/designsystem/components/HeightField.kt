package com.qtechnologiescorporation.designsystem.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeightInputField(
    value: String,
    selectedUnit: String,
    onValueChange: (String) -> Unit,
    onUnitChange: (String) -> Unit,
    error: String?,
    labelColor: androidx.compose.ui.graphics.Color,
    textFieldColors: TextFieldColors,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val unitOptions = listOf("ft", "in", "m")

    OutlinedInputField(
        label = "Height*",
        value = value,
        onChange = onValueChange,
        modifier = modifier,
        placeholder = { Text("Enter height") },
        labelColor = labelColor,
        colors = textFieldColors,
        error = error,
        trailingIcon = {
            Box {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable { expanded = true }
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(selectedUnit)
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Dropdown arrow"
                    )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    unitOptions.forEach { unit ->
                        DropdownMenuItem(
                            text = { Text(unit) },
                            onClick = {
                                onUnitChange(unit)
                                expanded = false
                            }
                        )
                    }
                }
            }
        }
    )
}

@Composable
private fun InlineCommonTextField(
    label: String,
    value: String,
    error: String?,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            modifier = Modifier.fillMaxWidth(),
            isError = error != null
        )
        error?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                fontSize = 12.sp
            )
        }
    }
}

