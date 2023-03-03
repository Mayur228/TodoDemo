package com.example.tododemo.feature.intro.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IntroViewModel @Inject constructor() : ViewModel() {

    private val redirectToHomeEvent = Channel<Unit>()
    val redirectToHome = redirectToHomeEvent.receiveAsFlow()

    fun redirectToHome() {
        viewModelScope.launch {
            redirectToHomeEvent.send(Unit)
        }
    }
}