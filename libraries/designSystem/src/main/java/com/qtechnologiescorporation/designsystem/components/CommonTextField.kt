package com.qtechnologiescorporation.designsystem.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun CommonTextField(
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
            isError = error != null,
            modifier = Modifier.fillMaxWidth()
        )
        error?.let {
            Text(it, color = Color.Red, fontSize = 12.sp)
        }
    }
}
