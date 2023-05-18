package com.example.geo_reminder.data.repository

import com.example.geo_reminder.data.data_source.PlaceDao
import com.example.geo_reminder.domain.model.Place
import com.example.geo_reminder.domain.repository.PlaceRepository
import kotlinx.coroutines.flow.Flow

class PlaceRepositoryImpl(
    private val placeDao: PlaceDao
) : PlaceRepository {
    override suspend fun getPlaces(): Flow<List<Place>> {
        return placeDao.getPlaces()
    }

    override suspend fun getPlaceById(id: String): Place? {
        return placeDao.getPlaceById(id)
    }

    override suspend fun insertPlace(place: Place) {
        placeDao.insertPlace(place)
    }

    override suspend fun deletePlace(place: Place) {
        placeDao.deleteNote(place)
    }

}