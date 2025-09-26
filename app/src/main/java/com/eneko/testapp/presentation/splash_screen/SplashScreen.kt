package com.eneko.testapp.presentation.splash_screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.eneko.testapp.R
import com.eneko.testapp.ui.theme.Background
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onAnimationComplete: () -> Unit) {

    // Animaciones
    val alpha = remember { Animatable(0f) }
    val scale = remember { Animatable(0.8f) }
    val rotation = remember { Animatable(0f) }

    // Animación infinita para el logo
    val infiniteTransition = rememberInfiniteTransition(label = "infinite")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "pulse"
    )

    // Iniciar animaciones al cargar el composable
    LaunchedEffect(Unit) {
        // Animación de entrada
        alpha.animateTo(1f, animationSpec = tween(1000))
        scale.animateTo(1f, animationSpec = tween(1000))

        // Animación de rotación continua
        rotation.animateTo(
            targetValue = 360f,
            animationSpec = tween(2000, easing = LinearEasing)
        )

        // Esperar 3 segundos y completar
        delay(3000)

        // Animación de salida
        alpha.animateTo(0f, animationSpec = tween(1000))

        onAnimationComplete()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background), // Color de fondo
        contentAlignment = Alignment.Center
    ) {
        // Logo con múltiples animaciones
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "App Logo",
            modifier = Modifier
                .size(120.dp)
                .scale(scale.value * pulseScale) // Combinar dos animaciones de escala
                .rotate(rotation.value) // Rotación continua
                .alpha(alpha.value) // Animación de desvanecimiento
        )
    }
}