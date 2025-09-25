package com.eneko.testapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = EmeraldDarkPrimary,
    onPrimary = TextOnPrimary,
    secondary = EmeraldDarkSecondary,
    onSecondary = TextOnSecondary,
    tertiary = EmeraldDarkTertiary,
    background = Background,
    surface = Surface,
    error = Error,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
    onTertiary = Success
)

private val LightColorScheme = lightColorScheme(
    primary = EmeraldDarkPrimary,
    onPrimary = TextOnPrimary,
    secondary = EmeraldDarkSecondary,
    onSecondary = TextOnSecondary,
    tertiary = EmeraldDarkTertiary,
    background = Background,
    surface = Surface,
    error = Error,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
    onTertiary = Success
)

@Composable
fun TestAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
