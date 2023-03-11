package com.example.tododemo.repository

import com.example.tododemo.common.resource.Resource
import com.example.tododemo.firebaseServices.FirebaseServices
import com.example.tododemo.mapper.TaskMapper
import com.example.tododemo.model.TaskModel
import com.example.tododemo.models.TaskData
import java.util.*
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    val firebaseServices: FirebaseServices,
    val taskMapper: TaskMapper
) : TaskRepository {
    override suspend fun getTaskById(taskId: String): Resource<TaskModel>? {
        return try {
            firebaseServices.getTaskById(taskId)?.let {
                Resource.Data(taskMapper.toTaskModel(it))
            }
        } catch (e: Throwable) {
            Resource.Error(e)
        }
    }

    override suspend fun getTaskByDate(selectedDate: Date): Resource<List<TaskModel>>? {
        return try {
            firebaseServices.getTaskByDate(selectedDate)?.let {
                Resource.Data(taskMapper.toTaskModelList(it))
            }
        } catch (e: Throwable) {
            Resource.Error(e)
        }
    }

    override suspend fun editTask(taskData: TaskData): Resource<TaskModel>? {
        return try {
            firebaseServices.editTask(taskData)?.let {
                Resource.Data(taskMapper.toTaskModel(it))
            }
        } catch (e: Throwable) {
            Resource.Error(e)
        }
    }

    override suspend fun deleteTask(taskId: String): Resource<String>? {
        return try {
            firebaseServices.deleteTask(taskId).let {
                Resource.Data(it)
            }
        } catch (e: Throwable) {
            Resource.Error(e)
        }
    }
}