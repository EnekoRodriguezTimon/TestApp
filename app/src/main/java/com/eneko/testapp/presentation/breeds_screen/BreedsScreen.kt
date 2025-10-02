package com.eneko.testapp.presentation.breeds_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eneko.testapp.R
import com.eneko.testapp.presentation.breeds_screen.components.BreedsCard
import com.eneko.testapp.presentation.util.components.LoadingDialog
import com.eneko.testapp.presentation.util.components.MyTopAppBar

@Composable
internal fun BreedsScreen(
    viewModel: BreedsViewModel = hiltViewModel(),
    navigateToBreedDetail: (String) -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    ProductsContent(state = state, navigateToBreedDetail)
}

@Composable
fun ProductsContent(
    state: BreedsViewState,
    navigateToBreedDetail: (String) -> Unit,
) {
    LoadingDialog(isLoading = state.isLoading)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyTopAppBar(stringResource(R.string.breeds))
        }

    ) {
        Column(modifier = Modifier.padding(top = it.calculateTopPadding()), ) {
            LazyVerticalStaggeredGrid(
                modifier = Modifier.padding(top = 15.dp),
                columns = StaggeredGridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalItemSpacing = 15.dp
            ) {
                items(state.breeds) { breed ->
                    BreedsCard(
                        modifier = Modifier,
                        onClick = { navigateToBreedDetail(breed.attributes.name) },
                        breed = breed
                    )
                }
            }
        }

    }
}