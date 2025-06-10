package com.mustafa.weatherapp.ui.composeable

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafa.weatherapp.R
import com.mustafa.weatherapp.ui.theme.CityColor
import com.mustafa.weatherapp.ui.theme.Urbanist_font
import com.mustafa.weatherapp.ui.viewModel.state.WeatherUiState
import org.example.domain.model.entity.weather.WeatherCondition

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun HeaderAfterScroll(weatherUiState: WeatherUiState) {

    val isDay = weatherUiState.weather.currentWeather.isDay
    val weatherCode = weatherUiState.weather.currentWeather.weatherCode

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(24.dp))
        Row {
            Icon(
                painter = painterResource(R.drawable.ic_location),
                contentDescription = "location icon",
                tint = CityColor
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = weatherUiState.weather.timeZone,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                color = CityColor,
                fontFamily = Urbanist_font,
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.25.sp

            )
        }
        Box(modifier = Modifier) {
            SoftBlurredGlow(modifier = Modifier.size(150.dp), circleSize = 150.dp, radius = 150f)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painterResource(
                        id = weatherCode.getIconResId(isDay)
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(140.dp)
                        .width(132.dp)

                )
                DailyTempColumn(
                    modifier = Modifier.padding(top = 6.dp),
                    weatherUiState = weatherUiState
                )
            }
        }
    }
}