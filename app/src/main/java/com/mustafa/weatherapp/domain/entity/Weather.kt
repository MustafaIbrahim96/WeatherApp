package com.mustafa.weatherapp.domain.entity

import org.example.domain.model.entity.weather.WeatherCondition


data class Weather(
    val timeZone: String,
    val currentWeather: CurrentWeather,
    val currentWeatherUnit: CurrentWeatherUnit,
    val hourlyWeatherUnit: HourlyWeatherUnit,
    val hourlyWeather: HourlyWeather,
    val dailyWeatherUnit: DailyWeatherUnit,
    val DailyWeather: DailyWeather,

    )

data class CurrentWeather(
    val time: String,
    val interval: Int,
    val temperature: Double,
    val windspeed: Double,
    val winddirection: Int,
    val isDay: Boolean,
    val weathercode: WeatherCondition
)

data class CurrentWeatherUnit(
    val time: String,
    val interval: String,
    val temperature: String,
    val windspeed: String,
    val winddirection: String,
    val isDay: String,
    val weathercode: String
)

data class HourlyWeatherUnit(
    val time: String,
    val temperature2m: String,
    val weathercode: String
)

data class HourlyWeather(
    val hourly: List<HourlyWeatherData>
)

data class HourlyWeatherData(
    val date: String,
    val temp: Double,
    val weatherCode: WeatherCondition
)

data class DailyWeatherUnit(
    val time: String,
    val temperature2mMin: String,
    val temperature2mMax: String,
    val weathercode: String
)


data class DailyWeather(
    val days: List<DailyWeatherData>
)

data class DailyWeatherData(
    val date: String,
    val maxTemp: Double,
    val minTemp: Double,
    val weatherCode: WeatherCondition
)

