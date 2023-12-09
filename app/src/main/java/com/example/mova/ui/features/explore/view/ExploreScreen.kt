package com.example.mova.ui.features.explore.view

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.mova.R
import com.example.mova.data.consts.categories
import com.example.mova.data.consts.genres
import com.example.mova.data.consts.regions
import com.example.mova.data.consts.sort
import com.example.mova.data.consts.time_periods
import com.example.mova.data.network.model.ExploreMovieItem
import com.example.mova.ui.common.components.CardMovieItem
import com.example.mova.ui.features.explore.dummydata.topSearchList
import com.example.mova.ui.features.explore.model.FilterComponent
import com.example.mova.ui.features.explore.viewmodel.ExploreViewModel
import com.example.mova.ui.navigation.MovaAppScreens
import com.example.mova.ui.theme.backgroundGray
import com.example.mova.ui.theme.primaryColor
import com.example.mova.ui.theme.secondaryColor

@Composable
fun ExploreScreen(
    navController: NavHostController,
) {
    val viewModel: ExploreViewModel = hiltViewModel()
    val exploreUiState: ExploreUiState = viewModel.exploreUiState
    val searchUiState: SearchUiState = viewModel.searchUiState
    val localFocusManager = LocalFocusManager.current
    var searchInput: String by remember {
        mutableStateOf("")
    }
    var searchIsFocused: Boolean by remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier.pointerInput(Unit) {
            detectTapGestures(onTap = { localFocusManager.clearFocus() })
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp, horizontal = 8.dp)
            ) {
                OutlinedTextField(
                    value = searchInput,
                    onValueChange = {
                        searchInput = it
                        viewModel.getTopSearches()
                    },
                    shape = RoundedCornerShape(15.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = backgroundGray,
                        focusedContainerColor = secondaryColor,
                        unfocusedLeadingIconColor = Color.LightGray,
                        unfocusedBorderColor = backgroundGray,
                        focusedBorderColor = primaryColor,
                        focusedLeadingIconColor = primaryColor,
                        focusedPlaceholderColor = Color.LightGray,
                        unfocusedPlaceholderColor = Color.LightGray,
                        cursorColor = primaryColor
                    ),
                    placeholder = { Text(text = stringResource(R.string.search)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.search_icon),
                            contentDescription = stringResource(R.string.search)
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Search,
                        keyboardType = KeyboardType.Text
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            //viewModel.searchUiState = SearchUiState.Loading
                            //localFocusManager.clearFocus()
                            viewModel.getSearchMovies(searchInput)
                        }
                    ),
                    modifier = Modifier
                        .height(55.dp)
                        .weight(0.83f)
                        .onFocusChanged { focus ->
                            if (focus.isFocused) {
                                searchIsFocused = true
                                viewModel.getTopSearches()
                            } else {
                                searchIsFocused = false
                                viewModel.getTopSearches()
                            }
                        }
                )
                Spacer(modifier = Modifier.weight(0.02f))
                Button(
                    onClick = {
                        searchIsFocused = false
                        viewModel.toggleBottomSheetState()
                    },
                    shape = RoundedCornerShape(18.dp),
                    contentPadding = PaddingValues(14.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = secondaryColor),
                    modifier = Modifier
                        .size(55.dp)
                        .weight(0.15f),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.filter_icon),
                        tint = primaryColor,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            
            if(viewModel.bottomSheetState){
                FilterSheet(viewModel = viewModel)
            }
            
            if (searchIsFocused) {
                when (searchUiState) {
                    is SearchUiState.TopSearch -> BodyTopSearch(
                        searchValue = searchInput,
                        onClick = {
                            navController.navigate(
                                route = MovaAppScreens.MOVIE_DETAILS.name
                            )
                        })

                    is SearchUiState.SearchSuccess -> CardMovieItem(movie = searchUiState.searchMovie){
                        /*TODO*/
                    }
                    is SearchUiState.Loading -> BodyLoading()
                    else -> SearchError()
                }
            } else {
                localFocusManager.clearFocus()
                when (exploreUiState) {
                    is ExploreUiState.Success -> BodySuccess(
                        exploreUiState.exploreMovies,
                        onClick = {
                            navController.navigate(
                                route = MovaAppScreens.MOVIE_DETAILS.name
                            )
                        })

                    is ExploreUiState.Loading -> BodyLoading()
                    else -> BodyError()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterSheet(viewModel: ExploreViewModel) {
    Scaffold { paddingValues ->
        ModalBottomSheet(
            onDismissRequest = { viewModel.toggleBottomSheetState() },
            windowInsets = WindowInsets(bottom = paddingValues.calculateBottomPadding()),
            dragHandle = {
                BottomSheetDefaults.DragHandle(
                    color = Color.LightGray,
                    width = 42.dp,
                    height = 2.dp,
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = stringResource(R.string.sort_filter),
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    color = primaryColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Divider(
                    color = Color.LightGray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp, vertical = 15.dp)
                )
                FilterRow(filterComponent = categories, viewModel = viewModel)
                FilterRow(filterComponent = regions, viewModel = viewModel)
                FilterRow(filterComponent = genres, viewModel = viewModel)
                FilterRow(filterComponent = time_periods, viewModel = viewModel)
                FilterRow(filterComponent = sort, viewModel = viewModel)
                Divider(
                    color = Color.LightGray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp, vertical = 10.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp, bottom = 45.dp)
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = secondaryColor,
                            contentColor = primaryColor
                        ),
                        onClick = { viewModel.resetFilter() }
                    ) {
                        Text(
                            text = stringResource(R.string.reset),
                            fontSize = 16.sp,
                            modifier = Modifier.padding(vertical = 10.dp, horizontal = 45.dp)
                        )
                    }
                    val applyContainerColor = animateColorAsState(
                        targetValue = if (viewModel.filterUiState.hasFilter) primaryColor else Color.LightGray,
                        label = "color",
                        animationSpec = tween(200, easing = EaseInOut)
                    )
                    val applyTextColor = animateColorAsState(
                        targetValue = if (viewModel.filterUiState.hasFilter) Color.White else Color.Gray,
                        label = "color",
                        animationSpec = tween(200, easing = EaseInOut)
                    )
                    Button(
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 5.dp
                        ),
                        enabled = viewModel.filterUiState.hasFilter,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = applyContainerColor.value,
                            contentColor = applyTextColor.value,
                            disabledContainerColor = applyContainerColor.value,
                            disabledContentColor = applyTextColor.value
                        ),
                        onClick = { viewModel.applyFilter() },
                    ) {
                        Text(
                            text = stringResource(R.string.apply),
                            fontSize = 16.sp,
                            modifier = Modifier.padding(vertical = 10.dp, horizontal = 45.dp)
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun FilterRow(
    filterComponent: FilterComponent,
    viewModel: ExploreViewModel
) {

    Column {
        Text(
            text = filterComponent.title,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 2.dp)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 8.dp, bottom = 8.dp)
        ) {
            items(filterComponent.choices) { choice ->
                val choiceBackgroundColor = animateColorAsState(
                    targetValue = if (choice == viewModel.filterUiState.category || choice == viewModel.filterUiState.region || choice == viewModel.filterUiState.genre || choice == viewModel.filterUiState.time || choice == viewModel.filterUiState.sort) primaryColor else Color.White,
                    label = "color",
                    animationSpec = tween(200, easing = EaseInOut)
                )
                val choiceTextColor = animateColorAsState(
                    targetValue = if (choice == viewModel.filterUiState.category || choice == viewModel.filterUiState.region || choice == viewModel.filterUiState.genre || choice == viewModel.filterUiState.time || choice == viewModel.filterUiState.sort) Color.White else primaryColor,
                    label = "color",
                    animationSpec = tween(200, easing = EaseInOut)
                )
                OutlinedButton(
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = choiceBackgroundColor.value,
                        contentColor = choiceTextColor.value
                    ),
                    border = BorderStroke(2.dp, primaryColor),
                    onClick = {
                        viewModel.selectFilter(
                            filterComponent,
                            filterComponent.choices.indexOf(choice)
                        )
                    }
                ) {
                    Text(
                        text = choice,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@Composable
fun BodySuccess(
    movies: List<ExploreMovieItem>,
    onClick: () -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        items(items = movies, key = { movie -> movie.imdbid!! }) { movie ->
            CardMovieItem(movie = movie, onClick = onClick)
        }
    }
}

@Composable
fun BodyLoading() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            color = primaryColor,
        )

    }
}

@Composable
fun BodyError() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error),
            contentDescription = null
        )
        Text(text = "Something went wrong!!")
    }
}

//@Composable
//fun CardMovieItem(
//    movie: ExploreMovieItem,
//    onClick: () -> Unit
//) {
//    Box(
//        modifier = Modifier
//            .aspectRatio(0.8f)
//            .padding(4.dp)
//            .clip(RoundedCornerShape(15.dp))
//            .clickable { onClick() }
//    ) {
//        Card(
//            modifier = Modifier
//                .fillMaxSize()
//        ) {
//            AsyncImage(
//                model = ImageRequest.Builder(LocalContext.current).data(movie.image!!)
//                    .crossfade(true)
//                    .build(),
//                contentDescription = null,
//                error = painterResource(id = R.drawable.ic_broken_image),
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//        Card(
//            colors = CardDefaults.cardColors(primaryColor),
//            modifier = Modifier.padding(15.dp)
//        ) {
//            Text(
//                text = movie.rating!!,
//                color = Color.White,
//                fontSize = 14.sp,
//                modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp)
//            )
//        }
//    }
//}

@Composable
fun BodyTopSearch(
    searchValue: String,
    onClick: () -> Unit
) {
    if (searchValue == "") {
        Column() {
            Text(
                text = stringResource(R.string.top_searches),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(items = topSearchList, key = { movie -> movie.title }) { movie ->
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
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
                                    painter = rememberAsyncImagePainter(model = movie.imageUrl),
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
                        Text(
                            text = movie.title,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
        }
    } else {
        Column(modifier = Modifier.fillMaxSize()) {
        }
    }
}

//@Composable
//fun SearchMovieItem(
//    movie: ExploreMovieItem
//) {
//    Box(
//        modifier = Modifier
//            .aspectRatio(0.8f)
//            .padding(4.dp)
//            .clip(RoundedCornerShape(15.dp))
//            .clickable { }
//    ) {
//        Card(
//            modifier = Modifier.fillMaxSize()
//        ) {
//            AsyncImage(
//                model = ImageRequest.Builder(LocalContext.current).data(movie.image)
//                    .crossfade(true)
//                    .build(),
//                contentDescription = null,
//                error = painterResource(id = R.drawable.ic_broken_image),
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//        Card(
//            colors = CardDefaults.cardColors(primaryColor),
//            modifier = Modifier.padding(15.dp)
//        ) {
//            Text(
//                text = movie.rating!!,
//                color = Color.White,
//                fontSize = 14.sp,
//                modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp)
//            )
//        }
//    }
//}

@Composable
fun SearchError() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.not_found),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = stringResource(R.string.not_found),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = primaryColor
        )
        Text(
            text = stringResource(R.string.not_found_message),
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}

