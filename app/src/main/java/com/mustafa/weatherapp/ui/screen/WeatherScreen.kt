package com.mustafa.weatherapp.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mustafa.weatherapp.ui.viewModel.WeatherViewModel
import com.mustafa.weatherapp.ui.viewModel.state.WeatherUiState
import org.koin.androidx.compose.koinViewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel = koinViewModel()) {

    val state by viewModel.state.collectAsState()
    WeatherContent(state)
}

@Composable
fun WeatherContent(state: WeatherUiState?) {
    state?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("درجة الحرارة: ${it.weather.currentWeather.temperature}°C", color = Color.Black)
            Text("سرعة الرياح: ${it.weather.currentWeather.windspeed} km/h", color = Color.Black)
        }
    } ?: Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}
