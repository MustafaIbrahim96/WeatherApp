package com.mustafa.weatherapp

import androidx.compose.runtime.Composable
import com.mustafa.weatherapp.ui.screen.WeatherScreen
import com.mustafa.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun WeatherApp() {
    WeatherAppTheme {
        WeatherScreen()
    }
}