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