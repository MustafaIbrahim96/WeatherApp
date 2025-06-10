package com.mustafa.weatherapp.domain.entity

import org.example.domain.model.entity.weather.WeatherCondition


data class Weather(
    val timeZone: String,
    val currentWeather: CurrentWeather,
    val currentWeatherUnit: CurrentWeatherUnit,
    val hourlyWeatherUnit: HourlyWeatherUnit,
    val hourlyWeather: HourlyWeather,
    val dailyWeatherUnit: DailyWeatherUnit,
    val dailyWeather: DailyWeather,

    )

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

data class HourlyWeatherUnit(
    val time: String,
    val temperature2m: String,
    val weatherCode: String
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
    val weatherCode: String,
    val uvIndexMax:String
)


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

