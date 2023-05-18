package com.example.geo_reminder.di

import android.app.Application
import com.example.geo_reminder.data.data_source.PlaceDao
import com.example.geo_reminder.data.repository.PlaceRepositoryImpl
import com.example.geo_reminder.domain.repository.PlaceRepository
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): FirebaseDatabase {
        return Firebase.database
    }

    @Provides
    @Singleton
    fun provideReminderDao(database: FirebaseDatabase): PlaceDao {
        return PlaceDao(database)
    }

    @Provides
    @Singleton
    fun providePlaceRepository(placeDao: PlaceDao): PlaceRepository {
        return PlaceRepositoryImpl(placeDao)
    }
}