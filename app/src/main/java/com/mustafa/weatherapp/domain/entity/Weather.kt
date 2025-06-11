package com.mustafa.weatherapp.domain.entity



data class Weather(
    val timeZone: String,
    val currentWeather: CurrentWeather,
    val currentWeatherUnit: CurrentWeatherUnit,
    val hourlyWeatherUnit: HourlyWeatherUnit,
    val hourlyWeather: HourlyWeather,
    val dailyWeatherUnit: DailyWeatherUnit,
    val dailyWeather: DailyWeather,

    )



