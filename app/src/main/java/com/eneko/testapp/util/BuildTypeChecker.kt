package com.eneko.testapp.util
import com.eneko.testapp.BuildConfig


class BuildTypeChecker {
    companion object {
        fun isDebug(): Boolean {
            return BuildConfig.BUILD_TYPE.contains("debug")
        }

    }
}