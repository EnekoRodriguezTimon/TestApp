package com.eneko.testapp.presentation.settings_screen

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eneko.testapp.core.navigation.SettingsInfo
import com.eneko.testapp.presentation.util.components.MyTopAppBar


@Composable
fun SettingsScreen(
    settingsInfo: SettingsInfo
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MyTopAppBar(title = "Settings")}
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .border(
                width = 1.dp,
                color = Color.DarkGray,
                shape = RoundedCornerShape(8.dp)
            )){
                Text(text = "Usuario:")
                Text(text = settingsInfo.name)
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .border(
                width = 1.dp,
                color = Color.DarkGray,
                shape = RoundedCornerShape(8.dp)
            )){
                Text(text = "ID:")
                Text(text = settingsInfo.id.toString())
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.DarkGray,
                    shape = RoundedCornerShape(8.dp)
                )){
                Text(text = "DarkMode:")
                Text(text = if (settingsInfo.darkMode) "Modo Oscuro" else "Modo Claro")
            }
            Button(onClick = {}) {
                Text(text = "Volver")
            }
        }
    }
}