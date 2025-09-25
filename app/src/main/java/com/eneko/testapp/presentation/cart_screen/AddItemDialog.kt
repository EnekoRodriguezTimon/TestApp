package com.eneko.testapp.presentation.cart_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.eneko.testapp.R

@Composable
fun AddItemDialog(
    onDismiss: () -> Unit,
    onAdd: (name: String, quantity: Int) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var quantityText by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { stringResource(R.string.add_item) },
        text = {
            Column {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text(stringResource(R.string.name)) },
                    singleLine = true
                )
                OutlinedTextField(
                    value = quantityText,
                    onValueChange = { quantityText = it.filter { c -> c.isDigit() } },
                    label = { Text(stringResource(R.string.quantity)) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
        },
        confirmButton = {
                Button(
                    onClick = {
                        val quantity = quantityText.toIntOrNull() ?: 0
                        onAdd(name, quantity)
                        onDismiss()
                    },
                    enabled = quantityText.isNotEmpty() && name.isNotEmpty()
                ) {
                    Text(stringResource(R.string.add))
                }
        },
        dismissButton = {
            OutlinedButton(onClick = onDismiss) {
                Text(stringResource(R.string.cancel))
            }
        }
    )
}