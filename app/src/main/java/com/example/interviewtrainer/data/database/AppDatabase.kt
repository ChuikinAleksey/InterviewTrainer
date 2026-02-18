package com.example.interviewtrainer.data.database

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.interviewtrainer.data.database.dao.PlatformDao
import com.example.interviewtrainer.data.database.entity.PlatformEntity

@Database(
    version = 1, // Версия бд
    entities = [PlatformEntity::class], // Сущности сохранения
    exportSchema = false // Отсутствие сохранения бд в отдельный файл
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun platformDao(): PlatformDao // Возвращает Dao-интерфейс

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "platform_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}
