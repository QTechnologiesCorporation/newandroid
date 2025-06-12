package com.qtechnologiescorporation.presentation.viewmodels


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.koin.android.annotation.KoinViewModel

data class ConnectionItem(val id: String, val name: String)

data class ConnectionsState(
    val connections: List<ConnectionItem> = emptyList()
)

sealed class ConnectionsEvent {
    data class RemoveConnection(val id: String) : ConnectionsEvent()
    object AddConnection : ConnectionsEvent()
}

@KoinViewModel
class ConnectionsViewModel : ViewModel() {
    private val _state = MutableStateFlow(
        ConnectionsState(
            connections = listOf(
                ConnectionItem("1", "Dr. Steven Adler"),
                ConnectionItem("2", "Dr. Thomas Ellison"),
                ConnectionItem("3", "Dr. Grace Lin"),
                ConnectionItem("4", "Dr. Caroline Sato"),
                ConnectionItem("5", "Dr. Nathan Wells"),
                ConnectionItem("6", "Dr. Isabelle Clarke"),
                ConnectionItem("7", "Dr. Ayaan Malik"),
                ConnectionItem("8", "Dr. Marcus Langford"),
                ConnectionItem("9", "Dr. Samuel Greene"),
                ConnectionItem("10", "Dr. Jordan McAllister"),
                ConnectionItem("11", "Dr. Smith")
            )
        )
    )
    val state: StateFlow<ConnectionsState> = _state

    fun onEvent(event: ConnectionsEvent) {
        when (event) {
            is ConnectionsEvent.RemoveConnection -> {
                _state.update {
                    it.copy(connections = it.connections.filterNot { conn -> conn.id == event.id })
                }
            }
            ConnectionsEvent.AddConnection -> {
                // Handle adding a new connection
            }
        }
    }
}
