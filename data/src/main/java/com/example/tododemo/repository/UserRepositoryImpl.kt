package com.example.tododemo.repository

import com.example.tododemo.common.resource.Resource
import com.example.tododemo.firebaseServices.FirebaseServices
import com.example.tododemo.mapper.UserMapper
import com.example.tododemo.model.UserModel
import com.example.tododemo.models.UserData
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(val firebaseServices: FirebaseServices,val userMapper: UserMapper): UserRepository {
    override suspend fun getUser(userId: String): Resource<UserModel>? {
        return try {
            firebaseServices.getUser(userId)?.let {
                Resource.Data(userMapper.toUserModel(it))
            }
        } catch (e: Throwable) {
            Resource.Error(e)
        }
    }

    override suspend fun editUser(userModel: UserData): Resource<UserModel>? {
        return try {
            firebaseServices.editUser(userModel)?.let {
                Resource.Data(userMapper.toUserModel(it))
            }
        } catch (e: Throwable) {
            Resource.Error(e)
        }
    }
}