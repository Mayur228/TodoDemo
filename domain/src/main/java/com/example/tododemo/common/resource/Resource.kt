package com.example.tododemo.common.resource

sealed class Resource<out T> {
    data class Data<T>(val value: T) : Resource<T>()
    data class Error(val throwable: Throwable) : Resource<Nothing>()
    object Pending : Resource<Nothing>()
}