package com.example.interviewtrainer.presentation.screen.platform

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.interviewtrainer.domain.model.Platform
import androidx.compose.ui.graphics.Color

@Composable
fun PlatformSelectionScreen(
    viewModel: PlatformViewModel,
    navController: NavController
){
    val state by viewModel.stateFlow.collectAsState()
    Scaffold{ paddingValues ->
        when {
            state.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            state.error != null -> {
                Text(text = "Ошибка: ${state.error}")
            }

            else -> {
                LazyColumn (
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = paddingValues,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    items(state.platforms) {
                        platform -> PlatformCard(
                            platform = platform,
                            onClick = {
                                if (platform.name == "Android"){
                                    navController.navigate("android_main")
                                } else {
                                    navController.navigate("Empty")
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PlatformCard(
    platform: Platform,
    onClick: () -> Unit
){
    Card (
        // Card с модификатором (fillMaxWidth, padding горизонтальный 16dp, вертикальный 4dp, clickable)
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable{ onClick() },
        colors = CardDefaults.cardColors(
            containerColor = if (platform.isAvailable)
                MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.surfaceVariant
        )
        ){
        Box(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            contentAlignment = Alignment.Center,

        ) {
            Text(text = "${platform.name}",
                color = if (platform.isAvailable)
                    MaterialTheme.colorScheme.onPrimaryContainer
                else
                    MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

