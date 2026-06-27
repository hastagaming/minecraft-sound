# Ktor
-keep class io.ktor.** { *; }
-keep class kotlinx.coroutines.** { *; }
-dontwarn io.ktor.**

# Kotlinx Serialization
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.AnnotationsKt
-keepclassmembers class kotlinx.serialization.json.** {
    *** Companion;
}
-keepclasseswithmembers class **
    where @kotlinx.serialization.Serializable

# Room
-keep class androidx.room.** { *; }

# Vosk / JNA
-keep class com.sun.jna.** { *; }
-keepclassmembers class * extends com.sun.jna.Structure { public *; }
-keep class org.vosk.** { *; }
-dontwarn org.vosk.**
-dontwarn com.sun.jna.**

# QuickJS
-keep class com.whl.quickjs.** { *; }
-dontwarn com.whl.quickjs.**

# Hilt
-keep class dagger.hilt.** { *; }
-keep class * extends dagger.hilt.android.HiltAndroidApp

# General
-keepattributes Signature
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable