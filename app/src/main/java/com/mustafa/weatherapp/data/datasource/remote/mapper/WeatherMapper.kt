package com.mustafa.weatherapp.data.datasource.remote.mapper

import android.location.Location
import android.os.Build
import androidx.annotation.RequiresApi
import com.mustafa.weatherapp.data.datasource.remote.dto.CurrentWeatherDto
import com.mustafa.weatherapp.data.datasource.remote.dto.CurrentWeatherUnitsDto
import com.mustafa.weatherapp.data.datasource.remote.dto.DailyDto
import com.mustafa.weatherapp.data.datasource.remote.dto.DailyUnitsDto
import com.mustafa.weatherapp.data.datasource.remote.dto.HourlyDto
import com.mustafa.weatherapp.data.datasource.remote.dto.HourlyUnitsDto
import com.mustafa.weatherapp.data.datasource.remote.dto.WeatherResponseDto
import com.mustafa.weatherapp.data.datasource.util.getDayName
import com.mustafa.weatherapp.domain.entity.AppLocation
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
import org.slf4j.helpers.Util

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherResponseDto.toWeather(): Weather {
    return Weather(
        timeZone = this.timeZone,
        currentWeather = this.currentWeatherDto.toCurrentWeather(),
        currentWeatherUnit = this.currentWeatherUnitsDto.toCurrentWeatherUnits(),
        hourlyWeatherUnit = this.hourlyUnitsDto.toHourlyWeatherUnit(),
        hourlyWeather = this.hourlyDto.toHourlyWeather(),
        dailyWeatherUnit = this.dailyUnitsDto.toDailyWeatherUnit(),
        DailyWeather = this.dailyDto.toDailyDtoWeather(),
    )
}

fun CurrentWeatherDto.toCurrentWeather(): CurrentWeather {
    return CurrentWeather(
        time = this.time,
        interval = this.interval,
        temperature = this.temperature,
        windspeed = this.windspeed,
        winddirection = this.winddirection,
        isDay = this.is_day == 1,
        weathercode = mapWeatherCodeToCondition(this.weathercode)
    )
}

fun CurrentWeatherUnitsDto.toCurrentWeatherUnits(): CurrentWeatherUnit {
    return CurrentWeatherUnit(
        time = this.time,
        interval = this.interval,
        temperature = this.temperature,
        windspeed = this.windspeed,
        winddirection = this.winddirection,
        isDay = this.isDay,
        weathercode = this.weathercode
    )
}

fun HourlyUnitsDto.toHourlyWeatherUnit(): HourlyWeatherUnit {
    return HourlyWeatherUnit(
        time = this.time,
        temperature2m = this.temperature2m,
        weathercode = this.weathercode
    )
}

fun HourlyDto.toHourlyWeather(): HourlyWeather {
    return HourlyWeather(
        hourly = this.time.indices.map { index ->
            HourlyWeatherData(
                date = time[index],
                temp = temperature2m[index],
                weatherCode = mapWeatherCodeToCondition(weathercode[index])
            )
        }
    )
}

fun DailyUnitsDto.toDailyWeatherUnit(): DailyWeatherUnit {
    return DailyWeatherUnit(
        time = this.time,
        temperature2mMax = this.temperature2mMax,
        temperature2mMin = this.temperature2mMin,
        weathercode = this.weathercode
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun DailyDto.toDailyDtoWeather(): DailyWeather {
    return DailyWeather(
        days = this.time.indices.map { index ->
            DailyWeatherData(
                date = getDayName(time[index]),
                maxTemp = temperature2mMax[index],
                minTemp = temperature2mMin[index],
                weatherCode = mapWeatherCodeToCondition(weathercode[index])
            )
        }
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