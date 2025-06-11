package com.mustafa.weatherapp.di

import com.mustafa.weatherapp.domain.usecase.GetCityLocationUseCase
import com.mustafa.weatherapp.domain.usecase.GetWeatherUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetWeatherUseCase(get()) }
    single { GetCityLocationUseCase(get()) }
}