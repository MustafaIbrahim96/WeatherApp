package com.mustafa.weatherapp.ui.composeable

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import com.mustafa.weatherapp.R
import com.mustafa.weatherapp.ui.theme.CityColorDay
import com.mustafa.weatherapp.ui.theme.CityColorNight
import com.mustafa.weatherapp.ui.theme.Urbanist_font
import com.mustafa.weatherapp.ui.theme.bluerColorDay
import com.mustafa.weatherapp.ui.theme.bluerColorNight
import com.mustafa.weatherapp.ui.viewModel.state.WeatherUiState

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun HeaderScroll(
    weatherUiState: WeatherUiState,
    scrollOffset: Float
) {
    val isDay = weatherUiState.weather.currentWeather.isDay
    val weatherCode = weatherUiState.weather.currentWeather.weatherCode
    val tempColumnPadding = getScreenWidthPx(sizePadding = 200)
    val ImagePadding = getScreenWidthPx(sizePadding = 220)

    val imageSize = lerp(220.dp, 124.dp, scrollOffset)

    val animationImageSize by animateDpAsState(
        targetValue = imageSize,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "springOffset"
    )

    val locationTopPadding = lerp(0.dp, 100.dp, scrollOffset)
    val columnTempPaddingTop = lerp(216.dp, 12.dp, scrollOffset)
    val columnTempPaddingEnd = lerp(tempColumnPadding, 12.dp, scrollOffset)
    val columnTempPaddingStart = lerp(tempColumnPadding, 0.dp, scrollOffset)
    val boxImagesPaddingStart = lerp(ImagePadding, 12.dp, scrollOffset)
    val boxImagesPaddingEnd = lerp(ImagePadding, 44.dp, scrollOffset)
    val imagePaddingTop =  lerp(0.dp, 20.dp, scrollOffset)

    val colorBlurSwitch = if (isDay) bluerColorDay else bluerColorNight
    val colorSwitch = if (isDay) CityColorDay else CityColorNight


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(modifier = Modifier.padding(top = locationTopPadding)) {
            Icon(
                painter = painterResource(R.drawable.ic_location),
                contentDescription = "location icon",
                tint = colorSwitch
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = weatherUiState.weather.timeZone,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                color = colorSwitch,
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
                    .padding(
                        end = boxImagesPaddingEnd,
                        start = boxImagesPaddingStart,
                        top = imagePaddingTop
                    )
                    .size(animationImageSize)

            ) {
                SoftBlurredGlow(
                    modifier = Modifier.size(imageSize),
                    circleSize = imageSize,
                    radius = imageSize.value,
                    blurColor = colorBlurSwitch
                )

                Image(
                    painterResource(id = weatherCode.getIconResId(isDay)),
                    contentDescription = null,
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .size(imageSize)
                        .align(Alignment.CenterEnd)

                )
            }

            DailyTempColumn(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(
                        top = columnTempPaddingTop,
                        end = columnTempPaddingEnd,
                        start = columnTempPaddingStart
                    ),
                weatherUiState = weatherUiState
            )
        }
    }
}

@Composable
fun getScreenWidthPx(sizePadding:Int): Dp {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val columnWidth = sizePadding.dp
    val horizontalPadding = (screenWidth - columnWidth) / 2
    return horizontalPadding
}


@Preview
@Composable
private fun HeaderBeforeScrollPreview() {
    //HeaderBeforeScroll()
}