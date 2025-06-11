package com.mustafa.weatherapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafa.weatherapp.domain.entity.Weather
import com.mustafa.weatherapp.domain.usecase.GetCityLocationUseCase
import com.mustafa.weatherapp.domain.usecase.GetWeatherUseCase
import com.mustafa.weatherapp.ui.viewModel.state.WeatherUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val getCityLocationUseCase: GetCityLocationUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<WeatherUiState?>(null)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val cityName = try {
                getCityLocationUseCase().cityName
            }catch (e:Exception){
                e.printStackTrace()
                ""
            }

            val resultWeather = getWeatherUseCase().copy(timeZone = cityName)
            _state.value = resultWeather.toUiState()
        }
    }

}

fun Weather.toUiState(): WeatherUiState {
    return WeatherUiState(
        weather = this.copy(currentWeather = this.currentWeather.copy())
    )
}