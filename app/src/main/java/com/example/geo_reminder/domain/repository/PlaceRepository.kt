package com.example.geo_reminder.domain.repository

import com.example.geo_reminder.domain.model.Place
import kotlinx.coroutines.flow.Flow

interface PlaceRepository {
    suspend fun getPlaces(): Flow<List<Place>>
    suspend fun getPlaceById(id: String): Place?
    suspend fun insertPlace(place: Place)
    suspend fun deletePlace(place: Place)
}