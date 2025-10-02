package com.eneko.testapp.presentation.cart_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.eneko.testapp.R
import com.eneko.testapp.ui.theme.EmeraldDarkPrimary
import com.eneko.testapp.ui.theme.EmeraldDarkSecondaryVariant
import com.eneko.testapp.ui.theme.TextPrimary

@Composable
fun AddItemDialog(
    onAdd: (String, Int) -> Unit,
    onDismiss: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var quantityText by remember { mutableStateOf("") }
    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = EmeraldDarkPrimary,
        textContentColor = TextPrimary,
        title = {
            Text(
                text = stringResource(R.string.add_item),
                style = MaterialTheme.typography.titleMedium,
                color = TextPrimary
            )
        },
        text = {
            Column {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = {
                        Text(
                            stringResource(R.string.name),
                            color = TextPrimary,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = EmeraldDarkSecondaryVariant,
                        unfocusedBorderColor = TextPrimary,
                        cursorColor = EmeraldDarkSecondaryVariant,
                        focusedTextColor = EmeraldDarkSecondaryVariant,
                        unfocusedTextColor = TextPrimary
                    ),
                    textStyle = MaterialTheme.typography.bodyMedium.copy(color = TextPrimary)
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = quantityText,
                    onValueChange = {  quantityText = it.filter { c -> c.isDigit() } },
                    label = {
                        Text(
                            stringResource(R.string.quantity),
                            color = TextPrimary,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = EmeraldDarkSecondaryVariant,
                        unfocusedBorderColor = TextPrimary,
                        cursorColor = EmeraldDarkSecondaryVariant,
                        focusedTextColor = EmeraldDarkSecondaryVariant,
                        unfocusedTextColor = TextPrimary
                    ),
                    textStyle = MaterialTheme.typography.bodyMedium.copy(color = TextPrimary)
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
                enabled = quantityText.isNotEmpty() && name.isNotEmpty(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = EmeraldDarkSecondaryVariant,
                    contentColor = EmeraldDarkPrimary
                )
            ) {
                Text(
                    stringResource(R.string.add),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        },
        dismissButton = {
            OutlinedButton(
                onClick = onDismiss,
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = TextPrimary
                ),
                border = BorderStroke(1.dp, TextPrimary)
            ) {
                Text(
                    stringResource(R.string.cancel),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    )
}
