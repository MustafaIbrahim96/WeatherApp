package com.mustafa.weatherapp.data.datasource.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyDto(
    @SerialName("time")
    val time: List<String>,
    @SerialName("temperature_2m")
    val temperature2m: List<Double>,
    @SerialName("weathercode")
    val weathercode: List<Int>
)
