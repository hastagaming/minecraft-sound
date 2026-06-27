package com.minecraftsound.domain.model

/**
 * Represents the lifecycle state of the foreground audio service.
 */
enum class ServiceState {
    STOPPED,
    STARTING,
    RUNNING,
    STOPPING
}

/**
 * Represents whether Minecraft Bedrock Edition is currently detected as running.
 */
enum class MinecraftState {
    NOT_RUNNING,
    RUNNING,
    UNKNOWN
}

/**
 * Aggregated status used to drive the Home screen and the API status endpoint.
 */
data class AppStatus(
    val serviceState: ServiceState,
    val minecraftState: MinecraftState,
    val audioStatus: AudioStatus,
    val apiRunning: Boolean,
    val apiPort: Int,
    val performanceMode: PerformanceMode
)

/**
 * Performance trade off profile applied across the audio engine and service.
 */
enum class PerformanceMode {
    BATTERY_SAVER,
    BALANCED,
    PERFORMANCE
}