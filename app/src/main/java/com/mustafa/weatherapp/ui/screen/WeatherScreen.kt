package com.mustafa.weatherapp.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafa.weatherapp.R
import com.mustafa.weatherapp.ui.composeable.CardCurrentWeather
import com.mustafa.weatherapp.ui.composeable.HeaderScroll
import com.mustafa.weatherapp.ui.composeable.WeatherDetailsGrid
import com.mustafa.weatherapp.ui.theme.BackgroundBottomBrush
import com.mustafa.weatherapp.ui.theme.BackgroundTopBrush
import com.mustafa.weatherapp.ui.theme.BigTitle60AColor
import com.mustafa.weatherapp.ui.theme.BigTitle87AColor
import com.mustafa.weatherapp.ui.theme.BigTitleColor
import com.mustafa.weatherapp.ui.theme.BorderCard
import com.mustafa.weatherapp.ui.theme.Urbanist_font
import com.mustafa.weatherapp.ui.theme.WhIte70AColor
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
                Spacer(modifier = Modifier.height(2.dp))
            }
            item {
                Spacer(modifier = Modifier.height(22.dp))
                HeaderScroll(state, isScrolled.value)
            }
            item {
                WeatherDetailsGrid(state)
            }
            item {
                Text(modifier = Modifier.padding(start = 12.dp, top = 24.dp, bottom = 12.dp),
                    text = "Today",
                    fontSize = 20.sp,
                    lineHeight = 20.sp,
                    color = BigTitleColor,
                    fontFamily = Urbanist_font,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.25.sp
                )

                LazyRow(contentPadding = PaddingValues(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(state.weather.hourlyWeather.hourly){
                        TodayCardWeather(state)
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                WeatherDetailsGrid(state)
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                WeatherDetailsGrid(state)
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                WeatherDetailsGrid(state)
            }

        }

    } ?: Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun TodayCardWeather(state: WeatherUiState) {
    Box() {
        Box(
            modifier = Modifier
                .padding(top = 12.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(WhIte70AColor)
                .border(width = 1.dp, color = BorderCard)
        ) {
            Column(
                modifier = Modifier.padding(
                    top = 62.dp,
                    end = 26.dp,
                    start = 26.dp,
                    bottom = 16.dp
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "25°C",
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    color = BigTitle87AColor,
                    fontFamily = Urbanist_font,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 0.25.sp
                )
                Text(
                    modifier = Modifier.padding(
                        top = 4.dp,
                    ),
                    text = "11:00",
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    color = BigTitle60AColor,
                    fontFamily = Urbanist_font,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 0.25.sp
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.img_clear_sky_day),
            contentDescription = "cloudy",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(start = 12.dp, end = 12.dp)
                .height(58.dp)
                .width(64.dp),
            contentScale = ContentScale.Fit

        )
    }
}


@RequiresApi(Build.VERSION_CODES.S)
@Preview
@Composable
private fun WeatherScreenPreview() {
    WeatherScreen()
}