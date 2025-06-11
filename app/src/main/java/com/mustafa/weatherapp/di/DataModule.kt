package com.mustafa.weatherapp.di

import android.content.Context

import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.mustafa.weatherapp.data.datasource.remote.api.WeatherApi
import com.mustafa.weatherapp.data.datasource.remote.api.WeatherApiImpl
import com.mustafa.weatherapp.data.datasource.service.LocationServiceImpl
import com.mustafa.weatherapp.data.repository.service.LocationService

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule =  module {
    single<FusedLocationProviderClient> {
        LocationServices.getFusedLocationProviderClient(get<Context>())
    }

    single<LocationService> {
        LocationServiceImpl(
            context = androidContext(),
            fusedLocationClient = get()
        )
    }

    single<WeatherApi> { WeatherApiImpl(get()) }

}