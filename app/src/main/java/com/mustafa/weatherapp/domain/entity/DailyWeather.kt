package com.mustafa.weatherapp.domain.entity


data class DailyWeather(
    val days: List<DailyWeatherData>
)

data class DailyWeatherData(
    val date: String,
    val maxTemp: Double,
    val minTemp: Double,
    val weatherCode: WeatherCondition,
    val uvIndexMax:Double
)