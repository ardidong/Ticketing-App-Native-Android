package com.ardidong.ticketingapp.ui.main.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ardidong.ticketingapp.domain.group.GroupModel
import com.ardidong.ticketingapp.ui.main.home.component.DestinationItem
import com.ardidong.ticketingapp.ui.main.home.component.PlaceItem
import com.ardidong.ticketingapp.ui.main.home.component.ScrollAppBar
import com.ardidong.ticketingapp.ui.main.home.component.SearchButton
import com.ardidong.ticketingapp.ui.state.UiState
import com.ardidong.ticketingapp.ui.theme.TicketingAppTheme
import com.ardidong.ticketingapp.ui.theme.shimmerEffect

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
){
    val groupState by viewModel.groupState.collectAsState()
    HomeScreenContent(groupState = groupState)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(
    topAppBarState: TopAppBarState = rememberTopAppBarState(),
    groupState: UiState<List<GroupModel>>
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(topAppBarState)
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { ScrollAppBar(modifier = Modifier, scrollBehavior = scrollBehavior) }
    ) { paddingValues ->
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
                Modifier.verticalScroll(scrollState)
            ) {
                val sectionModifier = Modifier.padding(vertical = 16.dp)

                ExploreSection(sectionModifier)
                EventSection(sectionModifier)
                PlacesSection(sectionModifier, groupState)

                Spacer(modifier = Modifier.height(72.dp))
            }
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
fun PlacesSection(modifier: Modifier = Modifier, groupState: UiState<List<GroupModel>>) {
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
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 12.dp)
        ){

            when(groupState){
                is UiState.Loading -> {
                    items(listOf("","","")){ item ->
                        PlaceItem(isLoading = true) {

                        }
                    }
                }

                is UiState.Success -> {
                    items(groupState.data){
                        PlaceItem(place = it.groupName, imageUrl = it.groupImageUrl) {}
                    }
                }

                else -> {}
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewHome() {
    TicketingAppTheme {
        HomeScreenContent(groupState = UiState.Loading)
    }
}
