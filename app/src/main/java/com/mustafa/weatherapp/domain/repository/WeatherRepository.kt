package com.mustafa.weatherapp.domain.repository

import com.mustafa.weatherapp.domain.entity.Weather

interface WeatherRepository {
    suspend fun getWeather(): Weather
}