package com.mustafa.weatherapp.ui.viewModel.state

import com.mustafa.weatherapp.domain.entity.CurrentWeather
import com.mustafa.weatherapp.domain.entity.CurrentWeatherUnit
import com.mustafa.weatherapp.domain.entity.DailyWeather
import com.mustafa.weatherapp.domain.entity.DailyWeatherData
import com.mustafa.weatherapp.domain.entity.DailyWeatherUnit
import com.mustafa.weatherapp.domain.entity.HourlyWeather
import com.mustafa.weatherapp.domain.entity.HourlyWeatherData
import com.mustafa.weatherapp.domain.entity.HourlyWeatherUnit
import com.mustafa.weatherapp.domain.entity.Weather
import org.example.domain.model.entity.weather.WeatherCondition

object FakeWeatherData {

    val sampleCurrentWeather = CurrentWeather(
        time = "2023-10-15T14:30",
        interval = 0,
        weatherCode = WeatherCondition.PARTLY_CLOUDY,
        relativeHumidity2m = 65,
        windSpeed10m = 12.5,
        precipitationProbability = 10,
        surfacePressure = 1015.0,
        apparentTemperature = 24.0,
        temperature2m = 25.5,
        isDay = false
    )

    val sampleCurrentWeatherUnit = CurrentWeatherUnit(
        time = "ISO 8601",
        interval = "seconds",
        weatherCode = "WMO code",
        relativeHumidity2m = "%",
        windSpeed10m = "km/h",
        precipitationProbability = "%",
        surfacePressure = "hPa",
        apparentTemperature = "°C",
        temperature2m = "°C",
        isDay = "boolean"
    )

    val hourlyDataList = listOf(
        HourlyWeatherData("2023-10-15T15:00", 25.0, WeatherCondition.PARTLY_CLOUDY),
        HourlyWeatherData("2023-10-15T16:00", 24.5, WeatherCondition.PARTLY_CLOUDY),
        HourlyWeatherData("2023-10-15T17:00", 24.0, WeatherCondition.PARTLY_CLOUDY),
        HourlyWeatherData("2023-10-15T18:00", 23.0, WeatherCondition.MAINLY_CLEAR),
        HourlyWeatherData("2023-10-15T19:00", 22.0, WeatherCondition.CLEAR_SKY),
        HourlyWeatherData("2023-10-15T20:00", 21.5, WeatherCondition.CLEAR_SKY),
        HourlyWeatherData("2023-10-15T21:00", 21.0, WeatherCondition.RAIN_HEAVY),
        HourlyWeatherData("2023-10-15T22:00", 20.5, WeatherCondition.THUNDERSTORM_WITH_HAIL_HEAVY)
    )

    val sampleHourlyWeather = HourlyWeather(hourly = hourlyDataList)

    val sampleHourlyWeatherUnit = HourlyWeatherUnit(
        time = "ISO 8601",
        temperature2m = "°C",
        weatherCode = "WMO code"
    )

    val dailyDataList = listOf(
        DailyWeatherData("2023-10-15", 26.0, 19.0, WeatherCondition.PARTLY_CLOUDY, 6.5),
        DailyWeatherData("2023-10-16", 24.0, 18.0, WeatherCondition.RAIN_HEAVY, 4.0),
        DailyWeatherData("2023-10-17", 25.0, 17.0, WeatherCondition.MAINLY_CLEAR, 5.0),
        DailyWeatherData("2023-10-18", 27.0, 20.0, WeatherCondition.PARTLY_CLOUDY, 7.5),
        DailyWeatherData("2023-10-19", 28.0, 21.0, WeatherCondition.MAINLY_CLEAR, 8.0),
        DailyWeatherData("2023-10-20", 26.0, 20.0, WeatherCondition.PARTLY_CLOUDY, 6.0),
        DailyWeatherData("2023-10-21", 24.0, 19.0, WeatherCondition.THUNDERSTORM_WITH_HAIL_SLIGHT, 3.5)
    )

    val sampleDailyWeather = DailyWeather(days = dailyDataList)

    val sampleDailyWeatherUnit = DailyWeatherUnit(
        time = "ISO 8601",
        temperature2mMin = "°C",
        temperature2mMax = "°C",
        weatherCode = "WMO code",
        uvIndexMax = "UV Index"
    )

    val sampleWeather = Weather(
        timeZone = "6 October",
        currentWeather = sampleCurrentWeather,
        currentWeatherUnit = sampleCurrentWeatherUnit,
        hourlyWeatherUnit = sampleHourlyWeatherUnit,
        hourlyWeather = sampleHourlyWeather,
        dailyWeatherUnit = sampleDailyWeatherUnit,
        dailyWeather = sampleDailyWeather
    )

    val sampleWeatherUiState = WeatherUiState(weather = sampleWeather)

}