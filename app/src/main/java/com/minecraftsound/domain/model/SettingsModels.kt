package com.minecraftsound.domain.model

/**
 * Application theme preference.
 */
enum class AppTheme {
    LIGHT,
    DARK,
    FOLLOW_SYSTEM
}

/**
 * Supported in app languages. FOLLOW_SYSTEM defers to the Android system locale.
 */
enum class AppLanguage {
    INDONESIAN,
    ENGLISH,
    FOLLOW_SYSTEM
}

/**
 * Complete user configurable settings, persisted via DataStore and
 * serializable for the Export Profile and Import Profile features.
 *
 * @param theme selected app theme
 * @param language selected app language
 * @param performanceMode active performance trade off mode
 * @param lowLatencyModeEnabled whether the audio engine runs in low latency mode
 * @param noiseSuppressionEnabled whether noise suppression is applied
 * @param echoCancellationEnabled whether echo cancellation is applied
 * @param voiceActivationEnabled whether voice activation gating is enabled
 * @param voiceActivationThresholdDb input level threshold in decibels used for voice activation
 * @param minecraftAutoDetectEnabled whether automatic Minecraft Bedrock detection is enabled
 * @param overlayEnabled whether the floating microphone status overlay is enabled
 * @param apiEnabled whether the local REST and WebSocket API is enabled
 * @param apiPort port used by the local REST and WebSocket server
 * @param developerModeEnabled whether the Developer Mode page is visible
 */
data class AppSettings(
    val theme: AppTheme = AppTheme.FOLLOW_SYSTEM,
    val language: AppLanguage = AppLanguage.FOLLOW_SYSTEM,
    val performanceMode: PerformanceMode = PerformanceMode.BALANCED,
    val lowLatencyModeEnabled: Boolean = true,
    val noiseSuppressionEnabled: Boolean = true,
    val echoCancellationEnabled: Boolean = true,
    val voiceActivationEnabled: Boolean = true,
    val voiceActivationThresholdDb: Float = -35f,
    val minecraftAutoDetectEnabled: Boolean = true,
    val overlayEnabled: Boolean = true,
    val apiEnabled: Boolean = true,
    val apiPort: Int = 8765,
    val developerModeEnabled: Boolean = false
)

/**
 * Serializable container used by Export Profile and Import Profile,
 * bundling settings together with a schema version for forward compatibility.
 */
data class ExportedProfile(
    val schemaVersion: Int = 1,
    val exportedAtEpochMs: Long,
    val settings: AppSettings
)