package com.eneko.testapp.presentation.cart_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.eneko.testapp.R
import com.eneko.testapp.presentation.util.components.MyTopAppBar
import com.eneko.testapp.presentation.util.components.ResultDialog


@Composable
fun CartScreen(
    cartViewModel: CartViewModel = hiltViewModel()
) {
    var showAddDialog by remember { mutableStateOf(false) }
    val showResultDialog by cartViewModel.showResultDialog.collectAsState()
    val isSuccessDialog by cartViewModel.isSuccessResultDialog.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { MyTopAppBar(stringResource(R.string.cart_title)) }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ItemTable(cartViewModel, showAddDialog = { showAddDialog = true })
            }
        }
        ResultDialog(
            isSuccess = isSuccessDialog,
            visible = showResultDialog,
            onDismiss = { cartViewModel.hideResultDialog() },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }

    if (showAddDialog) {
        AddItemDialog(
            onDismiss = { showAddDialog = false },
            onAdd = { name, quantity ->
                cartViewModel.addItem(name, quantity)
                showAddDialog = false
            }
        )
    }
}

@Composable
fun ItemTable(viewModel: CartViewModel, showAddDialog: () -> Unit) {
    val items by viewModel.items.collectAsState()
    Button(onClick = showAddDialog) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(R.string.add_item)
        )
    }
    if(items.isEmpty()){
        Text(text = stringResource(R.string.add_item))
    }else {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = stringResource(R.string.name), style = MaterialTheme.typography.titleMedium)
                    Text(text = stringResource(R.string.quantity), style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.width(40.dp))
                }
            }

            items(items) { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(item.name, modifier = Modifier.weight(1f))
                    Text(text = item.quantity.toString(), modifier = Modifier.weight(1f))

                    IconButton(onClick = { viewModel.deleteItem(item) }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = stringResource(R.string.delete)
                        )
                    }
                }
                HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
            }
        }
    }
}
