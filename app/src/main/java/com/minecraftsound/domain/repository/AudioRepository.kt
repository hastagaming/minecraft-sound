package com.minecraftsound.domain.repository

import com.minecraftsound.domain.model.AudioStatus
import com.minecraftsound.domain.model.PerformanceMode
import kotlinx.coroutines.flow.Flow

/**
 * Abstraction over the audio engine, exposed to ViewModels and the API layer
 * without leaking implementation details of AudioRecorder or native processing.
 */
interface AudioRepository {

    /** Continuous stream of audio status snapshots. */
    val audioStatus: Flow<AudioStatus>

    /** Continuous stream of raw PCM audio frames for WebSocket streaming and plugins. */
    val audioFrames: Flow<ByteArray>

    suspend fun start()

    suspend fun stop()

    suspend fun mute()

    suspend fun unmute()

    suspend fun setPerformanceMode(mode: PerformanceMode)
}