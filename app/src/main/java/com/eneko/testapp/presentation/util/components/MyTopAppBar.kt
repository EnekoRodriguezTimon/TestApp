package com.eneko.testapp.presentation.util.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    title: String,
    onActionClick: () -> Unit = {},
    showBackArrow: Boolean = false,
) {
    TopAppBar(
        title = {
            Box(
                modifier = Modifier.fillMaxHeight(),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(text = title)
            }
        },
        modifier = Modifier.shadow(elevation = 5.dp),
        actions = {
            if (showBackArrow) {
                Image(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Title Bar",
                    modifier = Modifier
                        .width(32.dp)
                        .padding(end = 8.dp)
                        .clickable { onActionClick() }
                )
            }
        }
    )
}