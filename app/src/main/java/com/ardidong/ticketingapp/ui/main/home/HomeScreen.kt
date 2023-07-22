package com.ardidong.ticketingapp.ui.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ardidong.ticketingapp.ui.theme.TicketingAppTheme

@Composable
fun HomeScreen(){
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize(),
    ) {
        val scrollState = rememberScrollState()
        Column(
            Modifier
                .verticalScroll(scrollState)
                .padding(it))
        {
            WelcomeSection(Modifier.fillMaxWidth())
            SearchButton(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp))

            val sectionModifier = Modifier.padding(vertical = 16.dp)

            ExploreSection(sectionModifier)
            EventSection(sectionModifier)
            PlacesSection(sectionModifier)

            Spacer(modifier = Modifier.height(72.dp))
        }
    }
}

@Composable
fun WelcomeSection(modifier: Modifier = Modifier, name: String = "Explorer") {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
            .background(MaterialTheme.colors.primary)
    ) {
        Column(
            modifier = modifier
                .padding(18.dp)
        ) {
            Text(
                color = MaterialTheme.colors.onPrimary,
                text = "Hello, ${name}!",
                fontSize = 16.sp
            )
            Text(
                color = MaterialTheme.colors.onPrimary,
                text = "Where are we going today?",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun SearchButton(modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colors.background,
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(Icons.Filled.Search, contentDescription = "search_icon")
            Text(modifier = Modifier.padding(start = 8.dp),text = "Search")
        }
    }
}


@Composable
fun ExploreSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp, start = 16.dp),
            text = "Explore Nearby",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                color = MaterialTheme.colors.onBackground,
            )
        )
        val list = listOf("satu", "dua", "tiga")
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 12.dp)
        ){
            items(list){ item ->
                DestinationItem(name = "$item name", address = "$item address", price = "Rp50.000") {

                }
            }
        }

    }
}

@Composable
fun EventSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp, start = 16.dp),
            text = "Events to attend",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                color = MaterialTheme.colors.onBackground,
            )
        )
        val list = listOf("satu", "dua", "tiga")
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 12.dp)
        ){
            items(list){ item ->
                DestinationItem(name = "$item name", address = "$item address", price = "Rp50.000") {

                }
            }
        }

    }
}

@Composable
fun PlacesSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp, start = 16.dp),
            text = "Places",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                color = MaterialTheme.colors.onBackground,
            )
        )
        val list = listOf("satu", "dua", "tiga")
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 12.dp)
        ){
            items(list){ item ->
                PlaceItem(place = item) {

                }
            }
        }

    }
}

@Preview(backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewHome() {
    TicketingAppTheme {
        HomeScreen()
    }
}