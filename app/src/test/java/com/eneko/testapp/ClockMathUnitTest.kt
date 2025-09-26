package com.eneko.testapp

import com.eneko.testapp.presentation.util.ClockMath
import org.junit.Test

import org.junit.Assert.*


class ClockMathUnitTest {
    private val clockMath = ClockMath()

    @Test
    fun `hour hand at 3_00 should be 0 degrees`() {
        val angle = clockMath.calculateHourAngle(3, 0)
        assertEquals(0f, angle, 0.0001f)
    }

    @Test
    fun `hour hand at 6_00 should be 90 degrees`() {
        val angle = clockMath.calculateHourAngle(6, 0)
        assertEquals(90f, angle, 0.0001f)
    }

    @Test
    fun `minute hand at 15_00 should be 0 degrees`() {
        val angle = clockMath.calculateMinuteAngle(0, 15)
        assertEquals(0f, angle, 0.0001f)
    }

    @Test
    fun `minute hand at 30_00 should be 90 degrees`() {
        val angle = clockMath.calculateMinuteAngle(0, 30)
        assertEquals(90f, angle, 0.0001f)
    }

    @Test
    fun `second hand at 15 should be 0 degrees`() {
        val angle = clockMath.calculateSecondAngle(15)
        assertEquals(0f, angle, 0.0001f)
    }

    @Test
    fun `second hand at 45 should be 180 degrees`() {
        val angle = clockMath.calculateSecondAngle(45)
        assertEquals(180f, angle, 0.0001f)
    }
}