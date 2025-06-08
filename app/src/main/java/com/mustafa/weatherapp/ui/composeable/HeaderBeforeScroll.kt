package com.mustafa.weatherapp.ui.composeable

import android.graphics.RenderEffect
import android.graphics.RenderEffect.createBlurEffect
import android.graphics.Shader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafa.weatherapp.R
import com.mustafa.weatherapp.ui.theme.BigTitle60AColor
import com.mustafa.weatherapp.ui.theme.BigTitleColor
import com.mustafa.weatherapp.ui.theme.CityColor
import com.mustafa.weatherapp.ui.theme.Urbanist_font
import com.mustafa.weatherapp.ui.theme.bluerColor
import com.mustafa.weatherapp.ui.viewModel.state.WeatherUiState

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun HeaderBeforeScroll(weatherUiState: WeatherUiState) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
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
        Row(modifier = Modifier.fillMaxWidth().offset(y = -20.dp)) {
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .size(250.dp)
            ) {
                SoftBlurredGlow()
                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .width(220.dp)
                        .align(Alignment.CenterEnd)
                ) {
                    Image(
                        painterResource(
                            id = R.drawable.img_mainly_clear_day
                        ),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Spacer(modifier = Modifier.weight(2f))

        }
        Text(
            "${weatherUiState.weather.currentWeather.temperature}" +
                    "°C", fontSize = 64.sp,
            fontFamily = Urbanist_font,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 64.sp,
            letterSpacing = 0.25.sp,
            color = BigTitleColor
        )
        Text(
            weatherUiState.weather.currentWeather.weathercode.displayName,
            fontSize = 16.sp,
            fontFamily = Urbanist_font,
            fontWeight = FontWeight.Medium,
            lineHeight = 16.sp,
            letterSpacing = 0.25.sp,
            color = BigTitle60AColor
        )
        Text("↑ 32°C ↓ 20°C", fontSize = 16.sp)
    }
}

@Preview
@Composable
private fun HeaderBeforeScrollPreview() {
    //HeaderBeforeScroll()
}