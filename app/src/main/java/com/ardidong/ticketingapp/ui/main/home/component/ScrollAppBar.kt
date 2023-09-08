package com.ardidong.ticketingapp.ui.main.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrollAppBar(modifier: Modifier, name: String ="Explorer", scrollBehavior: TopAppBarScrollBehavior){
    TopAppBar(
        title = {
            Column(
                modifier = modifier.padding(top = 16.dp)
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimary,
                    text = "Hello, ${name}!",
                    fontSize = 16.sp
                )
                Text(
                    color = MaterialTheme.colorScheme.onPrimary,
                    text = "Where are we going today?",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        scrollBehavior = scrollBehavior
    )
}