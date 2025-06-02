package com.qtechnologiescorporation.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.qtechnologiescorporation.designsystem.components.primaryGradient
import com.qtechnologiescorporation.presentation.viewmodels.UserAskTypeViewModel
import com.qtechnologiescorporation.presentation.viewmodels.UserAskTypes
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserAskTypeScreen(
    viewModel: UserAskTypeViewModel = koinViewModel(),
) {
    UserAskTypeScreenContent(
        navigateToUser = { viewModel.userAskTypeEvents(UserAskTypes.USER)},
        navigateToBusiness = { }
    )
}

@Composable
fun UserAskTypeScreenContent(navigateToUser: () -> Unit, navigateToBusiness: () -> Unit) {

    val gradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF141416),
            Color(0xFF007351),
            Color(0xFF00D998)
        ),
        startY = 1000f,
        endY = Float.POSITIVE_INFINITY
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        val backgroundBrush = primaryGradient()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(gradientBrush)
        ) {

        }
    }
}


//@Composable
//fun UserAskTypeContent() {
//   // var textColor = MaterialTheme.colorScheme.surface
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(MaterialTheme.colorScheme.background)
//    ) {
//        // Bottom Canvas Green Gradient Background
//        Canvas(modifier = Modifier.fillMaxSize()) {
//            val dotColor = Color(0x3326EA40)
//            val spacing = 40.dp.toPx()
//            val halfHeight = size.height / 2
//            // Top half black with green dots
//            drawRect(
//                color = textColor,
//                size = androidx.compose.ui.geometry.Size(size.width, halfHeight)
//            )
//
//        }
//
//
//        // Bottom Background Image
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(0.35f)
//                .align(Alignment.BottomCenter)
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.bottombg),
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.fillMaxSize()
//            )
//        }
//
//        // Foreground Content
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(horizontal = 24.dp)
//                .padding(bottom = 60.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Spacer(modifier = Modifier.height(40.dp))
//
//            // Logo Icon
//            Icon(
//                painter = painterResource(id = R.drawable.logo), // Replace with your Q logo
//                contentDescription = "Logo",
//                tint = Color(0xFF26EA40),
//                modifier = Modifier.size(82.dp)
//            )
//
//            Spacer(modifier = Modifier.height(12.dp))
//
//            Text(
//                text = "Q Life",
//                fontWeight = FontWeight.Bold,
//                fontSize = 24.sp,
//                color = MaterialTheme.colorScheme.onBackground
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            Row {
//                //Black
//
//                Text(
//                    text = "A",
//                    color = MaterialTheme.colorScheme.onBackground,
//                    fontSize = 14.sp,
//                    textAlign = TextAlign.Center
//                )
//                Text(
//                    text = " Centralized Platform",
//                    color = MaterialTheme.colorScheme.onBackground,
//                    fontSize = 14.sp,
//                    textAlign = TextAlign.Center,
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    text = " for Your Health Needs.",
//                    color = MaterialTheme.colorScheme.onBackground,
//                    fontSize = 14.sp,
//                    textAlign = TextAlign.Center
//                )
//            }
//
//
//            Spacer(modifier = Modifier.height(48.dp))
//            //Black
//            Text(
//                text = "How do you want to get started?",
//                color = MaterialTheme.colorScheme.onBackground,
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Medium
//            )
//
//            Spacer(modifier = Modifier.height(24.dp))
//
//            Button(
//                onClick = { navController.navigate("Login") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(48.dp),
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = Color(0xFF00D998),
//                    contentColor = Color.White
//                ),
//                shape = RoundedCornerShape(24.dp)
//            ) {
//                //White
//
//                Text("I'm a User", fontSize = 16.sp)
//            }
//
//            Spacer(modifier = Modifier.height(12.dp))
//
//            OutlinedButton(
//                onClick = { navController.navigate("BusinessLogin") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(48.dp),
//                colors = ButtonDefaults.outlinedButtonColors(
//                    containerColor = Color.Transparent,
//                    contentColor = MaterialTheme.colorScheme.onBackground
//                ),
//                //Black
//                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
//                shape = RoundedCornerShape(24.dp)
//            ) {
//                Text("I'm a Business", fontSize = 16.sp)
//            }
//            Spacer(modifier = Modifier.height(80.dp))
//
//        }
//    }
//}


@Composable
@PreviewLightDark
fun UserAskTypePreview() {
    UserAskTypeScreenContent()
}
