package com.mustafa.weatherapp.ui.composeable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mustafa.weatherapp.ui.theme.bluerColor

@Composable
fun SoftGlowEffect(
    modifier: Modifier = Modifier,
    color: Color = bluerColor,
    radius: Float
) {
    Canvas(modifier = modifier) {
        drawCircle(
            color = color.copy(alpha = 0.32f),
            radius = radius,
            center = center,
            blendMode = BlendMode.SrcOver
        )
    }
}