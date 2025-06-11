package com.mustafa.weatherapp.domain.entity


data class CurrentWeather(

    val time: String,
    val interval: Int,
    val weatherCode: WeatherCondition,
    val relativeHumidity2m: Int,
    val windSpeed10m: Double,
    val precipitationProbability: Int,
    val surfacePressure: Double,
    val apparentTemperature: Double,
    val temperature2m: Double,
    val isDay: Boolean,

    )
