package com.qtechnologiescorporation.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.qtechnologiescorporation.navigation.DetailsNavigation
import org.koin.android.annotation.KoinViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenB(
    viewModel: UserProfileViewModel = koinViewModel(),
) {
    Box(modifier = Modifier.fillMaxSize().background(
        MaterialTheme.colorScheme.secondary
    ), contentAlignment = Alignment.Center) {
        Button(onClick = {
            viewModel.navigateToScreenA()
        }) {
            Text("Go to Screen A")
        }
    }
}

@KoinViewModel
class UserProfileViewModel(
    private val navigation: DetailsNavigation,
) : ViewModel() {

    fun navigateToScreenA() {
        navigation.navigateToScreenA()
    }
}