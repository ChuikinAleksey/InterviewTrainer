package com.example.interviewtrainer.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "platforms") // Название таблицы в базе данных
data class PlatformEntity(
    @PrimaryKey(autoGenerate = true) // Данное свойство "объясняет" библиотеке, что при вставке нового
    // объекта в таблицу, необходимо сгенерировать индекс самостоятельно.
    val id: Long = 0,
    val name: String,
    val isAvailable: Boolean
)