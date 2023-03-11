package com.example.tododemo.firebaseServices

import com.example.tododemo.common.resource.Resource
import com.example.tododemo.models.TaskData
import com.example.tododemo.models.UserData
import java.util.*

interface FirebaseServices {
    suspend fun getUser(userId: String): UserData? {
        return null
    }

    suspend fun editUser(userData: UserData): UserData? {
        return null
    }

    suspend fun getTaskById(taskId: String): TaskData? {
        return null
    }

    suspend fun getTaskByDate(taskData: Date): List<TaskData>? {
        return null
    }

    suspend fun addTask(taskData: TaskData): TaskData? {
        return null
    }

    suspend fun editTask(taskData: TaskData): TaskData? {
        return null
    }

    suspend fun deleteTask(taskId: String): String {
        return "task is deleted"
    }
}