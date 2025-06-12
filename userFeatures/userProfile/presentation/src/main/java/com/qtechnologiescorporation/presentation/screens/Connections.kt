package com.qtechnologiescorporation.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.qtechnologiescorporation.designsystem.QTechHealthTheme
import com.qtechnologiescorporation.presentation.components.ConnectionRow
import com.qtechnologiescorporation.presentation.viewmodels.ConnectionItem
import com.qtechnologiescorporation.presentation.viewmodels.ConnectionsEvent
import com.qtechnologiescorporation.presentation.viewmodels.ConnectionsState
import com.qtechnologiescorporation.presentation.viewmodels.ConnectionsViewModel
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.getValue

@Composable
fun ConnectionsScreen(
    viewModel: ConnectionsViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    ConnectionsScreenContent(
        state = state,
        onRemove = { id -> viewModel.onEvent(ConnectionsEvent.RemoveConnection(id)) },
        onAdd = { viewModel.onEvent(ConnectionsEvent.AddConnection) },
        onBackClick = { /* Handle back nav */ }
    )
}

@Composable
fun ConnectionsScreenContent(
    state: ConnectionsState,
    onRemove: (String) -> Unit,
    onAdd: () -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "Back",
                        modifier = Modifier.clickable { onBackClick() }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text("Connections", style = MaterialTheme.typography.headlineSmall)
                        Text("${state.connections.size} People", style = MaterialTheme.typography.labelMedium)
                    }
                }
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    modifier = Modifier.clickable { onAdd() }
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            items(state.connections, key = { it.id }) { connection ->
                Spacer(Modifier.height(5.dp))
                ConnectionRow(
                    name = connection.name,
                    onRemoveClick = { onRemove(connection.id) }
                )
                HorizontalDivider(
                    thickness = 0.5.dp,
                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConnectionsScreenPreview() {
    QTechHealthTheme {
        ConnectionsScreenContent(
            state = ConnectionsState(
                connections = listOf(
                    ConnectionItem(id = "1", name = "Dr. Grace Lin"),
                    ConnectionItem(id = "2", name = "Dr. Smith")
                )
            ),
            onRemove = {},
            onAdd = {},
            onBackClick = {}
        )
    }
}
