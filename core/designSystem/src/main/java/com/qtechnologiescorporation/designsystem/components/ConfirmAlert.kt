package com.qtechnologiescorporation.designsystem.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qtechnologiescorporation.designsystem.R

@Composable
fun SuccessAlert(
    onDismiss: () -> Unit,
    text: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(enabled = false) {}
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .background(Color(0xFF00D998), RoundedCornerShape(20.dp))
                .padding(horizontal = 54.dp, vertical = 50.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_confirmtick), // ✅ your tick icon
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(60.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = text,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )


            }
        }
    }
}
