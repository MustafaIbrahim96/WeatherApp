package com.mustafa.weatherapp.ui.composeable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafa.weatherapp.R
import com.mustafa.weatherapp.ui.theme.BackgroundTopBrush
import com.mustafa.weatherapp.ui.theme.BigTitle60AColor
import com.mustafa.weatherapp.ui.theme.BigTitle87AColor
import com.mustafa.weatherapp.ui.theme.BorderCard
import com.mustafa.weatherapp.ui.theme.Urbanist_font
import com.mustafa.weatherapp.ui.theme.WhIte70AColor

@Composable
fun CardCurrentWeather(
    modifier: Modifier,
    icon: Painter,
    textValue: String,
    textKey: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 3.dp)
            .clip(RoundedCornerShape(26.dp))
            .border(width = 1.dp, color = BorderCard, shape = RoundedCornerShape(26.dp))
            .background(WhIte70AColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = icon,
                contentDescription = "",
                tint = BackgroundTopBrush
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = textValue,
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 20.sp,
                    color = BigTitle87AColor,
                    fontFamily = Urbanist_font,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 0.25.sp
                ),
            )
            Text(
                modifier = Modifier.padding(top = 2.dp),
                text = textKey,
                fontSize = 14.sp,
                lineHeight = 14.sp,
                color = BigTitle60AColor,
                fontFamily = Urbanist_font,
                fontWeight = FontWeight.Normal,
                letterSpacing = 0.25.sp
            )
        }
    }
}

@Preview
@Composable
private fun CardCurrentWeatherPre() {
    CardCurrentWeather(
        Modifier,
        painterResource(id = R.drawable.ic_humidity),
        "50%", "Humidity"
    )
}