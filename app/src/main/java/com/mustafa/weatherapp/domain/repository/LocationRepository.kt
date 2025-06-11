package com.mustafa.weatherapp.domain.repository

import com.mustafa.weatherapp.domain.entity.AppLocation

fun interface LocationRepository {
    suspend fun getLocation(): AppLocation
}