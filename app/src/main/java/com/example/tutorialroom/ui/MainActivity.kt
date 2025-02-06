package com.example.tutorialroom.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomdb.ui.theme.RoomDBTheme


// Data class untuk Task
data class Task(val id: Int, val title: String, val description: String, var isFavorite: Boolean = false)

// ViewModel untuk menyimpan daftar tugas & favorite
class TaskViewModel : ViewModel() {
    var tasks = mutableStateListOf(
        Task(1, "Belajar Android", "Mengerjakan project Android"),
        Task(2, "Workout", "Latihan di gym selama 1 jam"),
        Task(3, "Baca Buku", "Membaca buku pemrograman")
    )

    var favoriteTasks = mutableStateListOf<Task>()

    fun toggleFavorite(task: Task) {
        task.isFavorite = !task.isFavorite
        if (task.isFavorite) {
            favoriteTasks.add(task)
        } else {
            favoriteTasks.remove(task)
        }
    }

    fun removeFavorite(task: Task) {
        task.isFavorite = false
        favoriteTasks.remove(task)
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomDBTheme {
                AppNavigation()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(viewModel: TaskViewModel = viewModel()) {
    var showFavorites by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (showFavorites) "Daftar Favorite" else "To-Do List") },
                actions = {
                    IconButton(onClick = { showFavorites = !showFavorites }) {
                        Icon(Icons.Default.Favorite, contentDescription = "Lihat Favorite")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            if (showFavorites) {
                FavoriteScreen(viewModel)
            } else {
                TaskListScreen(viewModel)
            }
        }
    }
}

@Composable
fun TaskListScreen(viewModel: TaskViewModel) {
    LazyColumn {
        items(viewModel.tasks) { task ->
            TaskItem(task, onFavoriteClick = { viewModel.toggleFavorite(task) })
        }
    }
}

@Composable
fun FavoriteScreen(viewModel: TaskViewModel) {
    LazyColumn {
        items(viewModel.favoriteTasks) { task ->
            TaskItem(task, onFavoriteClick = { viewModel.removeFavorite(task) })
        }
    }
}

@Composable
fun TaskItem(task: Task, onFavoriteClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onFavoriteClick() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = task.title, style = MaterialTheme.typography.titleMedium)
                Text(text = task.description, style = MaterialTheme.typography.bodySmall)
            }
            IconButton(onClick = onFavoriteClick) {
                Icon(
                    imageVector = if (task.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Tambah ke Favorite"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
  RoomDBTheme   {
        AppNavigation()
    }
}
