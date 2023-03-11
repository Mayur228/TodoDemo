package com.example.tododemo.repository

import com.example.tododemo.common.resource.Resource
import com.example.tododemo.model.TaskModel
import com.example.tododemo.models.TaskData
import java.util.*

interface TaskRepository {
    suspend fun getTaskById(taskId: String) : Resource<TaskModel>?
    suspend fun getTaskByDate(selectedDate: Date) : Resource<List<TaskModel>>?
    suspend fun editTask(taskData: TaskData): Resource<TaskModel>?
    suspend fun deleteTask(taskId: String): Resource<String>?
}