package com.example.myapplication.data.storage.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.storage.models.MovieStorageModel

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table")
    suspend fun getFavoriteMoviesList() : List<MovieStorageModel>

    @Query("SELECT * FROM movie_table WHERE id=:movieId LIMIT 1")
    suspend fun getFavoriteMovie(movieId : Int) : MovieStorageModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItem(movieStorageModel: MovieStorageModel)

    @Query("DELETE FROM movie_table WHERE id=:movieId")
    suspend fun removeItem(movieId : Int)
}