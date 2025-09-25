package com.eneko.testapp.presentation.util.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eneko.testapp.R
import com.eneko.testapp.ui.theme.Error
import com.eneko.testapp.ui.theme.Success
import kotlinx.coroutines.delay

@Composable
fun ResultDialog(
    isSuccess: Boolean,
    visible: Boolean,
    onDismiss: () -> Unit,
    modifier: Modifier
) {
    if (visible) {
        LaunchedEffect (true){
            delay(3000)
            onDismiss()
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(if (isSuccess) Success else Error, RoundedCornerShape(4.dp))
                .padding(horizontal = 16.dp, vertical = 10.dp)
                , contentAlignment = Alignment.BottomCenter
        ) {
            Text(
                text = if (isSuccess) stringResource(R.string.action_success) else stringResource(R.string.action_error),
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}


@Preview
@Composable
fun ResultDialogPreview(){
    ResultDialog(isSuccess = true, visible = true, onDismiss = {}, modifier = Modifier)
}
