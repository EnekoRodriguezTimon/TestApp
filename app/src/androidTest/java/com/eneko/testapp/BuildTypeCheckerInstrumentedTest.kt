package com.eneko.testapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BuildTypeCheckerAndroidTest {

    @Test
    fun `isDebug returns true or false based on real build type`() {
        assertEquals(BuildTypeChecker().isDebug(), BuildConfig.BUILD_TYPE.contains("debug"))
    }
}
