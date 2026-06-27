package com.minecraftsound.domain.model

/**
 * Metadata describing a plugin, parsed from its plugin.json file.
 *
 * @param id unique plugin identifier, typically reverse domain style
 * @param name human readable plugin name
 * @param version semantic version string of the plugin
 * @param author plugin author name
 * @param description short description shown in the Plugins screen
 * @param main relative path to the plugin entry JavaScript file inside voice/
 * @param permissions list of permissions requested by the plugin
 * @param minHostVersion minimum minecraft-sound app version required to run this plugin
 * @param repositoryUrl optional GitHub repository URL the plugin was imported from
 * @param updateUrl optional URL used by Auto Update Plugin API to check for new versions
 */
data class PluginManifest(
    val id: String,
    val name: String,
    val version: String,
    val author: String,
    val description: String,
    val main: String,
    val permissions: List<PluginPermission>,
    val minHostVersion: String,
    val repositoryUrl: String?,
    val updateUrl: String?
)

/**
 * A permission that a plugin can request. The sandbox only exposes the
 * corresponding host API surface when the user has granted the permission.
 */
enum class PluginPermission {
    AUDIO_READ,
    VOICE_EVENTS,
    NETWORK,
    FILESYSTEM_READ,
    NOTIFICATION
}

/**
 * Installation and runtime state of a plugin as tracked by PluginManager.
 *
 * @param manifest parsed plugin metadata
 * @param installedAtEpochMs epoch milliseconds when the plugin was installed
 * @param isEnabled whether the plugin is currently enabled
 * @param grantedPermissions permissions explicitly granted by the user
 * @param sourceType where the plugin was imported from
 * @param localPath absolute path to the plugin directory on device storage
 */
data class InstalledPlugin(
    val manifest: PluginManifest,
    val installedAtEpochMs: Long,
    val isEnabled: Boolean,
    val grantedPermissions: Set<PluginPermission>,
    val sourceType: PluginSourceType,
    val localPath: String
)

/**
 * Origin of an installed plugin, used to determine update strategy.
 */
enum class PluginSourceType {
    GITHUB_REPOSITORY,
    LOCAL_FILE
}

/**
 * Result of validating a plugin folder structure and manifest.
 */
sealed class PluginValidationResult {
    data object Valid : PluginValidationResult()
    data class Invalid(val reason: String) : PluginValidationResult()
}

/**
 * Result of checking a plugin against its update source.
 */
sealed class PluginUpdateCheckResult {
    data object UpToDate : PluginUpdateCheckResult()
    data class UpdateAvailable(val newVersion: String, val downloadUrl: String) : PluginUpdateCheckResult()
    data class CheckFailed(val reason: String) : PluginUpdateCheckResult()
}