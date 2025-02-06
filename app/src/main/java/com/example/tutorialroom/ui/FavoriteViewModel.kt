package com.example.roomdb.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdb.data.FavoriteDatabase
import com.example.roomdb.data.FavoriteEntity
import com.example.roomdb.data.FavoriteRepository
import kotlinx.coroutines.launch

class FavoriteViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: FavoriteRepository

    val allFavorites: kotlinx.coroutines.flow.Flow<List<FavoriteEntity>>

    init {
        val favoriteDao = FavoriteDatabase.getDatabase(application).favoriteDao()
        repository = FavoriteRepository(favoriteDao)
        allFavorites = repository.allFavorites
    }

    fun addFavorite(name: String, description: String) = viewModelScope.launch {
        repository.addFavorite(FavoriteEntity(name = name, description = description))
    }

    fun deleteFavorite(favorite: FavoriteEntity) = viewModelScope.launch {
        repository.deleteFavorite(favorite)
    }
}
