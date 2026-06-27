package com.minecraftsound.domain.model

/**
 * A single recorded usage session, from service start to service stop.
 *
 * @param id unique identifier of the session
 * @param startedAtEpochMs epoch milliseconds when the session started
 * @param endedAtEpochMs epoch milliseconds when the session ended, null if still active
 * @param averageLatencyMs average measured latency during the session
 * @param peakInputLevelDb peak microphone input level recorded during the session
 * @param minecraftDetected whether Minecraft Bedrock was detected during this session
 */
data class SessionLog(
    val id: Long = 0L,
    val startedAtEpochMs: Long,
    val endedAtEpochMs: Long?,
    val averageLatencyMs: Long,
    val peakInputLevelDb: Float,
    val minecraftDetected: Boolean
) {
    val durationMs: Long
        get() = (endedAtEpochMs ?: System.currentTimeMillis()) - startedAtEpochMs
}

/**
 * Severity level of an application log entry, used for in app log viewing.
 */
enum class LogLevel {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

/**
 * A single application log entry shown in the Monitoring screen.
 */
data class AppLogEntry(
    val id: Long = 0L,
    val timestampEpochMs: Long,
    val level: LogLevel,
    val tag: String,
    val message: String
)