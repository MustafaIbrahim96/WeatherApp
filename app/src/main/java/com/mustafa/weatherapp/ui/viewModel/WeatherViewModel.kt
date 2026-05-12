package com.mustafa.weatherapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafa.weatherapp.domain.entity.Weather
import com.mustafa.weatherapp.domain.usecase.GetCityLocationUseCase
import com.mustafa.weatherapp.domain.usecase.GetWeatherUseCase
import com.mustafa.weatherapp.ui.viewModel.state.WeatherScreenUiState
import com.mustafa.weatherapp.ui.viewModel.state.WeatherUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val getCityLocationUseCase: GetCityLocationUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<WeatherScreenUiState>(WeatherScreenUiState.Loading)
    val state = _state.asStateFlow()

    fun loadWeather() {
        viewModelScope.launch {
            _state.value = WeatherScreenUiState.Loading

            val cityName = try {
                getCityLocationUseCase().cityName
            } catch (_: Exception) {
                ""
            }

            try {
                val resultWeather = getWeatherUseCase().copy(timeZone = cityName)
                _state.value = WeatherScreenUiState.Success(resultWeather.toUiState())
            } catch (e: Exception) {
                val msg = e.message?.takeIf { it.isNotBlank() }
                    ?: "Could not load weather. Enable location (or set a mock location on the emulator) and try again."
                _state.value = WeatherScreenUiState.Error(msg)
            }
        }
    }

    fun onLocationPermissionDenied() {
        _state.value = WeatherScreenUiState.Error(
            "Location permission is required to show weather for your area."
        )
    }

}

fun Weather.toUiState(): WeatherUiState {
    return WeatherUiState(
        weather = this.copy(currentWeather = this.currentWeather.copy())
    )
}