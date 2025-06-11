package com.mustafa.weatherapp.data.datasource.remote.api

import com.mustafa.weatherapp.data.datasource.remote.dto.WeatherResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class WeatherApiImpl(private val client: HttpClient) : WeatherApi {
    override suspend fun getWeather(latitude: Double, longitude: Double): WeatherResponseDto {
        val response = client.get("https://api.open-meteo.com/v1/forecast") {
            parameter("latitude", latitude)
            parameter("longitude", longitude)
            parameter(
                "current",
                "weather_code,relative_humidity_2m,wind_speed_10m,precipitation_probability,surface_pressure,apparent_temperature,temperature_2m,is_day"
            )
            parameter("daily", "temperature_2m_max,temperature_2m_min,weathercode,uv_index_max")
            parameter("timezone", "auto")
            parameter("hourly", "temperature_2m,weathercode")
        }
        return response.body()
    }
}