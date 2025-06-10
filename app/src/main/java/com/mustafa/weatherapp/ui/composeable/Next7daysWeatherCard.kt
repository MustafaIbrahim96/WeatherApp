package com.mustafa.weatherapp.ui.composeable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.mustafa.weatherapp.domain.entity.DailyWeatherData
import com.mustafa.weatherapp.domain.entity.DailyWeatherUnit
import com.mustafa.weatherapp.ui.theme.BigTitle70AColor
import com.mustafa.weatherapp.ui.theme.BorderCard
import com.mustafa.weatherapp.ui.theme.WhIte70AColor
import com.mustafa.weatherapp.ui.theme.White08AColor

@Composable
fun Next7daysWeatherCard(
    dailyWeather: List<DailyWeatherData>,
    dailyWeatherUnit: DailyWeatherUnit,
    isDay: Boolean
) {

    val colorCardBackGround = if (isDay) WhIte70AColor else BigTitle70AColor
    val colorCardBorder = if (isDay) BorderCard else White08AColor

    Box(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .border(
                width = 1.dp,
                color = colorCardBorder,
                shape = RoundedCornerShape(24.dp)
            )
            .background(colorCardBackGround),
    ) {
        Column {
            dailyWeather.forEachIndexed { index, daily ->
                CardNextDailyWeather(daily, dailyWeatherUnit, isDay)

                if (index != dailyWeather.lastIndex) {
                    Spacer(
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth()
                            .background(colorCardBorder)
                    )
                }
            }
        }
    }
}