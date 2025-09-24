package com.eneko.testapp.presentation.util.components

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    title: String,
    onActionClick: () -> Unit = {}
){
    TopAppBar(
        title = { Text(text = title) },
        modifier = Modifier.shadow(elevation = 5.dp),
        actions = {
            Image(
                painter = painterResource(id = R.drawable.ic_delete), // This is correct
                contentDescription = "Title Bar",
                modifier = Modifier
                    .width(32.dp)
                    .padding(end = 8.dp)
                    .clickable { onActionClick() }
            )
        }
    )
}