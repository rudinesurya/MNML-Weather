package com.cookiesmile.mnml_weather.data.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentWeatherResponse(
        val base: String, // stations
        val clouds: Clouds,
        val cod: Long, // 200
        val coord: Coord,
        val dt: Long, // 1485789600
        val id: Long, // 2643743
        val main: Main,
        val name: String, // London
        val sys: Sys,
        val visibility: Long, // 10000
        val weather: List<Weather>,
        val wind: Wind
) {
    @JsonClass(generateAdapter = true)
    data class Clouds(
            val all: Double // 90
    )

    @JsonClass(generateAdapter = true)
    data class Coord(
            val lat: Double, // 51.51
            val lon: Double // -0.13
    )

    @JsonClass(generateAdapter = true)
    data class Main(
            val humidity: Double, // 81
            val pressure: Double, // 1012
            val temp: Double, // 280.32
            @Json(name = "temp_max")
            val tempMax: Double, // 281.15
            @Json(name = "temp_min")
            val tempMin: Double // 279.15
    )

    @JsonClass(generateAdapter = true)
    data class Sys(
            val country: String, // GB
            val id: Long, // 5091
            val sunrise: Long, // 1485762037
            val sunset: Long, // 1485794875
            val type: Long // 1
    )

    @JsonClass(generateAdapter = true)
    data class Weather(
            val description: String, // light intensity drizzle
            val icon: String, // 09d
            val id: Long, // 300
            val main: String // Drizzle
    )

    @JsonClass(generateAdapter = true)
    data class Wind(
            val deg: Double, // 80
            val speed: Double // 4.1
    )
}