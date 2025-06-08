package com.mustafa.weatherapp.domain.entity

import org.example.domain.model.entity.weather.WeatherCondition


data class Weather(
    val timeZone: String,
    val currentWeather: CurrentWeather
)

data class CurrentWeather(

    val time: String,
    val interval: Int,
    val temperature: Double,
    val windspeed: Double,
    val winddirection: Int,
    val is_day: Boolean,
    val weathercode: WeatherCondition

)