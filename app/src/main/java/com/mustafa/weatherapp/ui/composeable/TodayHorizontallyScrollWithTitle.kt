package com.mustafa.weatherapp.ui.composeable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafa.weatherapp.domain.entity.HourlyWeatherData
import com.mustafa.weatherapp.domain.entity.HourlyWeatherUnit
import com.mustafa.weatherapp.ui.theme.BackgroundBottomBrushDay
import com.mustafa.weatherapp.ui.theme.BigTitleColor
import com.mustafa.weatherapp.ui.theme.Urbanist_font
import com.mustafa.weatherapp.ui.theme.White87AColor

@Composable
fun TodayHorizontallyScrollWithTitle(
    hourlyWeather: List<HourlyWeatherData>,
    hourlyWeatherUnit: HourlyWeatherUnit,
    isDay: Boolean
) {
    val titleColor = if(isDay) BigTitleColor  else BackgroundBottomBrushDay

    Text(
        modifier = Modifier.padding(start = 12.dp, top = 24.dp, bottom = 12.dp),
        text = "Today",
        fontSize = 20.sp,
        lineHeight = 20.sp,
        color = titleColor,
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
        color = titleColor,
        fontFamily = Urbanist_font,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.25.sp
    )
}