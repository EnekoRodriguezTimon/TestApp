package com.eneko.testapp.presentation.time_screen

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.hilt.navigation.compose.hiltViewModel
import java.util.Calendar
import java.util.TimeZone
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

@Composable
fun AnalogClock(modifier: Modifier = Modifier, viewModel: ClockViewModel = hiltViewModel<ClockViewModel>()) {
    val calendar = Calendar.getInstance(TimeZone.getDefault()).apply { timeInMillis = viewModel.timeMillis }
    val romanNumbers = listOf("XII","I","II","III","IV","V","VI","VII","VIII","IX","X","XI")


    Canvas(modifier = modifier) {
        val width = size.width
        val height = size.height
        val radius = min(width, height) / 2

        val centerX = width / 2
        val centerY = height / 2

        // Draw sphere
        drawCircle(
            color = Color.Black,
            radius = radius,
            center = Offset(centerX, centerY),
            style = Stroke(width = 10f)
        )
        drawCircle(
            color = Color.LightGray,
            radius = radius,
            center = Offset(centerX, centerY)
        )

       //Draw numbers
        val textRadius = radius * 0.85f // distance from the center

        romanNumbers.forEachIndexed { index, number ->
            val angle = Math.toRadians((index * 30 - 90).toDouble())
            val x = centerX + textRadius * cos(angle).toFloat()
            val y = centerY + textRadius * sin(angle).toFloat()

            drawContext.canvas.nativeCanvas.drawText(
                number,
                x,
                y,
                android.graphics.Paint().apply {
                    color = android.graphics.Color.BLACK
                    textSize = radius * 0.12f
                    textAlign = android.graphics.Paint.Align.CENTER
                }
            )
        }

        val hour = calendar.get(Calendar.HOUR_OF_DAY) % 12
        val minute = calendar.get(Calendar.MINUTE)
        val second = calendar.get(Calendar.SECOND)

        // Calculate angles
        val hourAngle = (hour + minute / 60f) * 30f - 90f
        val minuteAngle = (minute + second / 60f) * 6f - 90f
        val secondAngle = second * 6f - 90f

        //calculate hands
        fun drawHand(angle: Float, length: Float, color: Color, strokeWidth: Float) {
            val rad = Math.toRadians(angle.toDouble())
            drawLine(
                color = color,
                start = Offset(centerX, centerY),
                end = Offset(
                    centerX + length * cos(rad).toFloat(),
                    centerY + length * sin(rad).toFloat()
                ),
                strokeWidth = strokeWidth
            )
        }

        // Draw hands
        drawHand(hourAngle, radius * 0.5f, Color.Black, 8f)
        drawHand(minuteAngle, radius * 0.7f, Color.Black, 5f)
        drawHand(secondAngle, radius * 0.9f, Color.Red, 2f)
    }
}