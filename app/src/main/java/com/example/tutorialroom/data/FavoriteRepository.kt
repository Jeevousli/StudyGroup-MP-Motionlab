package com.example.roomdb.data

import kotlinx.coroutines.flow.Flow

class FavoriteRepository(private val favoriteDao: FavoriteDao) {

    val allFavorites: Flow<List<FavoriteEntity>> = favoriteDao.getAllFavorites()

    suspend fun addFavorite(favorite: FavoriteEntity) {
        favoriteDao.addFavorite(favorite)
    }

    suspend fun deleteFavorite(favorite: FavoriteEntity) {
        favoriteDao.deleteFavorite(favorite)
    }
}
