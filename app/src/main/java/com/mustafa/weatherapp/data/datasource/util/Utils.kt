package com.mustafa.weatherapp.data.datasource.util

import kotlinx.datetime.*
import kotlinx.datetime.TimeZone
import kotlinx.datetime.Clock

fun getDayName(dateString: String): String {
    val date = LocalDate.parse(dateString)
    return date.dayOfWeek.name.lowercase().replaceFirstChar { it.uppercase() }
}

fun getCurrentDateFormatted(): LocalDate = Clock.System.todayIn(TimeZone.currentSystemDefault())
