package com.mustafa.weatherapp.domain.provider

import com.mustafa.weatherapp.domain.entity.AppLocation

fun interface LocationProvider {
    suspend fun getCurrentLocation():AppLocation?
}