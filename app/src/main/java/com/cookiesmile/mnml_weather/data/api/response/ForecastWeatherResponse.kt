package com.cookiesmile.mnml_weather.data.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForecastWeatherResponse(
        val city: City,
        val cnt: Long, // 40
        val cod: String, // 200
        val list: List<ListItem>
) {
    @JsonClass(generateAdapter = true)
    data class City(
            val coord: Coord,
            val country: String, // GB
            val id: Long, // 2643743
            val name: String, // London
            val population: Long?, // 1000000
            val sunrise: Long, // 1572764206
            val sunset: Long, // 1572798676
            val timezone: Long // 0
    ) {
        @JsonClass(generateAdapter = true)
        data class Coord(
                val lat: Double, // 51.5085
                val lon: Double // -0.1258
        )
    }

    @JsonClass(generateAdapter = true)
    data class ListItem(
            val clouds: Clouds,
            val dt: Long, // 1573225200
            @Json(name = "dt_txt")
            val dtTxt: String, // 2019-11-08 15:00:00
            val main: Main,
            val rain: Rain?,
            val sys: Sys,
            val weather: List<Weather>,
            val wind: Wind
    ) {
        @JsonClass(generateAdapter = true)
        data class Clouds(
                val all: Double // 11
        )

        @JsonClass(generateAdapter = true)
        data class Main(
                @Json(name = "grnd_level")
                val grndLevel: Double, // 1003
                val humidity: Double, // 65
                val pressure: Double, // 1007
                @Json(name = "sea_level")
                val seaLevel: Double, // 1007
                val temp: Double, // 282.97
                @Json(name = "temp_kf")
                val tempKf: Double, // 0
                @Json(name = "temp_max")
                val tempMax: Double, // 282.97
                @Json(name = "temp_min")
                val tempMin: Double // 282.97
        )

        @JsonClass(generateAdapter = true)
        data class Rain(
                @Json(name = "3h")
                val _3h: Double // 0.06
        )

        @JsonClass(generateAdapter = true)
        data class Sys(
                val pod: String // d
        )

        @JsonClass(generateAdapter = true)
        data class Weather(
                val description: String, // few clouds
                val icon: String, // 02d
                val id: Long, // 801
                val main: String // Clouds
        )

        @JsonClass(generateAdapter = true)
        data class Wind(
                val deg: Double, // 89
                val speed: Double // 2.43
        )
    }
}