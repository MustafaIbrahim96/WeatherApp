package com.mustafa.weatherapp.di

import com.mustafa.weatherapp.ui.viewModel.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { WeatherViewModel(get(), get()) }
}