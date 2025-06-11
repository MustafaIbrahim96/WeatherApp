package com.mustafa.weatherapp.di

import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.mustafa.weatherapp.data.datasource.remote.api.WeatherApi
import com.mustafa.weatherapp.data.datasource.remote.api.WeatherApiImpl
import com.mustafa.weatherapp.data.datasource.service.LocationServiceImpl
import com.mustafa.weatherapp.data.datasource.util.ColoredLogger
import com.mustafa.weatherapp.data.repository.LocationRepositoryImpl
import com.mustafa.weatherapp.data.repository.WeatherRepositoryImpl
import com.mustafa.weatherapp.data.repository.service.LocationService
import com.mustafa.weatherapp.domain.repository.LocationRepository
import com.mustafa.weatherapp.domain.repository.WeatherRepository
import com.mustafa.weatherapp.domain.usecase.GetCityLocationUseCase
import com.mustafa.weatherapp.domain.usecase.GetWeatherUseCase
import com.mustafa.weatherapp.ui.viewModel.WeatherViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<FusedLocationProviderClient> {
        LocationServices.getFusedLocationProviderClient(get<Context>())
    }

    single<LocationService> {
        LocationServiceImpl(
            context = androidContext(),
            fusedLocationClient = get()
        )
    }
    single {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
            install(Logging) {
                level = LogLevel.ALL
                logger = ColoredLogger
            }
        }
    }
    single { GetWeatherUseCase(get()) }
    single { GetCityLocationUseCase(get()) }

    single<WeatherApi> { WeatherApiImpl(get()) }
    single<WeatherRepository> { WeatherRepositoryImpl(get(), get()) }
    single<LocationRepository> { LocationRepositoryImpl(androidContext(), get()) }
    viewModel { WeatherViewModel(get(),get()) }
}