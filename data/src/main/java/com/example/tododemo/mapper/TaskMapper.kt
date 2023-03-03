package com.example.tododemo.mapper

import com.example.tododemo.model.TaskModel
import com.example.tododemo.models.TaskData
import javax.inject.Inject

class TaskMapper @Inject constructor() {

    fun toTaskModel(taskData: TaskData): TaskModel {
        return TaskModel(
            taskId = taskData.taskId,
            userId = taskData.userId,
            taskName = taskData.taskName,
            description = taskData.description,
            selectedDate = taskData.selectedDate,
            selectedTime = taskData.selectedTime,
            selectedCategory = taskData.selectedCategory,
            isAlert = taskData.isAlert
        )
    }

    fun toTaskModelList(taskList: List<TaskData>): List<TaskModel> {
        return taskList.map {taskData ->
            TaskModel(
                taskId = taskData.taskId,
                userId = taskData.userId,
                taskName = taskData.taskName,
                description = taskData.description,
                selectedDate = taskData.selectedDate,
                selectedTime = taskData.selectedTime,
                selectedCategory = taskData.selectedCategory,
                isAlert = taskData.isAlert
            )
        }

    }
}