package com.mustafa.weatherapp.domain.entity

data class CurrentWeatherUnit(
    val time: String,
    val interval: String,
    val weatherCode: String,
    val relativeHumidity2m: String,
    val windSpeed10m: String,
    val precipitationProbability: String,
    val surfacePressure: String,
    val apparentTemperature: String,
    val temperature2m: String,
    val isDay: String,
)