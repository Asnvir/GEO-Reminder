package com.example.geo_reminder.domain.repository

import com.example.geo_reminder.domain.model.Reminder
import kotlinx.coroutines.flow.Flow


interface ReminderRepository {
    fun getReminders(): Flow<List<Reminder>>
    suspend fun getReminderById(id: Long): Reminder?
    suspend fun insertReminder(reminder: Reminder)
    suspend fun deleteReminder(reminder: Reminder)
}