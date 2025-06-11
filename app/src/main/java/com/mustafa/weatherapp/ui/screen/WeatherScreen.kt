package com.mustafa.weatherapp.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mustafa.weatherapp.domain.entity.CurrentWeather
import com.mustafa.weatherapp.domain.entity.Weather
import com.mustafa.weatherapp.ui.composeable.Next7daysWeatherCard
import com.mustafa.weatherapp.ui.composeable.HeaderScroll
import com.mustafa.weatherapp.ui.composeable.TodayHorizontallyScrollWithTitle
import com.mustafa.weatherapp.ui.composeable.WeatherDetailsGrid
import com.mustafa.weatherapp.ui.theme.BackgroundBottomBrushDay
import com.mustafa.weatherapp.ui.theme.BackgroundBottomBrushNight
import com.mustafa.weatherapp.ui.theme.BackgroundTopBrushDay
import com.mustafa.weatherapp.ui.theme.BackgroundTopBrushNight
import com.mustafa.weatherapp.ui.viewModel.WeatherViewModel
import com.mustafa.weatherapp.ui.viewModel.state.FakeWeatherData.sampleWeatherUiState
import com.mustafa.weatherapp.ui.viewModel.state.WeatherUiState
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun WeatherScreen(viewModel: WeatherViewModel = koinViewModel()) {

    val state by viewModel.state.collectAsState()
    WeatherContent(state)
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun WeatherContent(state: WeatherUiState?) {

    var colorBrush = Brush.verticalGradient(
        colors = listOf(BackgroundTopBrushDay, BackgroundBottomBrushDay)
    )

    state?.let {

        val hourlyWeather = state.weather.hourlyWeather.hourly
        val hourlyWeatherUnit = state.weather.hourlyWeatherUnit
        val isDay = state.weather.currentWeather.isDay
        val dailyWeather = state.weather.dailyWeather.days.drop(1)
        val dailyWeatherUnit = state.weather.dailyWeatherUnit

        colorBrush =
            Brush.verticalGradient(
                colors = if (isDay) listOf(BackgroundTopBrushDay, BackgroundBottomBrushDay)
                else listOf(BackgroundTopBrushNight, BackgroundBottomBrushNight)
            )


        val listState = rememberLazyListState()
        val scrollOffset by remember {
            derivedStateOf {
                val offset = listState.firstVisibleItemScrollOffset
                val maxOffset = 300
                (offset.coerceAtMost(maxOffset)).toFloat() / maxOffset
            }
        }

        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .background(brush = colorBrush)
                .padding(WindowInsets.systemBars.asPaddingValues())
        ) {
            item {
                Spacer(modifier = Modifier.height(2.dp))
            }
            item {
                Spacer(modifier = Modifier.height(22.dp))
                HeaderScroll(state, scrollOffset)
            }
            item {
                WeatherDetailsGrid(state)
            }
            item {
                TodayHorizontallyScrollWithTitle(hourlyWeather, hourlyWeatherUnit, isDay)
            }

            item {
                Next7daysWeatherCard(dailyWeather, dailyWeatherUnit, isDay)
                Spacer(modifier = Modifier.height(32.dp))

            }

        }

    } ?: Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = colorBrush
            ), contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}


@RequiresApi(Build.VERSION_CODES.S)
@Preview
@Composable
private fun WeatherScreenPreview() {
    WeatherContent(state = sampleWeatherUiState)
}