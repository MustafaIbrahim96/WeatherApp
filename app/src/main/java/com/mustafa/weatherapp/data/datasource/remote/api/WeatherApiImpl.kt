package com.mustafa.weatherapp.data.datasource.remote.api

import com.mustafa.weatherapp.data.datasource.remote.dto.WeatherResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.serialization.json.Json

class WeatherApiImpl(private val client: HttpClient) : WeatherApi {
    override suspend fun getWeather(latitude: Double, longitude: Double): WeatherResponseDto {
        val response = client.get("https://api.open-meteo.com/v1/forecast") {
            parameter("latitude", latitude)
            parameter("longitude", longitude)
            parameter("current_weather", true)
            parameter("daily", "temperature_2m_max,temperature_2m_min,weathercode")
            parameter("timezone", "auto")
            parameter("hourly", "temperature_2m,weathercode")
        }
        return response.body()
    }
}