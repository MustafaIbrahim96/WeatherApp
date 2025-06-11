package com.mustafa.weatherapp.data.datasource.remote.api

import com.mustafa.weatherapp.data.datasource.remote.dto.WeatherResponseDto

fun interface WeatherApi {
    suspend fun getWeather(latitude:Double,longitude:Double) : WeatherResponseDto
}