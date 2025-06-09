package com.mustafa.weatherapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import com.mustafa.weatherapp.ui.screen.WeatherScreen
import com.mustafa.weatherapp.ui.theme.WeatherAppTheme

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun WeatherApp() {
    WeatherAppTheme {
        WeatherScreen()
    }
}