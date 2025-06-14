package com.qtechnologiescorporation.designsystem.utils

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext

fun getFileNameFromUri(context: Context, uri: Uri): String {
    var name = "unknown"
    if (uri.scheme == "content") {
        val cursor = context.contentResolver.query(uri, null, null, null, null)
        cursor?.use {
            val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            if (it.moveToFirst() && nameIndex >= 0) {
                name = it.getString(nameIndex)
            }
        }
    } else if (uri.scheme == "file") {
        name = uri.pathSegments.lastOrNull() ?: "unknown"
    }
    return name
}

@Composable
fun rememberFilePickerLauncher(
    onFileSelected: (uri: String, fileName: String) -> Unit
): () -> Unit {
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri ->
        if (uri == null) {
            Toast.makeText(context, "Please select a document", Toast.LENGTH_SHORT).show()
        } else {
            val mimeType = context.contentResolver.getType(uri)
            if (mimeType in listOf("image/jpeg", "image/jpg", "image/png", "application/pdf")) {
                val fileName = getFileNameFromUri(context, uri)
                onFileSelected(uri.toString(), fileName)
                Toast.makeText(context, "Selected File: $fileName", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Unsupported file type: $mimeType", Toast.LENGTH_SHORT).show()
            }
        }
    }

    return {
        launcher.launch(arrayOf("image/jpeg", "image/jpg", "image/png", "application/pdf"))
    }
}