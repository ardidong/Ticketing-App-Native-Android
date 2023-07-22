package com.ardidong.ticketingapp.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.ardidong.ticketingapp.ui.main.home.HomeScreen
import com.ardidong.ticketingapp.ui.theme.TicketingAppTheme


@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ){
        content()
    }
}

@Composable
fun BottomMenuItem(
    icon: @Composable () -> Unit,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Button(
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.White
        ),
        shape = CircleShape,
        modifier = Modifier
            .padding(0.dp),
        onClick = onClick
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(Icons.Filled.Favorite, contentDescription = "", tint = MaterialTheme.colorScheme.primary)
            Text(text = label, color = if (selected) MaterialTheme.colorScheme.primary else Color.DarkGray)
        }
    }
}

@Preview(showBackground = true,  backgroundColor = 0xFF00FF00)
@Composable
fun BottomBarPreview() {
    TicketingAppTheme {
        val navController = rememberNavController()
        Scaffold{ innerPadding ->
            BoxWithConstraints(modifier = Modifier
                .padding(innerPadding)){
                HomeScreen()
                MainBottomNavigation(
                    modifier = Modifier
                        .padding(16.dp)
                        .clip(shape = RoundedCornerShape(24.dp))
                        .align(Alignment.BottomCenter),
                    navController = navController
                )

            }
        }
    }
}