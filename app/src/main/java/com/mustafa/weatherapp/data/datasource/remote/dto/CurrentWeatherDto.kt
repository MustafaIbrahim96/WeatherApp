package com.mustafa.weatherapp.data.datasource.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherDto(
    @SerialName("time")
    val time: String,
    @SerialName("interval")
    val interval: Int,
    @SerialName("weather_code")
    val weatherCode: Int,
    @SerialName("relative_humidity_2m")
    val relativeHumidity2m: Int,
    @SerialName("wind_speed_10m")
    val windspeed10m: Double,
    @SerialName("precipitation_probability")
    val precipitationProbability: Int,
    @SerialName("surface_pressure")
    val surfacepressure: Double,
    @SerialName("apparent_temperature")
    val apparentTemperature: Double,
    @SerialName("temperature_2m")
    val temperature2m: Double,
    @SerialName("is_day")
    val isDay: Int,

    )
