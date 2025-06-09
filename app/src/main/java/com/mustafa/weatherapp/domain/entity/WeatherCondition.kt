package org.example.domain.model.entity.weather

import com.mustafa.weatherapp.R

enum class WeatherCondition(val displayName: String) {

    CLEAR_SKY("Clear sky") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_clear_sky_day else R.drawable.img_clear_sky_night
        }
    },

    MAINLY_CLEAR("Mainly clear") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_mainly_clear_day else R.drawable.img_mainly_clear_night
        }
    },
    PARTLY_CLOUDY("Partly cloudy") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_partly_cloudy_day else R.drawable.img_partly_cloudy_night
        }
    },
    OVERCAST("Overcast") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_overcast_day else R.drawable.img_overcast_night
        }
    },

    FOG("Fog") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_fog_day else R.drawable.img_fog_night
        }
    },
    DEPOSITING_RIME_FOG("Depositing rime fog") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_depositing_rime_fog_day else R.drawable.img_depositing_rime_fog_night
        }
    },

    DRIZZLE_LIGHT("Drizzle: Light intensity") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_drizzle_light_day else R.drawable.img_drizzle_light_night
        }
    },
    DRIZZLE_MODERATE("Drizzle: Moderate intensity") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_drizzle_moderate_day else R.drawable.img_drizzle_moderate_night
        }
    },
    DRIZZLE_DENSE("Drizzle: Dense intensity") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_drizzle_intensity_day else R.drawable.img_drizzle_intensity_night
        }
    },

    FREEZING_DRIZZLE_LIGHT("Freezing Drizzle: Light intensity") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_freezing_drizzle_light_day else R.drawable.img_freezing_drizzle_light_night
        }
    },
    FREEZING_DRIZZLE_DENSE("Freezing Drizzle: Dense intensity") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_freezing_drizzle_intensity_day else R.drawable.img_freezing_drizzle_intensity_night
        }
    },

    RAIN_SLIGHT("Rain: Slight intensity") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_rain_slight_day else R.drawable.img_rain_slight_night
        }
    },
    RAIN_MODERATE("Rain: Moderate intensity") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_rain_moderate_day else R.drawable.img_rain_moderate_night
        }
    },
    RAIN_HEAVY("Rain: Heavy intensity") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_rain_intensity_day else R.drawable.img_rain_intensity_night
        }
    },

    FREEZING_RAIN_LIGHT("Freezing Rain: Light intensity") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_freezing_loght_day else R.drawable.img_freezing_light_night
        }
    },
    FREEZING_RAIN_HEAVY("Freezing Rain: Heavy intensity") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_freezing_heavy_day else R.drawable.img_freezing_heavy_night
        }
    },

    SNOW_SLIGHT("Snow fall: Slight intensity") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_snow_fall_light_day else R.drawable.img_snow_fall_light_night
        }
    },
    SNOW_MODERATE("Snow fall: Moderate intensity") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_snow_fall_moderate_day else R.drawable.img_snow_fall_moderate_night
        }
    },
    SNOW_HEAVY("Snow fall: Heavy intensity") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_snow_fall_intensity_day else R.drawable.img_snow_fall_intensity_night
        }
    },

    SNOW_GRAINS("Snow grains") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_snow_grains_day else R.drawable.img_snow_grains_night
        }
    },

    RAIN_SHOWERS_SLIGHT("Rain showers: Slight intensity") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_rain_shower_slight_day else R.drawable.img_rain_shower_slight_night
        }
    },
    RAIN_SHOWERS_MODERATE("Rain showers: Moderate intensity") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_rain_shower_moderate_day else R.drawable.img_rain_shower_moderate_night
        }
    },
    RAIN_SHOWERS_VIOLENT("Rain showers: Violent intensity") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_rain_shower_violent_day else R.drawable.img_rain_shower_violent_night
        }
    },

    SNOW_SHOWERS_SLIGHT("Snow showers: Slight intensity") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_snow_shower_slight_day else R.drawable.img_snow_shower_slight_night
        }
    },
    SNOW_SHOWERS_HEAVY("Snow showers: Heavy intensity") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_snow_shower_heavy_day else R.drawable.img_snow_shower_heavy_night
        }
    },
    THUNDERSTORM_SLIGHT("Thunderstorm: Slight or moderate") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_thunderstrom_slight_or_moderate_day else R.drawable.img_thunderstrom_slight_or_moderate_night
        }
    },
    THUNDERSTORM_WITH_HAIL_SLIGHT("Thunderstorm with slight hail") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_thunderstrom_with_slight_hail_day else R.drawable.img_thunderstrom_with_slight_hail_night
        }
    },
    THUNDERSTORM_WITH_HAIL_HEAVY("Thunderstorm with heavy hail") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.drawable.img_thunderstrom_with_heavy_hail_day else R.drawable.img_thunder_strom_with_heavy_hail_night
        }
    },
    UNKNOWN("Unknown weather condition") {
        override fun getIconResId(isDay: Boolean): Int {
            return if (isDay) R.color.white else R.color.white
        }
    };

    abstract fun getIconResId(isDay: Boolean): Int
}