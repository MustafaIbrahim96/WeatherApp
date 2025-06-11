package com.mustafa.weatherapp.data.datasource.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponseDto(

    @SerialName("latitude")
    val latitude: Double,
    @SerialName("longitude")
    val longitude: Double,
    @SerialName("generationtime_ms")
    val generationTimeMs: Double,
    @SerialName("utc_offset_seconds")
    val utcOffsetSeconds: Int,
    @SerialName("timezone")
    val timeZone: String,
    @SerialName("timezone_abbreviation")
    val timezoneAbbreviation: String,
    @SerialName("elevation")
    val elevation: Double,
    @SerialName("current_units")
    val currentWeatherUnitsDto: CurrentWeatherUnitsDto,
    @SerialName("current")
    val currentWeatherDto: CurrentWeatherDto,
    @SerialName("daily_units")
    val dailyUnitsDto: DailyUnitsDto,
    @SerialName("daily")
    val dailyDto: DailyDto,
    @SerialName("hourly")
    val hourlyDto: HourlyDto,
    @SerialName("hourly_units")
    val hourlyUnitsDto: HourlyUnitsDto
)
