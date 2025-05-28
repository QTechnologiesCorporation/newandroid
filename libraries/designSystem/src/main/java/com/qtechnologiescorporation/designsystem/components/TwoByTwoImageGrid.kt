package com.qtechnologiescorporation.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TwoByTwoImageGrid(
    imageResIds: List<Int>,
    spacing: Dp = 10.dp,
    imageWidth: Dp = 200.dp,
    imageHeightRatio: Float = 1f // 1:1 ratio for square images
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(spacing),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        for (row in 0 until 2) {
//            Row(
//                horizontalArrangement = Arrangement.spacedBy(spacing),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                for (col in 0 until 2) {
//                    val index = row * 2 + col
//                    if (index < imageResIds.size) {
//                        Box(
//                            modifier = Modifier
//                                .width(imageWidth)
//                                .aspectRatio(imageHeightRatio) // Ensures consistent height
//                                .clip(RoundedCornerShape(12.dp))
//                        ) {
//                            Image(
//                                painter = painterResource(id = imageResIds[index]),
//                                contentDescription = "Image $index",
//                                contentScale = ContentScale.Crop,
//                                modifier = Modifier.fillMaxSize()
//                            )
//                        }
//                    } else {
//                        Spacer(
//                            modifier = Modifier
//                                .width(imageWidth)
//                                .aspectRatio(imageHeightRatio)
//                        )
//                    }
//                }
//            }
//        }
    }
}
