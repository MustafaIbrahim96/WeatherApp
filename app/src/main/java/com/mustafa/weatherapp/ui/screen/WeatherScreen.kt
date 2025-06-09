package com.mustafa.weatherapp.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafa.weatherapp.ui.composeable.HeaderScroll
import com.mustafa.weatherapp.ui.theme.BackgroundBottomBrush
import com.mustafa.weatherapp.ui.theme.BackgroundTopBrush
import com.mustafa.weatherapp.ui.viewModel.WeatherViewModel
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

    state?.let {

        val listState = rememberLazyListState()
        val isScrolled = remember {
            derivedStateOf {
                listState.firstVisibleItemIndex > 0
                        || listState.firstVisibleItemScrollOffset > 100
            }
        }

        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(BackgroundTopBrush, BackgroundBottomBrush)
                    )
                )
        ) {
            item {
                Spacer(modifier = Modifier.height(24.dp))
            }
            item {
                HeaderScroll(state, isScrolled.value)
            }
            item {
                WeatherDetailsGrid()
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                WeatherDetailsGrid()
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                WeatherDetailsGrid()
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                WeatherDetailsGrid()
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                WeatherDetailsGrid()
            }

        }

    } ?: Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}


@Composable
fun WeatherDetailsGrid() {
    Column(Modifier.padding(16.dp)) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            WeatherDetailCard("13 KM/h", "Wind")
            WeatherDetailCard("24%", "Humidity")
            WeatherDetailCard("2%", "Rain")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            WeatherDetailCard("2", "UV Index")
            WeatherDetailCard("1012 hPa", "Pressure")
            WeatherDetailCard("22°C", "Feels like")
        }
    }
}

@Composable
fun WeatherDetailCard(value: String, label: String) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .height(80.dp)
            .background(Color(0xFFE0F7FA), shape = RoundedCornerShape(12.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = value, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Text(text = label, fontSize = 14.sp, color = Color.Gray)
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview
@Composable
private fun WeatherScreenPreview() {
    WeatherScreen()
}