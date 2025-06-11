package com.mustafa.weatherapp.data.repository

import com.mustafa.weatherapp.data.datasource.remote.api.WeatherApi
import com.mustafa.weatherapp.data.datasource.remote.mapper.toWeather
import com.mustafa.weatherapp.domain.entity.Weather
import com.mustafa.weatherapp.data.repository.service.LocationService
import com.mustafa.weatherapp.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val locationProvider: LocationService,
    private val weatherApi: WeatherApi
) : WeatherRepository {
    override suspend fun getWeather(): Weather {
        val locationDto = locationProvider.getCurrentLocation()
        return locationDto?.let {
            weatherApi.getWeather(it.latitude, it.longitude).toWeather()
        } ?: throw Exception("Location not available")
    }
}