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
import com.qtechnologiescorporation.navigation.HomeNavigation
import org.koin.android.annotation.KoinViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenA(
    viewModel: UserHomeViewModel = koinViewModel(),
) {
    Box(modifier = Modifier.fillMaxSize().background(
        MaterialTheme.colorScheme.primary
    ), contentAlignment = Alignment.Center) {
        Button(onClick = {
            viewModel.navigateToScreenB()
        }) {
            Text("Go to Screen B", style = MaterialTheme.typography.titleLarge)
        }
    }
}

@KoinViewModel
class UserHomeViewModel(
    private val navigation: HomeNavigation,
) : ViewModel() {

    fun navigateToScreenB() {
        navigation.navigateToScreenB()
    }
}
