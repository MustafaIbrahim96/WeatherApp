package com.mustafa.weatherapp.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.mustafa.weatherapp.data.datasource.remote.api.WeatherApi
import com.mustafa.weatherapp.data.datasource.remote.mapper.toWeather
import com.mustafa.weatherapp.domain.entity.Weather
import com.mustafa.weatherapp.domain.provider.LocationProvider
import com.mustafa.weatherapp.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val locationProvider: LocationProvider,
    private val weatherApi: WeatherApi
) : WeatherRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeather(): Weather {
        val location = locationProvider.getCurrentLocation()
        return location?.let {
            weatherApi.getWeather(it.latitude, it.longitude).toWeather()
        } ?: throw Exception("Location not available")
    }
}