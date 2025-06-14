package com.qtechnologiescorporation.presentation.components


import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qtechnologiescorporation.designsystem.spacing
import com.qtechnologiescorporation.presentation.R

@Composable
fun HealthLevelIndicator(
    @DrawableRes iconRes: Int,
    rangeLabel: String,
    levelLabel: String,
    color: Color
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(iconRes),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))
        Text(rangeLabel, color = color, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))
        Text(levelLabel, color = color, style = MaterialTheme.typography.labelLarge)
    }
}

@Composable
fun HealthIndexComponent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Health Index",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(250.dp),
            contentAlignment = Alignment.Center
        ) {
            DiamondProgressMeter(percentage = 85)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(
                        horizontal = MaterialTheme.spacing.extraLarge,
                        vertical = MaterialTheme.spacing.medium
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HealthLevelIndicator(R.drawable.weak_icon, "< 35%", "Weak", Color(0xFFE53935))
                HealthLevelIndicator(
                    R.drawable.average_icon,
                    "35% - 60%",
                    "Average",
                    Color(0xFFFFEB3B)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(
                        horizontal = MaterialTheme.spacing.extraLarge,
                        vertical = MaterialTheme.spacing.medium
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HealthLevelIndicator(
                    R.drawable.healthy_icon,
                    "60% - 80%",
                    "Healthy",
                    Color(0xFFFFA726)
                )
                HealthLevelIndicator(
                    R.drawable.super_icon,
                    "80% - 100%",
                    "Super Human",
                    Color(0xFF00E676)
                )
            }
        }
    }
}

@Composable
fun DiamondProgressMeter(
    percentage: Int,
    size: Dp = 152.dp,
    strokeWidth: Dp = 16.dp
) {
    val animatedProgress by animateFloatAsState(
        targetValue = percentage / 100f,
        animationSpec = tween(durationMillis = 1000),
        label = "progress"
    )

    // 👇 Animated percentage value from 0 to target
    val animatedNumber by animateIntAsState(
        targetValue = percentage,
        animationSpec = tween(durationMillis = 1000),
        label = "animatedNumber"
    )

    val gradientBrush = Brush.linearGradient(
        colors = listOf(
            Color(0xFFB8F8E6),
            Color(0xFF00D998)
        )
    )

    Box(
        modifier = Modifier.size(size),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val sweepAngle = 360 * animatedProgress
            val stroke = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)

            val arcTopLeft = Offset(
                strokeWidth.toPx() / 2,
                strokeWidth.toPx() / 2
            )
            val arcSize = Size(
                size.toPx() - strokeWidth.toPx(),
                size.toPx() - strokeWidth.toPx()
            )

            // ✅ Inner background fill
            drawArc(
                color = Color(0xFFE6FAF4),
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = true,
                topLeft = arcTopLeft,
                size = arcSize
            )

            // ✅ Inner progress arc
            drawArc(
                brush = gradientBrush,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = true,
                topLeft = arcTopLeft,
                size = arcSize
            )
        }

        // ✅ Center circle with green border
        Box(
            modifier = Modifier
                .size(size / 2f)
                .background(Color.White, CircleShape)
                .border(width = 2.dp, color = Color(0xFF00D998), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$animatedNumber%",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}