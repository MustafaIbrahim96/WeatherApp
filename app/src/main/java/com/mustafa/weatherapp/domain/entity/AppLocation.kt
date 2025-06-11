package com.mustafa.weatherapp.domain.entity

data class AppLocation(
    val latitude: Double,
    val longitude: Double,
    val cityName : String = ""
)