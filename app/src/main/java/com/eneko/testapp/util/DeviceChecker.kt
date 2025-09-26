package com.eneko.testapp.util

import android.os.Build
import java.io.File


/**
 * In the world of Android app development, security is important.
 * It is essential to ensure the application runs in a secure environment and to protect it from malicious users
 * who might be trying to run the app on rooted and emulators.
 *
 * This is a class for detection checks to enhance its security and reliability.
 */
class DeviceChecker {
    companion object {

        fun isDeviceRooted(): Boolean {
            val superuserApk = File("/system/app/Supperuser.apk")
            val suBinary = File("/system/bin/su")

            return superuserApk.exists() || suBinary.exists()
        }


        fun isDeviceEmulator(): Boolean {

            return ((Build.FINGERPRINT.startsWith("google/sdk_gphone_")
                    && Build.FINGERPRINT.endsWith(":user/release-keys")
                    && Build.MANUFACTURER == "Google" && Build.PRODUCT.startsWith("sdk_gphone") && Build.BRAND == "google"
                    && Build.MODEL.startsWith("sdk_gphone"))
                    || Build.FINGERPRINT.startsWith("generic")
                    || Build.FINGERPRINT.startsWith("unknown")
                    || Build.HARDWARE.contains("goldfish")
                    || Build.HARDWARE.contains("ranchu")
                    || Build.MODEL.contains("google_sdk")
                    || Build.MODEL.contains("Emulator")
                    || Build.MODEL.contains("Android SDK built for x86")
                    || Build.MANUFACTURER.contains("Genymotion")
                    || Build.HOST == "Build2" //MSI App Player
                    || Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")
                    || Build.PRODUCT.contains("sdk_google")
                    || Build.PRODUCT == "google_sdk"
                    || Build.PRODUCT.contains("sdk")
                    || Build.PRODUCT.contains("sdk_x86")
                    || Build.PRODUCT.contains("vbox86p")
                    || Build.PRODUCT.contains("emulator")
                    || Build.PRODUCT.contains("simulator"))
        }

        //for testing
        internal fun isDeviceRooted(fileExists: (String) -> Boolean): Boolean {
            val superuserApk = "/system/app/Superuser.apk"
            val suBinary = "/system/bin/su"
            return fileExists(superuserApk) || fileExists(suBinary)
        }

    }
}