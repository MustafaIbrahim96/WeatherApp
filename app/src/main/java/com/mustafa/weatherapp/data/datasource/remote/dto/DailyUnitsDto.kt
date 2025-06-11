package com.mustafa.weatherapp.data.datasource.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyUnitsDto(
    @SerialName("time")
    val time: String,
    @SerialName("temperature_2m_max")
    val temperature2mMax: String,
    @SerialName("temperature_2m_min")
    val temperature2mMin: String,
    @SerialName("weathercode")
    val weathercode: String,
    @SerialName("uv_index_max")
    val uvIndexMax: String
)