package com.example.mova.ui.features.explore.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mova.data.repository.MovaRepository
import com.example.mova.ui.features.explore.model.FilterComponent
import com.example.mova.ui.features.explore.view.ExploreUiState
import com.example.mova.ui.features.explore.view.FilterUiState
import com.example.mova.ui.features.explore.view.SearchUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val movaRepository: MovaRepository
) : ViewModel() {
    //var searchInput: String by mutableStateOf("")
    var exploreUiState: ExploreUiState by mutableStateOf(ExploreUiState.Loading)
        private set
    var searchUiState: SearchUiState by mutableStateOf(SearchUiState.TopSearch)
        private set

    //var searchIsFocused: Boolean by mutableStateOf(false)
    var bottomSheetState by mutableStateOf(false)
        private set
    var filterUiState by mutableStateOf(FilterUiState(hasFilter = false))
        private set

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            exploreUiState = try {
                ExploreUiState.Success(movaRepository.getMovies())
            } catch (e: Exception) {
                ExploreUiState.Error
            } catch (e: IOException) {
                ExploreUiState.Error
            }
        }
    }

    fun applyFilter() {
        toggleBottomSheetState()
        exploreUiState = ExploreUiState.Loading
        viewModelScope.launch {
            exploreUiState = try {
                var result = movaRepository.getMovies()
                Log.d("result", "applyFilter: $result")
                result = result.filter { it.genre!!.contains(filterUiState.genre) }
                Log.d("resultFiltered", "applyFilter: $result")
                ExploreUiState.Success(result)
            } catch (e: Exception) {
                throw e
                //ExploreUiState.Error
            } catch (e: IOException) {
                throw e
                //ExploreUiState.Error
            }
        }
    }

    fun selectFilter(filterComponent: FilterComponent, index: Int) {
        Log.d("filter", "filterComponentTitle:${filterComponent.title} ")
        Log.d("filter", "indexValue:$index ")
        Log.d("filter", "filterComponentTitle:${filterComponent.choices[index]} ")
        when (filterComponent.title) {
            "Categories" -> filterUiState = filterUiState.copy(
                category = filterComponent.choices[index],
                hasFilter = true
            )


            "Regions" -> filterUiState = filterUiState.copy(
                region = filterComponent.choices[index],
                hasFilter = true
            )

            "Genre" -> filterUiState = filterUiState.copy(
                genre = filterComponent.choices[index],
                hasFilter = true
            )

            "Time/Periods" -> filterUiState = filterUiState.copy(
                time = filterComponent.choices[index],
                hasFilter = true
            )

            "Sort" -> filterUiState = filterUiState.copy(
                sort = filterComponent.choices[index],
                hasFilter = true
            )
        }
        Log.d("category", "selectFilter: ${filterUiState.category}")
        Log.d("region", "selectFilter: ${filterUiState.region}")
    }

    fun getTopSearches() {
        searchUiState = SearchUiState.TopSearch
    }

    fun toggleBottomSheetState() {
        bottomSheetState = !bottomSheetState
    }

    fun resetFilter() {
        filterUiState = filterUiState.copy(
            category = "",
            region = "",
            genre = "",
            time = "",
            sort = "",
            hasFilter = false
        )
    }

    fun getSearchMovies(inputSearch: String) {
        searchUiState = SearchUiState.Loading
        viewModelScope.launch {
            searchUiState = try {
                SearchUiState.SearchSuccess(movaRepository.getMovieById(inputSearch))
            } catch (e: Exception) {
                SearchUiState.Error
            } catch (e: IOException) {
                SearchUiState.Error
            }
        }
    }
}