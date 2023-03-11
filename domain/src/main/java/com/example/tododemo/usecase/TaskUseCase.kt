package com.example.tododemo.usecase

import com.example.tododemo.common.resource.Resource
import com.example.tododemo.model.TaskModel
import com.example.tododemo.models.TaskData
import com.example.tododemo.repository.TaskRepository
import java.util.*
import javax.inject.Inject

class TaskUseCase @Inject constructor(private val repository: TaskRepository) {

    suspend fun getTaskByDate(selectedDate: Date) : Resource<List<TaskModel>>? {
        return repository.getTaskByDate(selectedDate)
    }

    suspend fun getTaskById(taskId: String) : Resource<TaskModel>?{
        return repository.getTaskById(taskId)
    }

    suspend fun editTask(taskModel: TaskData) : Resource<TaskModel>? {
        return repository.editTask(taskModel)
    }

    suspend fun deleteTask(taskId: String) : Resource<String>? {
        return repository.deleteTask(taskId)
    }

}