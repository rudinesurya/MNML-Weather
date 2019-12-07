package com.cookiesmile.mnml_weather.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SavedCity(
        @PrimaryKey var city: String
)