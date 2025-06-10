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
import com.mustafa.weatherapp.ui.theme.Urbanist_font
import com.mustafa.weatherapp.ui.viewModel.state.WeatherUiState

@Composable
fun DailyTempColumn(modifier: Modifier, weatherUiState: WeatherUiState) {
    val currentDay = weatherUiState.weather.dailyWeather.days[0]
    val dailyUnit = weatherUiState.weather.dailyWeatherUnit
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            "${weatherUiState.weather.currentWeather.temperature2m}" +
                    weatherUiState.weather.currentWeatherUnit.temperature2m, fontSize = 64.sp,
            fontFamily = Urbanist_font,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 64.sp,
            letterSpacing = 0.25.sp,
            color = BigTitleColor
        )

        Text(
            weatherUiState.weather.currentWeather.weatherCode.displayName,
            fontSize = 16.sp,
            fontFamily = Urbanist_font,
            fontWeight = FontWeight.Medium,
            lineHeight = 16.sp,
            letterSpacing = 0.25.sp,
            color = BigTitle60AColor
        )

        Box(
            modifier = Modifier
                .padding(top = 12.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(BigTitle14AColor)
                .padding(horizontal = 24.dp, vertical = 8.dp)
        ) {
            RowTempMaxMin(currentDay,dailyUnit,BigTitle60AColor)
        }
    }
}


