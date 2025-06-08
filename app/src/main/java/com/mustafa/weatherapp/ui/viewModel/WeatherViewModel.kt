package com.mustafa.weatherapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafa.weatherapp.domain.entity.Weather
import com.mustafa.weatherapp.domain.repository.WeatherRepository
import com.mustafa.weatherapp.domain.usecase.GetWeatherUseCase
import com.mustafa.weatherapp.ui.viewModel.state.WeatherUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(private val getWeatherUseCase: GetWeatherUseCase) : ViewModel() {

    private val _state = MutableStateFlow<WeatherUiState?>(null)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val result = getWeatherUseCase()
            _state.value = result.toUiState()
        }
    }

}

fun Weather.toUiState(): WeatherUiState {
    return WeatherUiState(
        weather = this
    )
}