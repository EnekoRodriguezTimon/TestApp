package com.eneko.testapp

import com.eneko.testapp.util.DeviceChecker
import org.junit.Test

import org.junit.Assert.*
class DeviceCheckerUnitTest {
    @Test
    fun `isDeviceRooted returns true if su exists`() {
        val result = DeviceChecker.isDeviceRooted { path -> path == "/system/bin/su" }
        assertTrue(result)
    }

    @Test
    fun `isDeviceRooted returns false if no su or superuser apk`() {
        val result = DeviceChecker.isDeviceRooted { false }
        assertFalse(result)
    }
}