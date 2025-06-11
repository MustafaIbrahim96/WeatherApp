package com.mustafa.weatherapp.data.repository

import android.content.Context
import android.location.Geocoder
import com.mustafa.weatherapp.data.datasource.remote.mapper.toAppLocation
import com.mustafa.weatherapp.data.repository.service.LocationService
import com.mustafa.weatherapp.domain.entity.AppLocation
import com.mustafa.weatherapp.domain.repository.LocationRepository
import java.util.Locale

class LocationRepositoryImpl(private val context: Context, private val locationService: LocationService) : LocationRepository {

    override suspend fun getLocation(): AppLocation {
        val locationDto = locationService.getCurrentLocation()
            ?: throw Exception("Location not available")

        val cityName = getCityName(locationDto.latitude, locationDto.longitude)
            ?: throw Exception("City name not available")

        return locationDto.toAppLocation().copy(cityName = cityName)
    }

    private fun getCityName(latitude: Double,longitude: Double): String? {
        val cityName: String?
        val geoCoder = Geocoder(context, Locale.getDefault())
        val address = geoCoder.getFromLocation(latitude,longitude,3)?.toList()

        if (address.isNullOrEmpty()) return null

        cityName = address[0].adminArea
        return cityName
    }
}