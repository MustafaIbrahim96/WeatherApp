import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafa.weatherapp.R
import com.mustafa.weatherapp.domain.entity.DailyWeatherData
import com.mustafa.weatherapp.domain.entity.DailyWeatherUnit
import com.mustafa.weatherapp.ui.theme.BigTitle24AColor
import com.mustafa.weatherapp.ui.theme.BigTitle60AColor
import com.mustafa.weatherapp.ui.theme.Urbanist_font

@Composable
fun RowTempMaxMin(currentDay: DailyWeatherData, DailyUnit: DailyWeatherUnit,color:Color) {


    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(R.drawable.ic_arrow_up),
            contentDescription = "icon arrow up",
            tint = color
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            "${currentDay.maxTemp}"
                    + DailyUnit.temperature2mMax,
            fontSize = 16.sp,
            fontFamily = Urbanist_font,
            fontWeight = FontWeight.Medium,
            lineHeight = TextUnit.Unspecified,
            letterSpacing = 0.25.sp,
            color = color
        )
        Spacer(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .height(14.dp)
                .width(1.dp)
                .background(BigTitle24AColor)
        )
        Icon(
            painter = painterResource(R.drawable.ic_arrow_down),
            contentDescription = "icon arrow down",
            tint = color
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            "${currentDay.minTemp}"
                    + DailyUnit.temperature2mMax,
            fontSize = 16.sp,
            fontFamily = Urbanist_font,
            fontWeight = FontWeight.Medium,
            lineHeight = TextUnit.Unspecified,
            letterSpacing = 0.25.sp,
            color = color
        )
    }
}