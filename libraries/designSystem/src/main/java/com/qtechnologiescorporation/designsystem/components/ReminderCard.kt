package com.qtechnologiescorporation.designsystem.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ReminderCard(
    doctorName: String,
    courseDuration: String,
    startDate: String,
    endDate: String,
    medicineName: String,
    purpose: String,
    timeSlots: Map<String, String>
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFF00D998)),
        colors = androidx.compose.material3.CardDefaults.cardColors(
            containerColor = Color.Transparent // Set background to transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = doctorName,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(Color(0xFF00D998), shape = CircleShape)
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        text = purpose,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }


            Text("Course: $courseDuration days ($startDate to $endDate)", color = MaterialTheme.colorScheme.onBackground)
            Text("Medicine: $medicineName", color = MaterialTheme.colorScheme.onBackground)


            Spacer(modifier = Modifier.height(8.dp))
            Text("Time Slots:", fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.onBackground)
            timeSlots.forEach { (slot, times) ->
                if (times.isNotBlank()) {
                    Text("• $slot: $times", color = MaterialTheme.colorScheme.onBackground)
                }
            }
        }
    }
}

