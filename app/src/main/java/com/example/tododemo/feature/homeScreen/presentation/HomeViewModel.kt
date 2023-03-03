package com.example.tododemo.feature.homeScreen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tododemo.usecase.TaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val taskUseCase: TaskUseCase): ViewModel() {

    private val redirectToHomeChannel = Channel<Unit>()
    val redirectToHomeEvent = redirectToHomeChannel.receiveAsFlow()

    private val redirectToSearchChannel = Channel<Unit>()
    val redirectToSearchEvent = redirectToSearchChannel.receiveAsFlow()

    private val redirectToNotificationChannel = Channel<Unit>()
    val redirectToNotificationEvent = redirectToNotificationChannel.receiveAsFlow()

    private val redirectToSettingChannel = Channel<Unit>()
    val redirectToSettingEvent = redirectToSettingChannel.receiveAsFlow()

    private val openAddToDoChannel = Channel<Unit>()
    val openAddToDoEvent = openAddToDoChannel.receiveAsFlow()

    private val openProfileChannel = Channel<Unit>()
    val openProfileEvent = openProfileChannel.receiveAsFlow()


    fun redirectToHome() {
        viewModelScope.launch {
            redirectToHomeChannel.send(Unit)
        }
    }

    fun redirectToSearch() {
        viewModelScope.launch {
            redirectToSearchChannel.send(Unit)
        }
    }

    fun redirectToNotification() {
        viewModelScope.launch {
            redirectToNotificationChannel.send(Unit)
        }
    }

    fun redirectToSetting() {
        viewModelScope.launch {
            redirectToSettingChannel.send(Unit)
        }
    }

    fun openToDo() {
        viewModelScope.launch {
            openAddToDoChannel.send(Unit)
        }
    }

    fun openProfile() {
        viewModelScope.launch {
            openProfileChannel.send(Unit)
        }
    }

}