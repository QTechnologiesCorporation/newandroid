package com.qtechnologiescorporation.designsystem.components


//@Composable
//fun SubscriptionPlanCard(
//    title: String,
//    price: String = "",
//    features: List<String>,
//    buttonText: String,
//    isRecommended: Boolean = false,
//    navController: NavController,
//    navigateName: String
//) {
//    Box {
//        Card(
//            shape = RoundedCornerShape(12.dp),
//            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
//            modifier = Modifier
//                .width(170.dp)
//                .height(330.dp)
//                .border(2.dp, Color(0xFF00D998), RoundedCornerShape(12.dp))
//        ) {
//            Column(
//                modifier = Modifier.padding(16.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(title, fontWeight = FontWeight.Bold, fontSize = 14.sp)
//                if (price.isNotEmpty()) {
//                    Text(price, fontSize = 12.sp, color = Color.Gray)
//                }
//
//                Spacer(modifier = Modifier.height(8.dp))
//
//                features.forEach {
//                    Text("• $it", fontSize = 12.sp, color = Color.Black)
//                }
//
//                Spacer(modifier = Modifier.height(12.dp))
//
//                Button(
//                    onClick = { navController.navigate(navigateName) },
//                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
//                    shape = RoundedCornerShape(8.dp)
//                ) {
//                    Text(buttonText, color = Color(0xFF00D998), fontSize = 12.sp)
//                }
//            }
//        }
//
//        if (isRecommended) {
//            Box(
//                modifier = Modifier
//                    .align(Alignment.TopEnd)
//                    .background(Color.Black, RoundedCornerShape(bottomStart = 8.dp))
//                    .padding(horizontal = 6.dp, vertical = 2.dp)
//            ) {
//                Row(verticalAlignment = Alignment.CenterVertically) {
////                    Image(
////                        painter = painterResource(id = R.drawable.ic_recommended),
////                        contentDescription = "Recommended Icon",
////                        modifier = Modifier.size(10.dp)
////                    )
//                    Spacer(modifier = Modifier.width(4.dp))
//                    Text("Recommended", fontSize = 8.sp, color = Color.White)
//                }
//            }
//        }
//    }
//}
