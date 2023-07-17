package com.ardidong.ticketingapp.ui.main.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.error
    ) {
        Text("Home")
    }
}