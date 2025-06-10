package com.mustafa.weatherapp.domain.usecase

import com.mustafa.weatherapp.domain.entity.Weather
import com.mustafa.weatherapp.domain.repository.WeatherRepository

class GetWeatherUseCase(private val repository: WeatherRepository) {
    suspend operator fun invoke(): Weather = repository.getWeather()

}