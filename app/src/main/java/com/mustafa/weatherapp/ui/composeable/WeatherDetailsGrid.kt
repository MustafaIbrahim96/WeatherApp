package com.mustafa.weatherapp.ui.composeable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mustafa.weatherapp.R
import com.mustafa.weatherapp.ui.viewModel.state.WeatherUiState

@Composable
fun WeatherDetailsGrid(state: WeatherUiState) {
    val currentWeather = state.weather.currentWeather
    val daily = state.weather.dailyWeather
    val currentWeatherUnit = state.weather.currentWeatherUnit

    Column(modifier = Modifier.padding(horizontal = 9.dp)) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            CardCurrentWeather(
                Modifier.weight(1f),
                painterResource(id = R.drawable.ic_fast_wind),
                "${currentWeather.windSpeed10m} " +
                        currentWeatherUnit.windSpeed10m.uppercase(),
                "Wind"
            )
            CardCurrentWeather(
                Modifier.weight(1f),
                painterResource(id = R.drawable.ic_humidity),
                currentWeather.relativeHumidity2m.toString() +
                        currentWeatherUnit.relativeHumidity2m,
                "Humidity"
            )
            CardCurrentWeather(
                Modifier.weight(1f),
                painterResource(id = R.drawable.ic_rain),
                currentWeather.precipitationProbability.toString() +
                        currentWeatherUnit.precipitationProbability,
                "Rain"
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            CardCurrentWeather(
                Modifier.weight(1f),
                painterResource(id = R.drawable.ic_uv),
                daily.days.first().uvIndexMax.toString(),
                "UV Index"
            )
            CardCurrentWeather(
                Modifier.weight(1f),
                painterResource(id = R.drawable.ic_pressure),
                currentWeather.surfacePressure.toString()+ " " +
                        currentWeatherUnit.surfacePressure,
                "Pressure"
            )
            CardCurrentWeather(
                Modifier.weight(1f),
                painterResource(id = R.drawable.ic_temperature),
                currentWeather.temperature2m.toString() +
                        currentWeatherUnit.temperature2m,
                "Feels like"
            )
        }
    }
}
