package com.ardidong.ticketingapp.ui.main.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ardidong.ticketingapp.ui.theme.Orange700


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DestinationItem(
    modifier: Modifier = Modifier,
    name: String,
    address: String,
    price: String,
    onClick : () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        onClick = {onClick()}
    ) {
        Column(modifier = modifier
            .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 24.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(13.dp),
                modifier = modifier
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
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground,
                )
            )

            Text(
                modifier = textModifier,
                overflow = TextOverflow.Ellipsis,
                text = address,
                maxLines = 2
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
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PlaceItem(modifier: Modifier = Modifier, place: String, onClick: () -> Unit) {
    Surface(
        modifier = modifier
            .width(160.dp)
            .height(160.dp),
        color = Color.LightGray,
        shape = RoundedCornerShape(16.dp),
        onClick = {onClick()}
    ) {
        Box( contentAlignment = Alignment.Center){
            Text(text = place, textAlign = TextAlign.Center, style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            ))
        }
    }
}