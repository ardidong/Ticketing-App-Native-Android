package com.ardidong.ticketingapp.ui.main.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ardidong.ticketingapp.ui.theme.Orange700
import com.ardidong.ticketingapp.ui.theme.TicketingAppTheme
import com.ardidong.ticketingapp.ui.theme.shimmerEffect


@Composable
fun DestinationItem(
    modifier: Modifier = Modifier,
    name: String = "",
    address: String = "",
    price: String = "",
    onClick : () -> Unit = {},
    isLoading: Boolean = false
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp,
        onClick = {onClick()}
    ) {
        if (isLoading) {
            LoadingDestinationItem(modifier)
            return@Surface
        }

        DestinationBody(name = name, address = address, price = price)
    }
}

@Composable
fun DestinationBody(modifier: Modifier = Modifier, name: String, address: String, price: String) {
    Column(modifier = modifier
        .height(240.dp)
        .background(Color.Transparent)
        .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)
    ) {
        Surface(
            shape = RoundedCornerShape(13.dp),
            modifier = Modifier
                .width(140.dp)
                .height(140.dp)
                .padding(bottom = 8.dp),
            color = Color.Cyan
        ){}

        val textModifier = Modifier.width(140.dp)


        Text(
            modifier = textModifier,
            text = name,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
            )
        )

        Text(
            modifier = textModifier,
            overflow = TextOverflow.Ellipsis,
            text = address,
            maxLines = 1,
            style = TextStyle(
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground,
            )
        )

        Text(
            modifier = textModifier,
            text = price,
            maxLines = 2,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight(700),
                color = Orange700
            ),
        )
    }
}

@Composable
fun LoadingDestinationItem(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .height(240.dp)
        .background(Color.Transparent)
        .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)
    ) {
        Surface(
            shape = RoundedCornerShape(13.dp),
            color = Color.Transparent,
            modifier = modifier
                .width(140.dp)
                .height(140.dp)
                .padding(bottom = 8.dp)
                .clip(RoundedCornerShape(13.dp))
                .shimmerEffect()
        ){}

        val boxModifier = Modifier
            .width(140.dp)
            .padding(top = 4.dp)

        Box(
            modifier = boxModifier
                .height(32.dp)
                .shimmerEffect(),
        )

        Box(
            modifier = boxModifier
                .height(14.dp)
                .shimmerEffect(),
        )
        Box(
            modifier = boxModifier
                .height(14.dp)
                .shimmerEffect(),
        )

    }
}


@Composable
fun PlaceItem(
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    place: String ="",
    imageUrl : String ="",
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .width(160.dp)
            .height(160.dp),
        color = Color.LightGray,
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp,
        onClick = {onClick()}
    ) {

        if (isLoading){
            Box(modifier = Modifier
                .fillMaxSize()
                .shimmerEffect())
            return@Surface
        }

        Box( contentAlignment = Alignment.Center){
           if (imageUrl.isNotBlank()) AsyncImage(model = imageUrl , contentDescription = imageUrl, contentScale = ContentScale.Crop)
            Text(text = place, textAlign = TextAlign.Center, style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            ))
        }
    }
}

@Preview
@Composable
fun DestItem() {
    TicketingAppTheme {
        PlaceItem(isLoading = false) {

        }
    }
}
