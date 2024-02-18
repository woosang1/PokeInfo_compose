package com.example.pokeinfo.features.main.screen.container

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.features.main.viewModel.MainViewModel
import androidx.compose.runtime.getValue

@Preview(showBackground = true, name = "Text preview")
@Composable
fun View() {
    Column {
        PokemonList()
    }
}

@Composable
private fun PokemonList(
//    mainViewModel: MainViewModel = hiltViewModel()
) {
    val mainViewModel: MainViewModel = viewModel()
    val pokemonInfo: Int by remember { mainViewModel.test }

//    val pokemonInfo: List<PokemonInfo> by remember { mainViewModel.pokemonList }
//    val mainViewModel by MainViewModel { mainViewModel.pokemonList }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
    ) {
        items(pokemonInfo) { pokemon ->
            PokemonCard(pokemonInfo = pokemon, onClick = {})
        }
    }
}

@Composable
fun PokemonCard(pokemonInfo: PokemonInfo, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = pokemonInfo.name,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row {
                    pokemonInfo.type.forEach { type ->
                        TypeTextView(type = type)
                    }
                }
            }
        }
    }
}

@Composable
fun TypeTextView(type: String) {
    Text(
        text = type,
        modifier = Modifier
            .padding(end = 4.dp)
            .background(Color.Gray, shape = RoundedCornerShape(4.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    )
}
