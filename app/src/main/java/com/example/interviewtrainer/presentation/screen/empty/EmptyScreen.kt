package com.example.interviewtrainer.presentation.screen.empty

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.material3.MaterialTheme
//androidx.compose.material3:material3
@Composable
fun EmptyScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier =  Modifier,
            style = MaterialTheme.typography.headlineMedium,
            text = "В разработке"
        )
    }
}