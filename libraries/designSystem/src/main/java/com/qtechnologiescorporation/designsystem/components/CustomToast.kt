package com.qtechnologiescorporation.designsystem.components

//@Composable
//fun ToastMessage(
//    modifier: Modifier = Modifier.padding(12.dp),
//    shape: RoundedCornerShape = CircleShape
//) {
//    val toastMessage by ToastManager.toastMessage.collectAsState()
//    val showMessage by ToastManager.showMessage.collectAsState()
//    val isSuccess by ToastManager.isSuccess.collectAsState()
//
//    if (showMessage) {
//        val backgroundColor = if (isSuccess) {
//            Color(0xFFB2F1C0)
//        } else {
//            Color(0xFFFFDAD6)
//        }
//
//        val iconColor = if (isSuccess) {
//            Color(0xFF2F6A43)
//        } else {
//            Color(0xFFFF2514)
//        }
//
//        val icon = if (isSuccess) Icons.Default.CheckCircle else Icons.Default.Close
//        val contentDescription = if (isSuccess) "Success icon" else "Error icon"
//
//        LaunchedEffect(showMessage) {
//            if (showMessage) {
//                delay(2000) // Hide after 2 seconds
//                ToastManager.hideToast()
//            }
//        }
//
//        Row(
//            modifier = modifier
//                .background(backgroundColor, shape)
//                .padding(12.dp)
//        ) {
//            Icon(
//                imageVector = icon,
//                contentDescription = contentDescription,
//                tint = iconColor,
//                modifier = Modifier.padding(end = 8.dp)
//            )
//            Text(text = toastMessage)
//        }
//    }
//}
//
//object ToastManager {
//    private val _toastMessage = MutableStateFlow("")
//    val toastMessage: StateFlow<String> = _toastMessage
//
//    private val _showMessage = MutableStateFlow(false)
//    val showMessage: StateFlow<Boolean> = _showMessage
//
//    private val _isSuccess = MutableStateFlow(true)
//    val isSuccess: StateFlow<Boolean> = _isSuccess
//
//    fun showToast(message: String, isSuccess: Boolean) {
//        _toastMessage.update { message }
//        _isSuccess.update { isSuccess }
//        _showMessage.update { true }
//    }
//
//    fun hideToast() {
//        _showMessage.update { false }
//        _toastMessage.update { "" }
//    }
//}

//@HiltViewModel
//class MyViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
//
//    fun insertData(data: String) {
//        viewModelScope.launch {
//            try {
//                repository.insertData(data)
//                ToastManager.showToast(message = "Data added successfully", isSuccess = true)
//            } catch (e: Exception) {
//                ToastManager.showToast(message = "Error while entering data", isSuccess = false)
//            }
//        }
//    }
//}

//@Composable
//fun MyScreen(viewModel: MyViewModel = hiltViewModel()) {
//    Scaffold(
//        topBar = { /* Top bar content here */ },
//        content = { paddingValues ->
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(paddingValues)
//            ) {
//                // Other screen components
//                Button(onClick = { viewModel.insertData("New Data") }) {
//                    Text("Add Data")
//                }
//                Box(
//                    modifier = Modifier
//                        .align(Alignment.BottomCenter)
//                        .padding(bottom = 124.dp)
//                ) {
//                    ToastMessage()
//                }
//            }
//        }
//    )
//}


//@Composable
//fun MyScreen(viewModel: MyViewModel = hiltViewModel()) {
//    Scaffold(
//        topBar = { /* Top bar content */ },
//        content = { paddingValues ->
//            Box(modifier = Modifier
//                .fillMaxSize()
//                .padding(paddingValues)) {
//
//                // Your actual screen content
//                Button(
//                    onClick = { viewModel.insertData("New Data") },
//                    modifier = Modifier.align(Alignment.Center)
//                ) {
//                    Text("Add Data")
//                }
//
//                // Toast overlaid using matchParentSize and zIndex
//                Box(
//                    modifier = Modifier
//                        .matchParentSize()
//                        .zIndex(1f) // Ensures it's on top
//                ) {
//                    ToastMessage(
//                        modifier = Modifier
//                            .align(Alignment.TopCenter)
//                            .padding(top = 16.dp)
//                    )
//                }
//            }
//        }
//    )
//}
//
//
//AnimatedVisibility(visible = showMessage) {
//    Row(
//        modifier = modifier
//            .background(backgroundColor, shape)
//            .padding(12.dp)
//    ) {
//        Icon(
//            imageVector = icon,
//            contentDescription = contentDescription,
//            tint = iconColor,
//            modifier = Modifier.padding(end = 8.dp)
//        )
//        Text(text = toastMessage)
//    }
//}
//
//matchParentSize() makes the overlay Box cover the entire content area inside the Scaffold.
//
//zIndex(1f) ensures ToastMessage renders above everything else.
//
//You still don’t need to wrap Scaffold itself — clean and modular.