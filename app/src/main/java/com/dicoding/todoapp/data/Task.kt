package com.dicoding.todoapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//TODO 1 : Define a local database table using the schema in app/schema/tasks.json

@Entity(tableName = "tasks")
data class Task(

    @field:ColumnInfo(name = "id")
    @field:PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @field:ColumnInfo(name = "title")
    val title: String,

    @field:ColumnInfo(name = "description")
    val description: String,

    @field:ColumnInfo(name = "dueDate")
    val dueDateMillis: Long,

    @field:ColumnInfo(name = "completed")
    val isCompleted: Boolean = false
)
