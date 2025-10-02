package com.eneko.testapp.presentation.breeds_details_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.eneko.testapp.R
import com.eneko.testapp.core.navigation.SettingsInfo
import com.eneko.testapp.presentation.util.components.MyTopAppBar


@Composable
fun BreedsDetailsScreen(
    breedName: String,
    navigateToSettings: (infoSettings: SettingsInfo) -> Unit,
    navigateBack: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyTopAppBar(
                title = "Details",
                onActionClick = { navigateToSettings(SettingsInfo("user", 1, true)) },
                showIcon = true,
                icon = Icons.Default.Settings
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = stringResource(R.string.selected_breed))
                Text(text = breedName)
            }

            Button(onClick = navigateBack, modifier = Modifier.padding(top = 16.dp)) {
                Text(text = stringResource(R.string.navigate_to_home))
            }
        }
    }
}