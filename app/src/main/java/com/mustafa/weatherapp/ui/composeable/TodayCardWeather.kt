package com.mustafa.weatherapp.ui.composeable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafa.weatherapp.domain.entity.HourlyWeatherData
import com.mustafa.weatherapp.domain.entity.HourlyWeatherUnit
import com.mustafa.weatherapp.ui.theme.BigTitle60AColor
import com.mustafa.weatherapp.ui.theme.BigTitle70AColor
import com.mustafa.weatherapp.ui.theme.BigTitle87AColor
import com.mustafa.weatherapp.ui.theme.BorderCard
import com.mustafa.weatherapp.ui.theme.Urbanist_font
import com.mustafa.weatherapp.ui.theme.WhIte70AColor
import com.mustafa.weatherapp.ui.theme.White08AColor
import com.mustafa.weatherapp.ui.theme.White60AColor
import com.mustafa.weatherapp.ui.theme.White87AColor

@Composable
fun TodayCardWeather(
    hourly: HourlyWeatherData,
    hourlyWeatherUnit: HourlyWeatherUnit,
    isDay: Boolean,
) {

    val colorCardBackGround = if (isDay) WhIte70AColor else BigTitle70AColor
    val colorCardBorder = if (isDay) BorderCard else White08AColor
    val textTemperatureColor = if (isDay) BigTitle87AColor else White87AColor
    val textHourColor = if (isDay) BigTitle60AColor else White60AColor


    Box {
        Box(
            modifier = Modifier
                .padding(top = 12.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(colorCardBackGround)
                .border(width = 1.dp, color = colorCardBorder,shape = RoundedCornerShape(20.dp))
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
                    text = "${hourly.temp} ${hourlyWeatherUnit.temperature2m}",
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    color = textTemperatureColor,
                    fontFamily = Urbanist_font,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 0.25.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier.padding(top = 4.dp,),
                    text = hourly.date.split("T")[1],
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    color = textHourColor,
                    fontFamily = Urbanist_font,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 0.25.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        Image(
            painter = painterResource(hourly.weatherCode.getIconResId(isDay)),
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
