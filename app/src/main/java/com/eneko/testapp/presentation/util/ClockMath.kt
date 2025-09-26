package com.eneko.testapp.presentation.util

class ClockMath {
    fun calculateHourAngle(hour: Int, minute: Int): Float =
        (hour + minute / 60f) * 30f - 90f
    fun calculateMinuteAngle(second: Int, minute: Int): Float =
        (minute + second / 60f) * 6f - 90f
    fun calculateSecondAngle(second: Int): Float =
        second * 6f - 90f
}