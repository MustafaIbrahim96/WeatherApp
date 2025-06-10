package com.mustafa.weatherapp.ui.composeable

import RowTempMaxMin
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafa.weatherapp.ui.theme.BigTitle14AColor
import com.mustafa.weatherapp.ui.theme.BigTitle60AColor
import com.mustafa.weatherapp.ui.theme.BigTitleColor
import com.mustafa.weatherapp.ui.theme.CityColorNight
import com.mustafa.weatherapp.ui.theme.Urbanist_font
import com.mustafa.weatherapp.ui.theme.White08AColor
import com.mustafa.weatherapp.ui.theme.White60AColor
import com.mustafa.weatherapp.ui.theme.White87AColor
import com.mustafa.weatherapp.ui.viewModel.state.WeatherUiState

@Composable
fun DailyTempColumn(modifier: Modifier, weatherUiState: WeatherUiState) {
    val currentDay = weatherUiState.weather.dailyWeather.days[0]
    val dailyUnit = weatherUiState.weather.dailyWeatherUnit
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val currentWeather = weatherUiState.weather.currentWeather
        val currentWeatherUnit = weatherUiState.weather.currentWeatherUnit
        val isDay = weatherUiState.weather.currentWeather.isDay
        val switchColorTemperatureValue = if (isDay) BigTitleColor else CityColorNight
        val switchColorWeatherStatus = if (isDay) BigTitle60AColor else White60AColor
        val switchColorRowTemperature = if (isDay) BigTitle60AColor else White87AColor
        val switchColorBackGroundRow = if (isDay) BigTitle14AColor else White08AColor

        Text(
            "${currentWeather.temperature2m}" +
                    currentWeatherUnit.temperature2m,
            fontSize = 64.sp,
            fontFamily = Urbanist_font,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 64.sp,
            letterSpacing = 0.25.sp,
            color = switchColorTemperatureValue
        )

        Text(
            currentWeather.weatherCode.displayName,
            fontSize = 16.sp,
            fontFamily = Urbanist_font,
            fontWeight = FontWeight.Medium,
            lineHeight = 16.sp,
            letterSpacing = 0.25.sp,
            color = switchColorWeatherStatus
        )

        Box(
            modifier = Modifier
                .padding(top = 12.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(switchColorBackGroundRow)
                .padding(horizontal = 24.dp, vertical = 8.dp)
        ) {
            RowTempMaxMin(
                currentDay = currentDay,
                dailyUnit = dailyUnit,
                color = switchColorRowTemperature,
            )
        }
    }
}


