package com.qtechnologiescorporation.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.designsystem.components.OutlinedInputField
import com.qtechnologiescorporation.designsystem.components.PrimaryButton
import com.qtechnologiescorporation.presentation.viewmodels.*
import com.qtechnologiescorporation.designsystem.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun ManageProfileScreen(viewModel: ManageProfileViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    ManageProfileScreenContent(
        state = state,
        onEvent = viewModel::onEvent
    )
}


@Composable
fun ManageProfileScreenContent(
    state: ManageProfileState,
    onEvent: (ManageProfileEvent) -> Unit
) {

    val labelColor = MaterialTheme.colorScheme.onBackground

    Scaffold(
        topBar = {
//            TopBar(
//                title = "Manage Profile",
//                onBackClick = {
//                    // TODO: Handle navigation back
//                }
//            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            // Profile Picture
            Box(contentAlignment = Alignment.BottomEnd) {
                // Profile Image
                Image(
                    painter = painterResource(id = R.drawable.zee),
                    contentDescription = "Profile",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(90.dp)
                        .clip(CircleShape)
                )

                // Edit Icon with white background circle
                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.background)
                        .padding(4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_edit),
                        contentDescription = "Edit",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }


            Spacer(modifier = Modifier.height(12.dp))
            Text("Let's personalize your experience!", style = MaterialTheme.typography.bodySmall,color=MaterialTheme.colorScheme.onSecondary)
            Spacer(modifier = Modifier.height(24.dp))

            val spacing = 0.dp

            // Fields
            OutlinedInputField(
                label = "",
                value = state.username.text,
                onChange = { onEvent(ManageProfileEvent.UsernameChanged(it)) },
                error = state.username.error,
                placeholder = { Text("Username") },

                labelColor = labelColor,
//                colors = textFieldColors,
            )

            Spacer(modifier = Modifier.height(spacing))
            OutlinedInputField(
                label = "",
                value = state.firstName.text,
                onChange = { onEvent(ManageProfileEvent.FirstNameChanged(it)) },
                error = state.firstName.error,
                labelColor = labelColor,
//                colors = textFieldColors,
                placeholder = { Text("Full Name") },

                )

            Spacer(modifier = Modifier.height(spacing))
//        OutlinedInputField(
//            label = "Last Name",
//            value = state.lastName.text,
//            onChange = { onEvent(ManageProfileEvent.LastNameChanged(it)) },
//            error = state.lastName.error,
//            labelColor = labelColor,
//            placeholder = { Text("Username") },
//
//            colors = textFieldColors,
//        )

            Spacer(modifier = Modifier.height(spacing))
            OutlinedInputField(
                label = "",
                value = state.dob.text,
                onChange = { onEvent(ManageProfileEvent.DobChanged(it)) },
                error = state.dob.error,
                labelColor = labelColor,
//                colors = textFieldColors,
                placeholder = { Text("Date of Birth") },

                )

            Spacer(modifier = Modifier.height(spacing))
            OutlinedInputField(
                label = "",
                value = state.age.text,
                onChange = { onEvent(ManageProfileEvent.AgeChanged(it)) },
                error = state.age.error,
                labelColor = labelColor,
//                colors = textFieldColors,
                placeholder = { Text("Age") },

                )

            Spacer(modifier = Modifier.height(spacing))
            OutlinedInputField(
                label = "",
                value = state.gender.text,
                onChange = { onEvent(ManageProfileEvent.GenderChanged(it)) },
                error = state.gender.error,
                labelColor = labelColor,
//                colors = textFieldColors,
                placeholder = { Text("Gender") },

                )

            Spacer(modifier = Modifier.height(spacing))
            OutlinedInputField(
                label = "",
                value = state.email.text,
                onChange = { onEvent(ManageProfileEvent.EmailChanged(it)) },
                error = state.email.error,
                labelColor = labelColor,
//                colors = textFieldColors,
                placeholder = { Text("Email") },

                )

            Spacer(modifier = Modifier.height(spacing))
            OutlinedInputField(
                label = "",
                value = state.phone.text,
                onChange = { onEvent(ManageProfileEvent.PhoneChanged(it)) },
                error = state.phone.error,
                labelColor = labelColor,
//                colors = textFieldColors,
                placeholder = { Text("Phone") },

                )

            Spacer(modifier = Modifier.height(24.dp))

            PrimaryButton(
                label = "Save",
                onClick = { /* handle save */ }
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ManageProfileScreenPreview() {
    QTechHealthTheme {
        ManageProfileScreenContent(
            state = ManageProfileState(),
            onEvent = {}
        )
    }
}
