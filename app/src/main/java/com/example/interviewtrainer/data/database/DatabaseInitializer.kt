package com.example.interviewtrainer.data.database

import com.example.interviewtrainer.data.database.entity.PlatformEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

object DatabaseInitializer {
    fun populateDatabase(database: AppDatabase) {
        CoroutineScope(Dispatchers.IO).launch {
            val platformDao = database.platformDao()
            val platforms = platformDao.getAllPlatforms().firstOrNull()

            if (platforms.isNullOrEmpty()) {
                val initalPlatforms = listOf(
                    PlatformEntity(name = "Android", isAvailable = true),
                    PlatformEntity(name = "iOS", isAvailable = false),
                    PlatformEntity(name = "Python ML", isAvailable = false),
                    PlatformEntity(name = "Frontend", isAvailable = false)
                )
                platformDao.insertAll(initalPlatforms)
            }
        }
    }
}