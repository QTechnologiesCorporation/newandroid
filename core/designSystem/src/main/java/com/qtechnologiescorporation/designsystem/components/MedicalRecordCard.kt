package com.qtechnologiescorporation.designsystem.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Attachment
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.AttachFile
import androidx.compose.material.icons.outlined.Attachment
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp




@Composable
fun MedicalRecordCard(
    doctorName: String,
    specialization: String,
    consultationType: String,
    lastCollectedTime: String,
    reportSummary: String,
    fileName: String,
    verified:Boolean,
    onViewClick: () -> Unit
) {
    Card(
        border = BorderStroke(1.dp, Color(0xFF00D998)),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

          if(verified) {
              Box(
                  modifier = Modifier
                      .clip(RoundedCornerShape(30.dp)) // ✅ This applies the rounded corners visually
                      .border(
                          width = 1.dp,
                          color = Color(0xFF00D998),
                          shape = RoundedCornerShape(30.dp)
                      )
                      .background(Color(0xFF00D998))
                      .padding(horizontal = 7.dp, vertical = 0.dp)
              ) {
                  Text(
                      text = "verified",
                      fontSize = 10.sp,
                      color = Color.White,
                      fontWeight = FontWeight.SemiBold
                  )
              }
          }
    Spacer(Modifier.height(10.dp))

            // Header Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                            text = doctorName,
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
                            color = MaterialTheme.colorScheme.onBackground
                        )



                    Text(
                        text = specialization,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

                Column(horizontalAlignment = Alignment.End) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .background(Color(0xFF00D998), CircleShape)
                        )
                        Spacer(Modifier.width(4.dp))
                        Text(
                            text = consultationType,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        )


                    }
//                    Spacer(modifier = Modifier.height(1.dp))
                    Text(
                        text = "Last Edited: $lastCollectedTime",
                        fontSize =9.sp,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Report Summary
            Text(
                text = reportSummary,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onBackground,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Attached Files
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Outlined.AttachFile, // use appropriate icon
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Attached Files",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row {
                Text(
                    text = fileName,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "View Document",
                    fontSize = 12.sp,
                    color = Color(0xFF00D998),
                    modifier = Modifier.clickable { onViewClick() }
                )
            }
        }
    }
}