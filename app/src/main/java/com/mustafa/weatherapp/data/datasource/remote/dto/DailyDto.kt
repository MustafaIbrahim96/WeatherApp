package com.mustafa.weatherapp.data.datasource.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyDto(
    @SerialName("time")
    val time: List<String>,
    @SerialName("temperature_2m_max")
    val temperature2mMax: List<Double>,
    @SerialName("temperature_2m_min")
    val temperature2mMin: List<Double>,
    @SerialName("weathercode")
    val weathercode: List<Int>,
    @SerialName("uv_index_max")
    val uvIndexMax: List<Double>
)