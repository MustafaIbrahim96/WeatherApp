package com.mustafa.weatherapp.ui.composeable

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafa.weatherapp.R
import com.mustafa.weatherapp.ui.theme.CityColor
import com.mustafa.weatherapp.ui.theme.Urbanist_font
import com.mustafa.weatherapp.ui.viewModel.state.WeatherUiState

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun HeaderScroll(
    weatherUiState: WeatherUiState,
    isScrolled: Boolean
) {
    val isDay = weatherUiState.weather.currentWeather.isDay
    val weatherCode = weatherUiState.weather.currentWeather.weathercode

    // Animation values
    val imageSize by animateDpAsState(
        targetValue = if (isScrolled) 124.dp else 220.dp,
        animationSpec = tween(durationMillis = 3000)
    )
    val locationTopPadding by animateFloatAsState(
        targetValue = if (isScrolled) 24f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )
    val columnTempPaddingTop by animateFloatAsState(
        targetValue = if (isScrolled) 12f else 226f,
        animationSpec = tween(durationMillis = 3000)
    )
    val columnTempPaddingEnd by animateFloatAsState(
        targetValue = if (isScrolled) 12f else 90f,
        animationSpec = tween(durationMillis = 3000)
    )
    val columnTempPaddingStart by animateFloatAsState(
        targetValue = if (isScrolled) 0f else 90f,
        animationSpec = tween(durationMillis = 3000)
    )
    val BoximagesPaddingStart by animateFloatAsState(
        targetValue = if (isScrolled) 12f else 67f,
        animationSpec = tween(durationMillis = 3000)
    )
    val BoximagesPaddingEnd by animateFloatAsState(
        targetValue = if (isScrolled) 44f else 73f,
        animationSpec = tween(durationMillis = 3000)
    )
    val imagePaddingTop by animateFloatAsState(
        targetValue = if (isScrolled) 36f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )


    Column(
        modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(modifier = Modifier.padding(top = locationTopPadding.dp)) {
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

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize()
        ) {

            Box(
                modifier = Modifier
                    .padding(end = BoximagesPaddingEnd.dp, start = BoximagesPaddingStart.dp)
                    .size(imageSize)

            ) {
                SoftBlurredGlow(
                    modifier = Modifier.size(imageSize),
                    circleSize = imageSize,
                    radius = imageSize.value
                )

                Image(
                    painterResource(id = weatherCode.getIconResId(isDay)),
                    contentDescription = null,
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .padding(top = imagePaddingTop.dp)
                        .size(imageSize)
                        .align(Alignment.CenterEnd)

                )
            }

            DailyTempColumn(
                modifier = Modifier
                    .align(if (isScrolled) Alignment.CenterEnd else Alignment.BottomEnd)
                    .padding(
                        top = columnTempPaddingTop.dp,
                        end = columnTempPaddingEnd.dp,
                        start = columnTempPaddingStart.dp
                    ),
                weatherUiState = weatherUiState
            )
        }
    }
}

@Preview
@Composable
private fun HeaderBeforeScrollPreview() {
    //HeaderBeforeScroll()
}