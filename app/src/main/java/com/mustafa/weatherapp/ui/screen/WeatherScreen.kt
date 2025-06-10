package com.mustafa.weatherapp.ui.screen

import RowTempMaxMin
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
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafa.weatherapp.R
import com.mustafa.weatherapp.domain.entity.DailyWeatherData
import com.mustafa.weatherapp.domain.entity.DailyWeatherUnit
import com.mustafa.weatherapp.domain.entity.HourlyWeatherData
import com.mustafa.weatherapp.domain.entity.HourlyWeatherUnit
import com.mustafa.weatherapp.ui.composeable.HeaderScroll
import com.mustafa.weatherapp.ui.composeable.TodayCardWeather
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
        val hourlyWeather = state.weather.hourlyWeather.hourly
        val hourlyWeatherUnit = state.weather.hourlyWeatherUnit
        val isDay = state.weather.currentWeather.isDay
        val dailyWeather = state.weather.dailyWeather.days
        val dailyWeatherUnit = state.weather.dailyWeatherUnit

        val listState = rememberLazyListState()
        val isScrolled = remember {
            derivedStateOf {
                listState.firstVisibleItemIndex > 0
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
                Text(
                    modifier = Modifier.padding(start = 12.dp, top = 24.dp, bottom = 12.dp),
                    text = "Today",
                    fontSize = 20.sp,
                    lineHeight = 20.sp,
                    color = BigTitleColor,
                    fontFamily = Urbanist_font,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.25.sp
                )

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(hourlyWeather) {
                        TodayCardWeather(it, hourlyWeatherUnit, isDay)
                    }
                }

                Text(
                    modifier = Modifier.padding(start = 12.dp, top = 24.dp, bottom = 12.dp),
                    text = "Next 7 days",
                    fontSize = 20.sp,
                    lineHeight = 20.sp,
                    color = BigTitleColor,
                    fontFamily = Urbanist_font,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.25.sp
                )
            }

            item {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(24.dp))
                        .border(width = 1.dp,
                            color = BorderCard,
                            shape = RoundedCornerShape(24.dp)
                        )
                        .background(WhIte70AColor),
                ) {
                    Column {
                        dailyWeather.forEachIndexed { index, daily ->
                            CardDailyWeather(daily, dailyWeatherUnit, isDay)

                            if (index != dailyWeather.lastIndex) {
                                Spacer(
                                    modifier = Modifier
                                        .height(1.dp)
                                        .fillMaxWidth()
                                        .background(BorderCard)
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))

            }

        }

    } ?: Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(BackgroundTopBrush, BackgroundBottomBrush)
                )
            ), contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun CardDailyWeather(
    daily: DailyWeatherData,
    dailyWeatherUnit: DailyWeatherUnit,
    isDay: Boolean
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = daily.date,
            fontSize = 16.sp,
            lineHeight = 16.sp,
            color = BigTitle60AColor,
            fontFamily = Urbanist_font,
            fontWeight = FontWeight.Normal,
        )

        Box(
            modifier = Modifier
                .height(45.dp)
                .width(91.dp)
        ) {
            Image(
                painter = painterResource(daily.weatherCode.getIconResId(isDay)),
                contentDescription = "Image Weather",
                modifier = Modifier
                    .align(Alignment.Center),
            )
        }

        RowTempMaxMin(daily, dailyWeatherUnit, BigTitle87AColor)

    }
}


@RequiresApi(Build.VERSION_CODES.S)
@Preview
@Composable
private fun WeatherScreenPreview() {
    WeatherScreen()
}