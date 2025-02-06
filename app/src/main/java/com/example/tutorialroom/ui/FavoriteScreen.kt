package com.example.roomdb.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomdb.data.FavoriteEntity

@Composable
fun FavoriteScreen(viewModel: FavoriteViewModel = viewModel()) {
    val favorites by viewModel.allFavorites.collectAsState(initial = emptyList())
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {
            if (name.isNotEmpty() && description.isNotEmpty()) {
                viewModel.addFavorite(name, description)
                name = ""
                description = ""
            }
        }) {
            Text("Add to Favorite")
        }

        LazyColumn {
            items(favorites) { favorite ->
                Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = favorite.name, style = MaterialTheme.typography.titleLarge)
                        Text(text = favorite.description, style = MaterialTheme.typography.bodyMedium)
                        Button(onClick = { viewModel.deleteFavorite(favorite) }) {
                            Text("Delete")
                        }
                    }
                }
            }
        }
    }
}
