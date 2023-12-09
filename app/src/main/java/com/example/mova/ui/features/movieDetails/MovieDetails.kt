package com.example.mova.ui.features.movieDetails

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.mova.R
import com.example.mova.ui.common.components.CardMovieItem
import com.example.mova.ui.features.movieDetails.dummydata.UserComment
import com.example.mova.ui.features.movieDetails.dummydata.comments
import com.example.mova.ui.features.movieDetails.dummydata.moreLikeThis
import com.example.mova.ui.features.movieDetails.dummydata.movieDetail
import com.example.mova.ui.features.movieDetails.dummydata.stars
import com.example.mova.ui.features.movieDetails.dummydata.trailers
import com.example.mova.ui.theme.primaryColor
import com.example.mova.ui.theme.secondaryColor

@Composable
fun MovieDetails() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(
                    context = LocalContext.current
                ).data(movieDetail.image)
                    .crossfade(true).build(),
                contentDescription = null,
                placeholder = painterResource(id = R.drawable.loading_img),
                error = painterResource(id = R.drawable.ic_broken_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.back_arrow_icon),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.tv_connect_icon),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            movieDetail.title?.let {
                Text(
                    text = it,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.weight(0.7f),
                )
            }
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.weight(0.15f)) {
                Icon(
                    painter = painterResource(id = R.drawable.mylist_outlined_icon),
                    contentDescription = null,
                )
            }
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.weight(0.15f)) {
                Icon(
                    painter = painterResource(id = R.drawable.share_icon),
                    contentDescription = null,
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 5.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.half_star_icon),
                contentDescription = null,
                tint = primaryColor
            )
            movieDetail.rating?.let { Text(text = it, color = primaryColor) }
            Icon(
                painter = painterResource(id = R.drawable.arrow_right_icon),
                contentDescription = null,
                tint = primaryColor,
                modifier = Modifier.size(20.dp)
            )
            Text(text = movieDetail.year.toString())
            Card(
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(width = 1.5.dp, color = primaryColor),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent,
                    contentColor = primaryColor
                )
            ) {
                Text(
                    text = "13+",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(8.dp),
                )
            }
            Card(
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(width = 1.5.dp, color = primaryColor),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent,
                    contentColor = primaryColor
                )
            ) {
                Text(
                    text = "United States",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(8.dp),
                )
            }
            Card(
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(width = 1.5.dp, color = primaryColor),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent,
                    contentColor = primaryColor
                )
            ) {
                Text(
                    text = "Subtitles",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(8.dp),
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 16.dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = primaryColor,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .height(50.dp)
                    .weight(0.5f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.play_icon),
                        contentDescription = null,
                        modifier = Modifier.size(26.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(R.string.play),
                        fontSize = 20.sp
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = primaryColor
                ),
                border = BorderStroke(width = 2.dp, color = primaryColor),
                modifier = Modifier
                    .height(50.dp)
                    .weight(0.5f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.download_filled_icon),
                        contentDescription = null,
                        modifier = Modifier.size(26.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(R.string.download),
                        fontSize = 20.sp
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.genre),
                fontSize = 17.sp
            )
            movieDetail.genre?.forEachIndexed { index, item ->
                if (index < movieDetail.genre.size - 1)
                    Text(
                        text = " $item,",
                        fontSize = 17.sp,
                        overflow = TextOverflow.Ellipsis,
                        softWrap = false
                    )
                else
                    Text(
                        text = " $item",
                        fontSize = 17.sp,
                        overflow = TextOverflow.Ellipsis,
                        softWrap = false
                    )
            }
        }
        movieDetail.description?.let { ExpandingText(text = it) }
        LazyRow(modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)) {
            items(stars) { star ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = star.image),
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .size(70.dp)
                    )
                    Column {
                        Text(
                            text = star.name,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = star.type.name,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
        var tabIndex by remember { mutableIntStateOf(0) }
        val tabs = listOf<String>("Trailers", "More Like This", "Comments")
        TabRow(
            selectedTabIndex = tabIndex,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    color = primaryColor,
                    modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex])
                )
            },
            modifier = Modifier.padding(8.dp)
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(text = {
                    Text(
                        text = title,
                    )
                },
                    selected = tabIndex == index,
                    selectedContentColor = primaryColor,
                    unselectedContentColor = Color.Gray,
                    onClick = { tabIndex = index }
                )
            }
        }
        when (tabIndex) {
            0 -> Trailers() {
                /*TODO*/
            }

            1 -> MoreLikeThis(
                onClick = {/*TODO*/ }
            )

            2 -> Comments(comments)
        }
    }
}

@Composable
fun Trailers(
    onClick: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        items(items = trailers, key = { trailer -> trailer.name }) { trailer ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClick() }
                    .padding(8.dp)
            ) {
                Card(
                    modifier = Modifier
                        .height(130.dp)
                        .width(160.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Image(
                            painter = rememberAsyncImagePainter(model = trailer.image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.play_icon),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = trailer.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = trailer.duration,
                        fontSize = 14.sp,
                    )
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = secondaryColor
                        )
                    ) {
                        Text(
                            text = trailer.state,
                            fontSize = 14.sp,
                            color = primaryColor,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MoreLikeThis(
    onClick: () -> Unit
) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .height(250.dp)
    ) {
        items(items = moreLikeThis, key = { movie -> movie.imdbid!! }) { movie ->
            CardMovieItem(movie = movie, onClick = onClick)
        }
    }

}

@Composable
fun Comments(
    comments: List<UserComment>
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            Text(
                text = "${comments.size} Comments",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            TextButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = primaryColor
                )
            ) {
                Text(
                    text = stringResource(R.string.see_all),
                    fontSize = 16.sp,
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ){
            items(comments){
                comment -> CommentCard(comment = comment)
            }
        }
    }
}

@Composable
fun CommentCard(
    comment: UserComment
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(50.dp)
            )
            Text(
                text = comment.userName,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.weight(0.8f)
            )
            IconButton(
                onClick = {/*TODO*/},
                modifier = Modifier.weight(0.1f)
            ){
                Icon(
                    painter = painterResource(id = R.drawable.round_menu_icon),
                    contentDescription = null,
                )
            }
        }
        Text(text = comment.comment)
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ){
            Icon(
                painter = painterResource(id = R.drawable.round_favorite_icon),
                tint = Color.Red,
                contentDescription = null,
            )
            Text(
                text = "934"
            )
            Text(
                text = "${comment.time} days ago",
                color = Color.Gray
            )
            TextButton(
                onClick = {/*TODO*/},
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Gray,
                    containerColor = Color.Transparent
                )
            ){
                Text(text = stringResource(R.string.reply))
            }
        }
    }
}

@Composable
fun ExpandingText(modifier: Modifier = Modifier, text: String) {
    var isExpanded by remember { mutableStateOf(false) }
    val textLayoutResultState = remember { mutableStateOf<TextLayoutResult?>(null) }
    var finalText by remember { mutableStateOf(text) }
    val minimizedMAxLines = 3

    val textLayoutResult = textLayoutResultState.value

    LaunchedEffect(textLayoutResult) {
        if (textLayoutResult == null) return@LaunchedEffect

        when {
            isExpanded -> {
                finalText = text
            }

            !isExpanded && textLayoutResult.hasVisualOverflow -> {
                val lastCharIndex = textLayoutResult.getLineEnd(minimizedMAxLines - 1)
                val showMoreString = "... Show More"
                val adjustedText = text
                    .substring(startIndex = 0, endIndex = lastCharIndex)
                    .dropLast(showMoreString.length)
                    .dropLastWhile { it == ' ' || it == '.' }

                finalText = "$adjustedText..."

            }
        }
    }
    Text(
        buildAnnotatedString {
            append(finalText)
            if (textLayoutResult != null && textLayoutResult.lineCount >= minimizedMAxLines) {
                withStyle(
                    style = SpanStyle(
                        color = primaryColor,
                        fontWeight = FontWeight.SemiBold
                    )
                ) {
                    if (!isExpanded)
                        append(" View More")
                    else
                        append(" View Less")
                }
            }
        },
        fontSize = 17.sp,
        maxLines = if (isExpanded) Int.MAX_VALUE else minimizedMAxLines,
        onTextLayout = { textLayoutResultState.value = it },
        modifier = modifier
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null
            ) {
                isExpanded = !isExpanded
            }
            .animateContentSize()
            .padding(horizontal = 16.dp)
    )
}