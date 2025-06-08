package com.mustafa.weatherapp.data.datasource.remote.mapper

import android.location.Location
import com.mustafa.weatherapp.data.datasource.remote.dto.CurrentWeatherDto
import com.mustafa.weatherapp.data.datasource.remote.dto.WeatherResponseDto
import com.mustafa.weatherapp.domain.entity.AppLocation
import com.mustafa.weatherapp.domain.entity.CurrentWeather
import com.mustafa.weatherapp.domain.entity.Weather
import org.example.domain.model.entity.weather.WeatherCondition

fun WeatherResponseDto.toWeather(): Weather {
    return Weather(
        timeZone = this.timeZone,
        currentWeather = this.currentWeatherDto.toCurrentWeather()
    )
}

fun CurrentWeatherDto.toCurrentWeather(): CurrentWeather {
    return CurrentWeather(
        time = this.time,
        interval = this.interval,
        temperature = this.temperature,
        windspeed = this.windspeed,
        winddirection = this.winddirection,
        is_day = this.is_day == 1,
        weathercode = mapWeatherCodeToCondition(this.weathercode)
    )
}

fun Location.toAppLocation(): AppLocation {
    return AppLocation(
        latitude = this.latitude,
        longitude = this.longitude
    )
}

private fun mapWeatherCodeToCondition(code: Int): WeatherCondition {
    return when (code) {
        0 -> WeatherCondition.CLEAR_SKY
        1 -> WeatherCondition.MAINLY_CLEAR
        2 -> WeatherCondition.PARTLY_CLOUDY
        3 -> WeatherCondition.OVERCAST
        45, 48 -> WeatherCondition.FOG
        51, 53, 55 -> WeatherCondition.DRIZZLE
        56, 57 -> WeatherCondition.LIGHT_FREEZING_DRIZZLE
        61 -> WeatherCondition.SLIGHT_RAIN
        63 -> WeatherCondition.MODERATE_RAIN
        65 -> WeatherCondition.HEAVY_INTENSITY_RAIN
        66 -> WeatherCondition.LIGHT_FREEZING_RAIN
        67 -> WeatherCondition.HEAVY_INTENSITY_FREEZING_RAIN
        71 -> WeatherCondition.SLIGHT_SNOW_FALL
        73 -> WeatherCondition.MODERATE_SNOW_FALL
        75 -> WeatherCondition.HEAVY_INTENSITY_SNOW_FALL
        77 -> WeatherCondition.SNOW_GRAINS
        80 -> WeatherCondition.SLIGHT_RAIN_SHOWERS
        81 -> WeatherCondition.MODERATE_RAIN_SHOWERS
        82 -> WeatherCondition.VIOLENT_RAIN_SHOWERS
        85 -> WeatherCondition.SLIGHT_SNOW_SHOWERS
        86 -> WeatherCondition.HEAVY_SNOW_SHOWERS
        95 -> WeatherCondition.SLIGHT_THUNDERSTORM
        96, 99 -> WeatherCondition.SLIGHT_THUNDERSTORM_WITH_HAIL
        else -> WeatherCondition.UNKNOWN
    }
}