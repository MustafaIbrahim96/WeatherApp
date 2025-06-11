package com.mustafa.weatherapp.data.repository.mapper

import android.location.Location
import com.mustafa.weatherapp.data.datasource.remote.dto.AppLocationDto
import com.mustafa.weatherapp.data.datasource.remote.dto.CurrentWeatherDto
import com.mustafa.weatherapp.data.datasource.remote.dto.CurrentWeatherUnitsDto
import com.mustafa.weatherapp.data.datasource.remote.dto.DailyDto
import com.mustafa.weatherapp.data.datasource.remote.dto.DailyUnitsDto
import com.mustafa.weatherapp.data.datasource.remote.dto.HourlyDto
import com.mustafa.weatherapp.data.datasource.remote.dto.HourlyUnitsDto
import com.mustafa.weatherapp.data.datasource.remote.dto.WeatherResponseDto
import com.mustafa.weatherapp.data.datasource.util.getCurrentDateFormatted
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
import com.mustafa.weatherapp.domain.entity.WeatherCondition
import kotlinx.datetime.LocalDate

fun WeatherResponseDto.toWeather(): Weather {
    return Weather(
        timeZone = this.timeZone,
        currentWeather = this.currentWeatherDto.toCurrentWeather(),
        currentWeatherUnit = this.currentWeatherUnitsDto.toCurrentWeatherUnits(),
        hourlyWeatherUnit = this.hourlyUnitsDto.toHourlyWeatherUnit(),
        hourlyWeather = this.hourlyDto.toHourlyWeatherForToday(),
        dailyWeatherUnit = this.dailyUnitsDto.toDailyWeatherUnit(),
        dailyWeather = this.dailyDto.toDailyDtoWeather(),
    )
}

fun CurrentWeatherDto.toCurrentWeather(): CurrentWeather {
    return CurrentWeather(
        time = this.time,
        interval = this.interval,
        weatherCode = mapWeatherCodeToCondition(this.weatherCode),
        relativeHumidity2m = this.relativeHumidity2m,
        windSpeed10m = this.windspeed10m,
        precipitationProbability = this.precipitationProbability,
        surfacePressure = this.surfacepressure,
        apparentTemperature = this.apparentTemperature,
        temperature2m = this.temperature2m,
        isDay = this.isDay == 1,
    )
}

fun CurrentWeatherUnitsDto.toCurrentWeatherUnits(): CurrentWeatherUnit {
    return CurrentWeatherUnit(
        time = this.time,
        interval = this.interval,
        weatherCode = this.weatherCode,
        relativeHumidity2m = this.relativeHumidity2m,
        windSpeed10m = this.windspeed10m,
        precipitationProbability = this.precipitationProbability,
        surfacePressure = this.surfacepressure,
        apparentTemperature = this.apparentTemperature,
        temperature2m = this.temperature2m,
        isDay = this.isDay,
    )
}

fun HourlyUnitsDto.toHourlyWeatherUnit(): HourlyWeatherUnit {
    return HourlyWeatherUnit(
        time = this.time,
        temperature2m = this.temperature2m,
        weatherCode = this.weathercode
    )
}

fun HourlyDto.toHourlyWeatherForToday(): HourlyWeather {

    val today = getCurrentDateFormatted()
    val filteredIndices = mutableListOf<Int>()


    this.time.indices.forEach { index ->
        val dateSplit = this.time[index].split("T")[0]
        val parsedDate = LocalDate.parse(dateSplit)

        if (parsedDate == today) {
            filteredIndices.add(index)
        }
    }

    return HourlyWeather(
        hourly = filteredIndices.map { index ->
            HourlyWeatherData(
                date = this.time[index],
                temp = this.temperature2m[index],
                weatherCode = mapWeatherCodeToCondition(this.weathercode[index])
            )
        }
    )
}

fun DailyUnitsDto.toDailyWeatherUnit(): DailyWeatherUnit {
    return DailyWeatherUnit(
        time = this.time,
        temperature2mMax = this.temperature2mMax,
        temperature2mMin = this.temperature2mMin,
        weatherCode = this.weathercode,
        uvIndexMax = this.uvIndexMax
    )
}

fun DailyDto.toDailyDtoWeather(): DailyWeather {
    return DailyWeather(
        days = this.time.indices.map { index ->
            DailyWeatherData(
                date = getDayName(time[index]),
                maxTemp = temperature2mMax[index],
                minTemp = temperature2mMin[index],
                weatherCode = mapWeatherCodeToCondition(weathercode[index]),
                uvIndexMax = uvIndexMax[index]

            )
        }
    )
}

fun Location.toAppLocationDto(): AppLocationDto {
    return AppLocationDto(
        latitude = this.latitude,
        longitude = this.longitude
    )
}

fun AppLocationDto.toAppLocation(): AppLocation {
    return AppLocation(
        latitude = this.latitude,
        longitude = this.longitude,
    )
}

private fun mapWeatherCodeToCondition(code: Int): WeatherCondition {
    return when (code) {
        0 -> WeatherCondition.CLEAR_SKY
        1 -> WeatherCondition.MAINLY_CLEAR
        2 -> WeatherCondition.PARTLY_CLOUDY
        3 -> WeatherCondition.OVERCAST
        45 -> WeatherCondition.FOG
        48 -> WeatherCondition.DEPOSITING_RIME_FOG
        51 -> WeatherCondition.DRIZZLE_LIGHT
        53 -> WeatherCondition.DRIZZLE_MODERATE
        55 -> WeatherCondition.DRIZZLE_DENSE
        56 -> WeatherCondition.FREEZING_DRIZZLE_LIGHT
        57 -> WeatherCondition.FREEZING_DRIZZLE_DENSE
        61 -> WeatherCondition.RAIN_SLIGHT
        63 -> WeatherCondition.RAIN_MODERATE
        65 -> WeatherCondition.RAIN_HEAVY
        66 -> WeatherCondition.FREEZING_RAIN_LIGHT
        67 -> WeatherCondition.FREEZING_RAIN_HEAVY
        71 -> WeatherCondition.SNOW_SLIGHT
        73 -> WeatherCondition.SNOW_MODERATE
        75 -> WeatherCondition.SNOW_HEAVY
        77 -> WeatherCondition.SNOW_GRAINS
        80 -> WeatherCondition.RAIN_SHOWERS_SLIGHT
        81 -> WeatherCondition.RAIN_SHOWERS_MODERATE
        82 -> WeatherCondition.RAIN_SHOWERS_VIOLENT
        85 -> WeatherCondition.SNOW_SHOWERS_SLIGHT
        86 -> WeatherCondition.SNOW_SHOWERS_HEAVY
        95 -> WeatherCondition.THUNDERSTORM_SLIGHT
        96 -> WeatherCondition.THUNDERSTORM_WITH_HAIL_SLIGHT
        99 -> WeatherCondition.THUNDERSTORM_WITH_HAIL_HEAVY
        else -> WeatherCondition.UNKNOWN
    }
}