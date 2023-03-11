package com.example.tododemo.models

import java.util.*

data class TaskData(
    val taskId: String,
    val userId: String,
    val taskName: String,
    val description: String,
    val selectedDate: Date,
    val selectedTime: Date,
    val selectedCategory: String,
    val isAlert: Boolean
)
