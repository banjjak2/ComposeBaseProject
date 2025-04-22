package com.sample.composebaseproject.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.composebaseproject.domain.usecase.GetRandomDogImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRandomDogImageUseCase: GetRandomDogImageUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<DogImageUiState>(DogImageUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        updateDogImage()
    }

    fun updateDogImage() {
        getRandomDogImageUseCase()
            .onEach { imageUrl ->
                _uiState.value = if (imageUrl.isEmpty()) {
                    DogImageUiState.Empty
                } else {
                    DogImageUiState.Success(imageUrl)
                }
            }
            .catch { e ->
                Log.e("MainViewModel", "이미지 업데이트 실패", e)
                _uiState.value = DogImageUiState.Failure
            }
            .launchIn(viewModelScope)
    }
}

sealed interface DogImageUiState {
    data object Loading : DogImageUiState
    data object Failure : DogImageUiState
    data object Empty : DogImageUiState
    data class Success(val imageUrl: String) : DogImageUiState
}