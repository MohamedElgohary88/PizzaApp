package com.chocolate.pizzaapp.pizza

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.chocolate.pizzaapp.pizza.PizzaContent
import com.chocolate.pizzaapp.pizza.viewmodel.PizzaViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun PizzaScreen(viewModel: PizzaViewModel = hiltViewModel()) {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(color = Color.White, darkIcons = useDarkIcons)
        onDispose {
            systemUiController.setSystemBarsColor(
                color = Color.White,
                darkIcons = useDarkIcons
            )
        }
    }
    val state by viewModel.state.collectAsState()
    PizzaContent(
        state, onClickSize = viewModel::updatePizzaSize,
        onClickIngredients = viewModel::updateToppingSelection
    )
}