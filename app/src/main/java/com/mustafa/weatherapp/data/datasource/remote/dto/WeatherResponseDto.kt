package com.mustafa.weatherapp.data.datasource.remote.dto

import android.icu.util.TimeZone
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
    @SerialName("current_weather_units")
    val currentWeatherUnitsDto: CurrentWeatherUnitsDto,
    @SerialName("current_weather")
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

@Serializable
data class CurrentWeatherUnitsDto(
    @SerialName("time")
    val time: String,
    @SerialName("interval")
    val interval: String,
    @SerialName("temperature")
    val temperature: String,
    @SerialName("windspeed")
    val windspeed: String,
    @SerialName("winddirection")
    val winddirection: String,
    @SerialName("is_day")
    val isDay: String,
    @SerialName("weathercode")
    val weathercode: String
)

@Serializable
data class DailyUnitsDto(
    @SerialName("time")
    val time: String,
    @SerialName("temperature_2m_max")
    val temperature2mMax: String,
    @SerialName("temperature_2m_min")
    val temperature2mMin: String,
    @SerialName("weathercode")
    val weathercode: String
)

@Serializable
data class DailyDto(
    @SerialName("time")
    val time: List<String>,
    @SerialName("temperature_2m_max")
    val temperature2mMax: List<Double>,
    @SerialName("temperature_2m_min")
    val temperature2mMin: List<Double>,
    @SerialName("weathercode")
    val weathercode: List<Int>
)

@Serializable
data class HourlyUnitsDto(
    @SerialName("time")
    val time: String,
    @SerialName("temperature_2m")
    val temperature2m: String,
    @SerialName("weathercode")
    val weathercode: String
)


@Serializable
data class HourlyDto(
    @SerialName("time")
    val time: List<String>,
    @SerialName("temperature_2m")
    val temperature2m: List<Double>,
    @SerialName("weathercode")
    val weathercode: List<Int>
)