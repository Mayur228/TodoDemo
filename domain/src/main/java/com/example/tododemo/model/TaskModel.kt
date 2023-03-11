package com.example.tododemo.model

import java.util.*

data class TaskModel(
    val taskId: String = "",
    val userId: String = "",
    val taskName: String = "",
    val description: String = "",
    val selectedDate: Date? = null,
    val selectedTime: Date? = null,
    val selectedCategory: String = "",
    val isAlert: Boolean = false
)
