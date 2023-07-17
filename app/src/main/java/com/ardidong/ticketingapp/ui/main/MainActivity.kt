package com.ardidong.ticketingapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ardidong.ticketingapp.ui.main.navigation.MainNavigation
import com.ardidong.ticketingapp.ui.main.navigation.bottomNavItem
import com.ardidong.ticketingapp.ui.theme.TicketingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicketingAppTheme {
                val navController = rememberNavController()
                Scaffold{ innerPadding ->
                    BoxWithConstraints(modifier = Modifier.fillMaxSize()){
                        MainNavigation(
                            modifier = Modifier.padding(innerPadding),
                            navController = navController
                        )

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
    }
}

@Composable
fun MainBottomNavigation(modifier: Modifier = Modifier, navController: NavHostController){
    BottomNavBar(
        modifier = modifier,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        bottomNavItem.forEach { screen ->
            BottomMenuItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                label = screen.route ,
                selected = currentDestination?.hierarchy?.any(){it.route == screen.route} ?: false,
                onClick = {
                    navController.navigate(screen.route){
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

//
//@Composable
//fun BottomNavBar(
//    modifier: Modifier = Modifier,
//    content: @Composable RowScope.() -> Unit
//) {
//    Row(
//        modifier = modifier
//            .fillMaxWidth()
//            .background(color = Color.White),
//        horizontalArrangement = Arrangement.SpaceEvenly,
//        content = content,
//    )
//}
//
//@Composable
//fun BottomMenuItem(
//    icon: @Composable () -> Unit,
//    label: String,
//    selected: Boolean,
//    onClick: () -> Unit
//) {
//    Button(
//        colors = ButtonDefaults.textButtonColors(
//            backgroundColor = Color.White
//        ),
//        shape = CircleShape,
//        modifier = Modifier
//            .padding(0.dp)
//            .wrapContentSize(),
//        onClick = onClick,
//        elevation = ButtonDefaults.elevation(0.dp)
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Icon(Icons.Filled.Favorite, contentDescription = "", tint = MaterialTheme.colors.primary)
//            if(selected){
//                Text(text = label, color = if (selected) MaterialTheme.colors.primary else Color.DarkGray)
//            }
//        }
//    }
//}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true,  backgroundColor = 0xFF00FF00)
@Composable
fun DefaultPreview() {
    TicketingAppTheme {
        val navController = rememberNavController()
        Scaffold{ innerPadding ->
            BoxWithConstraints(modifier = Modifier.fillMaxSize()){
                MainNavigation(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController
                )

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