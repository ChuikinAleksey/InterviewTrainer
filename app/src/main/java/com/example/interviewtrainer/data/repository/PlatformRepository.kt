package com.example.interviewtrainer.data.repository

import com.example.interviewtrainer.data.database.dao.PlatformDao
import com.example.interviewtrainer.data.database.entity.PlatformEntity
import kotlinx.coroutines.flow.Flow

class PlatformRepository (
    private val platformDao: PlatformDao) {
    fun getAllPlatforms(): Flow<List<PlatformEntity>> = platformDao.getAllPlatforms()
    fun getAvailablePlatforms(): Flow<List<PlatformEntity>> = platformDao.getAvailablePlatforms()
    suspend fun insertPlatforms(platforms: List<PlatformEntity>){
        platformDao.insertAll(platforms)
    }
    suspend fun deleteAllPlatforms(){
        platformDao.deleteAll()
    }
}