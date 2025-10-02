package com.eneko.testapp.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.eneko.testapp.R


@Composable
fun HomeScreen(
    navigateToBreeds: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = navigateToBreeds, modifier = Modifier.padding(16.dp)) {
            Text(text = stringResource(R.string.see_breeds))
        }
        Text(modifier = Modifier.padding(16.dp), text = stringResource(R.string.home_description))
    }
}