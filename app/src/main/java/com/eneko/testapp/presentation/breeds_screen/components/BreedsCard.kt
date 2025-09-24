package com.eneko.testapp.presentation.breeds_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.eneko.testapp.domain.model.Breed

@Composable
fun BreedsCard(
    modifier: Modifier,
    onClick: () -> Unit,
    breed: Breed
){
    Card (
        modifier = Modifier,
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(contentColor = Color.White)
        ) {
        Column (modifier = Modifier
            .padding(15.dp)
            .clickable{
                onClick()
            }){

            Spacer(modifier = Modifier.height(5.dp))
            Text(text = breed.attributes.name, style = MaterialTheme.typography.titleMedium)
        }
    }
}