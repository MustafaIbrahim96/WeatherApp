package com.mustafa.weatherapp.ui.composeable

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun SoftBlurredGlow(modifier: Modifier,circleSize : Dp,radius:Float,blurColor: Color) {
    Box(
        modifier = modifier
            .graphicsLayer {
                renderEffect = RenderEffect
                    .createBlurEffect(90f, 90f, Shader.TileMode.CLAMP)
                    .asComposeRenderEffect()
            }
    ) {
        SoftGlowEffect(
            modifier = Modifier.size(circleSize),
            radius =  radius,
            color = blurColor
        )
    }
}