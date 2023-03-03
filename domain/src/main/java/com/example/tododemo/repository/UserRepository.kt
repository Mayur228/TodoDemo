package com.example.tododemo.repository

import com.example.tododemo.common.resource.Resource
import com.example.tododemo.model.UserModel
import com.example.tododemo.models.UserData

interface UserRepository {
    suspend fun getUser(userId: String) : Resource<UserModel>?
    suspend fun editUser(userModel: UserData) : Resource<UserModel>?
}