package com.example.tododemo.feature.profile.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tododemo.feature.profile.vo.ViewVo
import com.example.tododemo.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(userUseCase: UserUseCase) : ViewModel() {
    val userData = MutableLiveData<ViewVo>()

    init {

    }
}