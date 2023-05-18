package com.example.geo_reminder.data.data_source

import com.example.geo_reminder.domain.model.Place
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class PlaceDao (private val database: FirebaseDatabase) {

    private val placesRef = database.getReference("notes")

    suspend fun getPlaces(): Flow<List<Place>> = callbackFlow {
        val placesListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val places = snapshot.children.mapNotNull { it.getValue(Place::class.java) }
                trySend(places)
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle the cancellation or error if needed
                close(error.toException())
            }
        }

        placesRef.addValueEventListener(placesListener)

        // Cancel the listener when the flow is no longer collected
        awaitClose { placesRef.removeEventListener(placesListener) }
    }


    suspend fun getPlaceById(placeId: String): Place? {
        return placesRef.child(placeId).get().await().getValue(Place::class.java)
    }

    suspend fun insertPlace(place: Place) {
        placesRef.child(place.placeId).setValue(place)
    }

    suspend fun deleteNote(place: Place) {
        placesRef.child(place.placeId).removeValue()
    }
}
