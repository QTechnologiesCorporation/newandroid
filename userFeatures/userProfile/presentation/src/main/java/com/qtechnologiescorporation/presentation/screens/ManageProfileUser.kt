package com.qtechnologiescorporation.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.presentation.components.ProfileNavigationItem
import com.qtechnologiescorporation.presentation.viewmodels.ProfileNavigationEvent
import com.qtechnologiescorporation.presentation.viewmodels.ProfileViewModel
import org.koin.androidx.compose.koinViewModel
import com.qtechnologiescorporation.designsystem.R

@Composable
fun ManageProfileUserScreen(
    viewModel: ProfileViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ProfileScreenContent(
        userName = uiState.userName,
        userId = uiState.userId,
        isChatEnabled = uiState.isChatEnabled,
        onToggleChat = viewModel::toggleChat,
        onNavigationClick = viewModel::onNavigationClick
    )
}

@Composable
fun ProfileScreenContent(
    userName: String,
    userId: String,
    isChatEnabled: Boolean,
    onToggleChat: (Boolean) -> Unit,
    onNavigationClick: (ProfileNavigationEvent) -> Unit
) {

    val profileIcon = painterResource(id =  R.drawable.ic_profile)
    val connectionsIcon = painterResource(id = R.drawable.ic_connection)
    val subscriptionIcon = painterResource(id = R.drawable.ic_subscription)
    val activityIcon = painterResource(id = R.drawable.ic_youractivity )
    val blockIcon = painterResource(id = R.drawable.ic_blockedaccount)
    val accessibilityIcon = painterResource(id = R.drawable.ic_accessibility)
    val settingIcon = painterResource(id = R.drawable.ic_setting  )
    val accountStatusIcon = painterResource(id = R.drawable.account_status  )
    val qrIcon = painterResource(id = R.drawable.ic_qr  )
    val chatIcon = painterResource(id = R.drawable.chat  )
    val supportIcon = painterResource(id = R.drawable.ic_support  )
    val aboutIcon = painterResource(id = R.drawable.ic_about )
    val termsIcon = painterResource(id = R.drawable.ic_terms )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Handle back navigation */ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.size(22.dp)
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                ) {
                    Text(
                        text = "Hey, $userName",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "User ID: $userId",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                Surface(
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .size(48.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.zee),
                        contentDescription = "Profile",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }


//            HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outline)
        }

        fun navItem(
            title: String,
            subtitle: String = "",
            painter: Painter?,
            event: ProfileNavigationEvent,
            endContent: (@Composable () -> Unit)? = null
        ) {
            item {
                ProfileNavigationItem(
                    title = title,
                    subtitle = subtitle,
                    painter = painter,
                    onClick = { onNavigationClick(event) },
                    endContent = endContent
                )
                HorizontalDivider(
                    thickness = 0.6.dp,
                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
                )
            }
        }

        navItem("Manage Profile", "View and edit your personal details, update your profile picture.", profileIcon, ProfileNavigationEvent.ManageProfile)
        navItem("Connections", "View, manage, and remove connections as per your preference.", connectionsIcon, ProfileNavigationEvent.Connections)
        navItem("Subscription", " Review your plan details and manage your subscription preferences.", subscriptionIcon, ProfileNavigationEvent.Subscription)
        navItem("Your Activity", "Track your recent actions and interactions within the app.", activityIcon, ProfileNavigationEvent.Activity)
        navItem("Blocked Account", "Manage your blocked users list and document access settings.", blockIcon, ProfileNavigationEvent.BlockedAccounts)
        navItem("Accessibility", "Customize your app experience to suit your accessibility needs.",accessibilityIcon, ProfileNavigationEvent.Accessibility)
        navItem("Settings", "Adjust app preferences, notifications, and account configurations.", settingIcon, ProfileNavigationEvent.Settings)

        navItem(
            title = "Account Status",
            subtitle = "",
              accountStatusIcon,
            event = ProfileNavigationEvent.AccountStatus,
            endContent = {
                Text("Verified", color = MaterialTheme.colorScheme.primary, fontSize = 12.sp)
            }
        )

        navItem("QR Scan", "", qrIcon, ProfileNavigationEvent.QrScan)

        navItem(
            title = "Chat",
            subtitle = "",
            chatIcon,
            event = ProfileNavigationEvent.Chat,
            endContent = {
                Switch(checked = isChatEnabled, onCheckedChange = onToggleChat)
            }
        )

        navItem("Support & Help", "Find answers to FAQs or contact support for assistance.",supportIcon, ProfileNavigationEvent.Support)
        navItem("About Us", "Learn more about our mission, team, and how we protect your data.",  aboutIcon, ProfileNavigationEvent.About)

        item {
            ProfileNavigationItem(
                title = "T&C and Privacy Policy",
                subtitle = "Understand your rights, our data policies, and legal terms.",
                termsIcon,
                onClick = { onNavigationClick(ProfileNavigationEvent.Terms) }
            )
        }

        item {
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),

            ) {
                OutlinedButton(
                    onClick = { onNavigationClick(ProfileNavigationEvent.Logout) },
                modifier = Modifier.weight(1f).padding(5.dp)
                ) {
                    Icon(Icons.Default.Output, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text("Logout")
                }
                Button(onClick = { onNavigationClick(ProfileNavigationEvent.AddAccount) },modifier = Modifier.weight(1f).padding(5.dp)) {
                    Icon(painterResource(R.drawable.addaccount), contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text("Add Account")
                }

            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@PreviewLightDark
@Composable
fun ManageProfileUserPreview() {
    QTechHealthTheme {
        ProfileScreenContent(
            userName = "John Doe",
            userId = "123456",
            isChatEnabled = true,
            onToggleChat = {},
            onNavigationClick = {}
        )
    }
}
