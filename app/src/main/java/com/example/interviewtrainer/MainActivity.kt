package com.example.interviewtrainer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.interviewtrainer.data.database.AppDatabase
import com.example.interviewtrainer.data.database.DatabaseInitializer
import com.example.interviewtrainer.presentation.navigation.AppNavGraph
import com.example.interviewtrainer.ui.theme.InterviewTrainerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val database = AppDatabase.getInstance(this)
        DatabaseInitializer.populateDatabase(database)
        setContent {
            AppNavGraph()
        }
    }
}




