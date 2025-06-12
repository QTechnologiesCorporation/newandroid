package com.qtechnologiescorporation.presentation.screens


import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.designsystem.components.BaseScreen
import com.qtechnologiescorporation.presentation.viewmodels.UserQiViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun UserQiScreen(
    viewModel: UserQiViewModel = koinViewModel(),
) {
    UserQiScreenContent()
}

@Composable
fun UserQiScreenContent() {

    BaseScreen {

    }
}

@Composable
@PreviewLightDark
fun UserQiScreenPreview() {
    QTechHealthTheme {
        UserQiScreenContent()
    }
}
