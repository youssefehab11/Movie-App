package com.example.mova.ui.common.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.mova.R
import com.example.mova.data.network.model.ExploreMovieItem
import com.example.mova.ui.theme.primaryColor

@Composable
fun CardMovieItem(
    movie: ExploreMovieItem,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .aspectRatio(0.8f)
            .padding(4.dp)
            .clip(RoundedCornerShape(15.dp))
            .clickable { onClick() }
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(movie.image!!)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                error = painterResource(id = R.drawable.ic_broken_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Card(
            colors = CardDefaults.cardColors(primaryColor),
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                text = movie.rating!!,
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp)
            )
        }
    }
}