package com.chocolate.pizzaapp.pizza.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.chocolate.pizzaapp.pizza.PizzaContent
import com.chocolate.pizzaapp.pizza.viewmodel.PizzaViewModel

@Composable
fun PizzaScreen(viewModel: PizzaViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    PizzaContent(state, onClickSize = viewModel::updatePizzaSize,
        onClickIngredients = viewModel::updateToppingSelection
    )
}