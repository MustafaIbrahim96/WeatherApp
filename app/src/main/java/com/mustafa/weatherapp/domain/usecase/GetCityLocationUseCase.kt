package com.mustafa.weatherapp.domain.usecase

import com.mustafa.weatherapp.domain.entity.AppLocation
import com.mustafa.weatherapp.domain.repository.LocationRepository

class GetCityLocationUseCase(private val locationRepository: LocationRepository) {
    suspend operator fun invoke(): AppLocation = locationRepository.getLocation()
}