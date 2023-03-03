package com.example.tododemo.usecase

import com.example.tododemo.common.resource.Resource
import com.example.tododemo.model.UserModel
import com.example.tododemo.repository.UserRepository
import javax.inject.Inject

class UserUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend fun getUserData(userId: String): Resource<UserModel>? {
        return userRepository.getUser(userId)
    }

    suspend fun editUserData(userData: UserModel) : Resource<UserModel>? {
        return userRepository.editUser(userData)
    }

}