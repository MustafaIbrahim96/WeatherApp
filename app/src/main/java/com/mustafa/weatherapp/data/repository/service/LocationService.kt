package com.mustafa.weatherapp.data.repository.service

import com.mustafa.weatherapp.data.datasource.remote.dto.AppLocationDto

fun interface LocationService {
    suspend fun getCurrentLocation(): AppLocationDto?
}