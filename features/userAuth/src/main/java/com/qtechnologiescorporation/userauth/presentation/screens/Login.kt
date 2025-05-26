package com.qtechnologiescorporation.userauth.presentation.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qtechnologiescorporation.designsystem.R
import com.qtechnologiescorporation.userauth.presentation.components.CustomOutlinedField


@Composable
fun LoginScreen(isDarkTheme:Boolean) {

    val textColor = MaterialTheme.colorScheme.surface
    Box(modifier = Modifier.fillMaxSize()) {

        // Top black & bottom green Canvas background
        Canvas(modifier = Modifier.fillMaxSize()) {
            val halfHeight = size.height / 1
            drawRect(
                color = textColor,
                size = androidx.compose.ui.geometry.Size(size.width, halfHeight)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f)
                .align(Alignment.BottomCenter)
                .background(MaterialTheme.colorScheme.background)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bottombg),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Login Card Content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
//                    .border(0.1.dp, Color(0xFFffffff), RoundedCornerShape(24.dp))
                    .background( MaterialTheme.colorScheme.background) // Remove glass overlay since image used
                    .padding(0.dp)
            ) {
                Spacer(Modifier.height(50.dp))
                // Background Image for the card
                Image(
                    painter = painterResource(  id =if(isDarkTheme) R.drawable.logincard else R.drawable.logincardwhite), // 🔁 Your card background imageR>
                    contentDescription = "Card Background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .matchParentSize()
                        .clip(RoundedCornerShape(24.dp))
                )

                // Card Content
                Column(
                    modifier = Modifier.padding(24.dp), // inner padding for content
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(20.dp))

                    Text("Welcome to Q Life!", fontSize = 24.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                    Text("Your Centralized Health Data Hub", fontSize = 14.sp, color = Color.White)

                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = "Login",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        modifier = Modifier.fillMaxWidth() // ⬅️ Make it take full width
                    )
//                    Spacer(modifier = Modifier.height(8.dp))

                    // Username Field
                    CustomOutlinedField(isDarkTheme,label = "Username or User ID")

                    CustomOutlinedField(isDarkTheme,label = "Password",

                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.Visibility,
                                contentDescription = "Show Password",
                                tint = Color.White
                            )
                        })

                    Text(
                        text = "Forgot Password?",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .align(Alignment.End)
                            .clickable {
//                                navController.navigate("ForgotPassword")
                            }
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    // Sign Up Button
                    Button(
                        onClick = {
//                            navController.navigate("home")
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = if(isDarkTheme) Color(0xFF00D998) else Color.White),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(45.dp),
                        shape = RoundedCornerShape(30.dp)
                    ) {
                        Text("Login", color = Color.Black, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row {
                        Text("Don’t have an account?", color = Color.White, fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            "Sign up.",
                            color = Color(0xFFFFFFFF),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            modifier = Modifier.clickable {
//                                navController.navigate("CreateAccount")
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                }
            }
        }

    }
}

