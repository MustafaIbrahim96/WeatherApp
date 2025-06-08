package com.mustafa.weatherapp.data.datasource.remote.dto

import android.icu.util.TimeZone
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponseDto(

    @SerialName("timezone")
    val timeZone: String,
    @SerialName("current_weather")
    val currentWeatherDto: CurrentWeatherDto
)

@Serializable
data class CurrentWeatherDto(

    @SerialName("time")
    val time : String,
    @SerialName("interval")
    val interval : Int,
    @SerialName("temperature")
    val temperature : Double,
    @SerialName("windspeed")
    val windspeed : Double,
    @SerialName("winddirection")
    val winddirection : Int,
    @SerialName("is_day")
    val is_day : Int,
    @SerialName("weathercode")
    val weathercode : Int,

)