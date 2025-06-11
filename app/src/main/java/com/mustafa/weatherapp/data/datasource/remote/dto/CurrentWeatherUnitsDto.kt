package com.mustafa.weatherapp.data.datasource.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherUnitsDto(
    @SerialName("time")
    val time: String,
    @SerialName("interval")
    val interval: String,
    @SerialName("weather_code")
    val weatherCode: String,
    @SerialName("relative_humidity_2m")
    val relativeHumidity2m: String,
    @SerialName("wind_speed_10m")
    val windspeed10m: String,
    @SerialName("precipitation_probability")
    val precipitationProbability: String,
    @SerialName("surface_pressure")
    val surfacepressure: String,
    @SerialName("apparent_temperature")
    val apparentTemperature: String,
    @SerialName("temperature_2m")
    val temperature2m: String,
    @SerialName("is_day")
    val isDay: String,

    )
