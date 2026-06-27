package com.minecraftsound.domain.repository

import com.minecraftsound.domain.model.AppSettings
import com.minecraftsound.domain.model.ExportedProfile
import kotlinx.coroutines.flow.Flow

/**
 * Abstraction over persisted user settings.
 */
interface SettingsRepository {

    val settings: Flow<AppSettings>

    suspend fun updateSettings(transform: (AppSettings) -> AppSettings)

    suspend fun exportProfile(): ExportedProfile

    suspend fun importProfile(profile: ExportedProfile)
}