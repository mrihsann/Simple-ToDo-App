package com.ihsanarslan.simpletodoapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ihsanarslan.simpletodoapp.navigation.NavigationGraph
import com.ihsanarslan.simpletodoapp.presentation.detail.DetailScreen
import com.ihsanarslan.simpletodoapp.presentation.home.HomeScreen
import com.ihsanarslan.simpletodoapp.ui.theme.MyappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyappTheme {
                NavigationGraph()
            }
        }
    }
}