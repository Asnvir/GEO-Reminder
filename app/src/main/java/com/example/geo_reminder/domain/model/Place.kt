package com.example.geo_reminder.domain.model

data class Place(
    val placeId: String, // Use String instead of Long as Firebase Realtime Database uses String keys
    val name: String,
    val latitude: Double,
    val longitude: Double
)
