package com.mustafa.weatherapp.ui.composeable

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color

@Composable
fun SoftGlowEffect(
    modifier: Modifier = Modifier,
    color: Color,
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