package com.cookiesmile.mnml_weather.data.model

data class ForecastWeather(val id: Long,
                           val date: String,
                           val temp: Double,
                           val condition: String,
                           val icon: String
)