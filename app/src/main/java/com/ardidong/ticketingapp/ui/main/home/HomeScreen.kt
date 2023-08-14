package com.ardidong.ticketingapp.ui.main.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ardidong.ticketingapp.ui.theme.TicketingAppTheme
import com.ardidong.ticketingapp.ui.theme.shimmerEffect

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(topAppBarState)
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { ScrollAppBar(modifier = Modifier, scrollBehavior = scrollBehavior)}
    ) {paddingValues ->
        val scrollState = rememberScrollState()
        Column {
            Surface(
                modifier = Modifier
                    .padding(paddingValues),
                color = MaterialTheme.colorScheme.primary,
                shadowElevation = if (topAppBarState.collapsedFraction == 0f) 0.dp else 8.dp
            ) {
                Column(
                    modifier = Modifier
                ) {
                    SearchButton(
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp, horizontal = 16.dp)
                    )
                }
            }

            Column(
                Modifier
                    .verticalScroll(scrollState)
            )
            {
                val sectionModifier = Modifier.padding(vertical = 16.dp)

                ExploreSection(sectionModifier)
                EventSection(sectionModifier)
                PlacesSection(sectionModifier)

                Spacer(modifier = Modifier.height(72.dp))
            }
        }
    }
}

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

@Composable
fun SearchButton(modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 4.dp,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Icon(
                Icons.Filled.Search,
                contentDescription = "search_icon",
                modifier = Modifier.size(20.dp)
            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically),
                text = "Search", fontSize = 12.sp
            )
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
                color = MaterialTheme.colorScheme.onBackground,
            )
        )
        val list = listOf("satu", "dua", "tiga")
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 12.dp)
        ){
            items(list){ item ->
                DestinationItem(
                    modifier = Modifier.shimmerEffect(),
                    name = "$item name",
                    address = "$item address",
                    price = "Rp50.000"
                )
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
                color = MaterialTheme.colorScheme.onBackground,
            )
        )
        val list = listOf("candi Prambanan", "dua", "tiga")
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 12.dp)
        ){
            items(list){
                DestinationItem(isLoading = true)
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
                color = MaterialTheme.colorScheme.onBackground,
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
