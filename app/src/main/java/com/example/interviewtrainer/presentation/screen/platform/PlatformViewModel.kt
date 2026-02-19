package com.example.interviewtrainer.presentation.screen.platform

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interviewtrainer.data.repository.PlatformRepository
import com.example.interviewtrainer.domain.model.Platform
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class PlatformViewModel(
    private val repository: PlatformRepository //Принцип единственной ответсвенности
): ViewModel(){
    private val _stateFlow = MutableStateFlow(PlatformState())
    val stateFlow: StateFlow<PlatformState> = _stateFlow
    /* В init { ... } запустить корутину, которая будет слушать repository.getAllPlatforms()
    Преобразовывать PlatformEntity в Platform (сейчас просто совпадают поля)
    Обновлять _state с результатом */
    init{
        viewModelScope.launch {
            _stateFlow.value = PlatformState(isLoading = true)
            repository.getAllPlatforms()
                .map { entities ->
                    entities.map { entity ->
                        Platform(
                            id = entity.id,
                            name = entity.name,
                            isAvailable = entity.isAvailable
                        )
                    }
                }
                .collect { platforms ->
                    _stateFlow.value = PlatformState(
                        platforms = platforms,
                        isLoading = false,
                        error = null
                    )
                }
        }
    }
}

data class PlatformState(
    val platforms: List<Platform> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

