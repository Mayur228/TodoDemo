package com.example.tododemo.mapper

import com.example.tododemo.model.UserModel
import com.example.tododemo.models.UserData
import javax.inject.Inject

class UserMapper @Inject constructor() {
    fun toUserModel(userData: UserData): UserModel {
        return UserModel(
            userId = userData.userId,
            userName = userData.userName,
            userProfile = userData.userProfile,
            profession = userData.profession,
            description = userData.description,
            gender = userData.gender
        )
    }
}