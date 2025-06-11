package com.mustafa.weatherapp.domain.repository

import com.mustafa.weatherapp.domain.entity.Weather

fun interface WeatherRepository {
    suspend fun getWeather(): Weather
}