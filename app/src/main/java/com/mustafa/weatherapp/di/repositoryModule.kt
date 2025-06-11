package com.mustafa.weatherapp.di

import com.mustafa.weatherapp.data.repository.LocationRepositoryImpl
import com.mustafa.weatherapp.data.repository.WeatherRepositoryImpl
import com.mustafa.weatherapp.domain.repository.LocationRepository
import com.mustafa.weatherapp.domain.repository.WeatherRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single<WeatherRepository> { WeatherRepositoryImpl(get(), get()) }
    single<LocationRepository> { LocationRepositoryImpl(androidContext(), get()) }
}