package com.mustafa.weatherapp.data.datasource.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyUnitsDto(
    @SerialName("time")
    val time: String,
    @SerialName("temperature_2m")
    val temperature2m: String,
    @SerialName("weathercode")
    val weathercode: String
)