package com.mustafa.weatherapp.ui.screen

import android.Manifest
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import android.content.pm.PackageManager
import com.mustafa.weatherapp.ui.composeable.Next7daysWeatherCard
import com.mustafa.weatherapp.ui.composeable.HeaderScroll
import com.mustafa.weatherapp.ui.composeable.TodayHorizontallyScrollWithTitle
import com.mustafa.weatherapp.ui.composeable.WeatherDetailsGrid
import com.mustafa.weatherapp.ui.theme.BackgroundBottomBrushDay
import com.mustafa.weatherapp.ui.theme.BackgroundBottomBrushNight
import com.mustafa.weatherapp.ui.theme.BackgroundTopBrushDay
import com.mustafa.weatherapp.ui.theme.BackgroundTopBrushNight
import com.mustafa.weatherapp.ui.viewModel.WeatherViewModel
import com.mustafa.weatherapp.ui.model.FakeWeatherData.sampleWeatherUiState
import com.mustafa.weatherapp.ui.viewModel.state.WeatherScreenUiState
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun WeatherScreen(viewModel: WeatherViewModel = koinViewModel()) {

    val context = LocalContext.current
    val state by viewModel.state.collectAsState()

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { result ->
        val granted = result[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
            result[Manifest.permission.ACCESS_COARSE_LOCATION] == true
        if (granted) {
            viewModel.loadWeather()
        } else {
            viewModel.onLocationPermissionDenied()
        }
    }

    LaunchedEffect(Unit) {
        val fine = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        val coarse = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        if (fine || coarse) {
            viewModel.loadWeather()
        } else {
            permissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }

    WeatherContent(state = state, onRetry = { viewModel.loadWeather() })
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun WeatherContent(
    state: WeatherScreenUiState,
    onRetry: () -> Unit = {}
) {

    var colorBrush = Brush.verticalGradient(
        colors = listOf(BackgroundTopBrushDay, BackgroundBottomBrushDay)
    )

    when (state) {
        is WeatherScreenUiState.Success -> {
            val ui = state.ui
        val hourlyWeather = ui.weather.hourlyWeather.hourly
        val hourlyWeatherUnit = ui.weather.hourlyWeatherUnit
        val isDay = ui.weather.currentWeather.isDay
        val dailyWeather = ui.weather.dailyWeather.days.drop(1)
        val dailyWeatherUnit = ui.weather.dailyWeatherUnit

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
                HeaderScroll(ui, scrollOffset)
            }
            item {
                WeatherDetailsGrid(ui)
            }
            item {
                TodayHorizontallyScrollWithTitle(hourlyWeather, hourlyWeatherUnit, isDay)
            }

            item {
                Next7daysWeatherCard(dailyWeather, dailyWeatherUnit, isDay)
                Spacer(modifier = Modifier.height(32.dp))

            }

        }
        }

        WeatherScreenUiState.Loading -> Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = colorBrush),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

        is WeatherScreenUiState.Error -> Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = colorBrush)
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(text = state.message, textAlign = TextAlign.Center)
                Button(onClick = onRetry) {
                    Text("Retry")
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.S)
@Preview
@Composable
private fun WeatherScreenPreview() {
    WeatherContent(state = WeatherScreenUiState.Success(sampleWeatherUiState))
}