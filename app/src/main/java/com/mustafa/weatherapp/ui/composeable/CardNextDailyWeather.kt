package com.mustafa.weatherapp.ui.composeable

import RowTempMaxMin
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafa.weatherapp.domain.entity.DailyWeatherData
import com.mustafa.weatherapp.domain.entity.DailyWeatherUnit
import com.mustafa.weatherapp.ui.theme.BigTitle60AColor
import com.mustafa.weatherapp.ui.theme.BigTitle87AColor
import com.mustafa.weatherapp.ui.theme.Urbanist_font
import com.mustafa.weatherapp.ui.theme.White60AColor
import com.mustafa.weatherapp.ui.theme.White87AColor

@Composable
fun CardNextDailyWeather(
    daily: DailyWeatherData,
    dailyWeatherUnit: DailyWeatherUnit,
    isDay: Boolean
) {
    val textDayColor = if (isDay) BigTitle60AColor else White60AColor
    val textTemperatureColor = if (isDay) BigTitle87AColor else White87AColor
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            modifier = Modifier.weight(91f),
            text = daily.date,
            fontSize = 16.sp,
            lineHeight = 16.sp,
            color = textDayColor,
            fontFamily = Urbanist_font,
            fontWeight = FontWeight.Normal,
        )

        Box(
            modifier = Modifier
                .height(45.dp)
                .width(91.dp)
                .weight(91f)
        ) {
            Image(
                painter = painterResource(daily.weatherCode.getIconResId(true
                )),
                contentDescription = "Image Weather",
                modifier = Modifier
                    .align(Alignment.Center),
            )
        }

        RowTempMaxMin(
            modifier = Modifier.weight(103f),
            currentDay = daily,
            dailyUnit = dailyWeatherUnit,
            color = textTemperatureColor,
            iconSize = 12,
            fontSize = 14,
            iconPadding = 2,
            spacerPadding = 4
        )

    }
}