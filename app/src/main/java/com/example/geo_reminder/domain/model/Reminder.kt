package com.example.geo_reminder.domain.model

data class Reminder(
    val reminderId: String, // Use String instead of Long as Firebase Realtime Database uses String keys
    val title: String,
    val body: String,
    val placeId: String, // Use String instead of Long as Firebase Realtime Database uses String keys
    val isActive: Boolean
)


