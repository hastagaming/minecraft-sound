package com.minecraftsound.domain.model

/**
 * Represents the current operational state of the audio engine.
 */
enum class AudioState {
    IDLE,
    STARTING,
    RUNNING,
    MUTED,
    STOPPING,
    ERROR
}

/**
 * Represents whether voice activity is currently detected by the VAD module.
 */
enum class VoiceActivityState {
    SILENT,
    SPEAKING
}

/**
 * Snapshot of the audio engine at a given moment, used by both the UI
 * and the REST API status endpoint.
 *
 * @param state current high level audio engine state
 * @param voiceActivity current voice activity detection result
 * @param isMuted whether the microphone is muted by the user
 * @param inputLevelDb current microphone input level in decibels, used for UI meter only
 * @param latencyMs measured round trip audio processing latency in milliseconds
 * @param sampleRateHz active sample rate used by the audio engine
 */
data class AudioStatus(
    val state: AudioState,
    val voiceActivity: VoiceActivityState,
    val isMuted: Boolean,
    val inputLevelDb: Float,
    val latencyMs: Long,
    val sampleRateHz: Int
)