package com.example.interviewtrainer.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.interviewtrainer.data.database.entity.PlatformEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlatformDao{
    @Insert
    suspend fun insert(platform: PlatformEntity)

    @Insert
    suspend fun insertAll(platforms: List<PlatformEntity>)

    @Query("SELECT * FROM platforms ORDER BY id ASC")
    fun getAllPlatforms(): Flow<List<PlatformEntity>>

    @Query("SELECT * FROM platforms WHERE isAvailable = 1")
    fun getAvailablePlatforms(): Flow<List<PlatformEntity>>

    @Query("DELETE FROM platforms")
    suspend fun deleteAll()
}
