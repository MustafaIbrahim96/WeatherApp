package com.mustafa.weatherapp.di

import android.content.Context

import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.mustafa.weatherapp.data.datasource.remote.api.WeatherApi
import com.mustafa.weatherapp.data.datasource.remote.api.WeatherApiImpl
import com.mustafa.weatherapp.data.datasource.remote.service.LocationServiceImpl
import com.mustafa.weatherapp.data.repository.service.LocationService

import org.koin.dsl.module

fun dataModule(appContext: Context) = module {
    factory<FusedLocationProviderClient> {
        LocationServices.getFusedLocationProviderClient(appContext)
    }

    factory<LocationService> {
        LocationServiceImpl(
            context = appContext,
            fusedLocationClient = get()
        )
    }

    single<WeatherApi> { WeatherApiImpl(get()) }
}