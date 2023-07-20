package com.chocolate.pizzaapp.pizza.viewmodel

import androidx.lifecycle.ViewModel
import com.chocolate.pizzaapp.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PizzaViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(PizzaUiState())
    val state = _state.asStateFlow()

    init { _state.update { it.copy(breadUiStates = getBread()) } }

    fun updatePizzaSize(pizzaSize: PizzaSize, breadIndex: Int) {
        _state.update {
            val breads = it.breadUiStates.toMutableList()
            val bread = breads[breadIndex]
            breads[breadIndex] = bread.copy(pizzaSize = pizzaSize)
            it.copy(breadUiStates = breads)
        }
    }

    fun updateToppingSelection(toppingIndex: Int, breadIndex: Int) {
        _state.update {
            val breads = it.breadUiStates.toMutableList()
            val bread = breads[breadIndex]
            val ingredients = bread.ingredients.toMutableList()
            val ingredient = ingredients[toppingIndex]
            ingredients[toppingIndex] = ingredient.copy(isSelected = !ingredient.isSelected)
            breads[breadIndex] = bread.copy(ingredients = ingredients)
            it.copy(breadUiStates = breads)
        }
    }

    private fun getBread(): List<BreadUiState> {
        return listOf(
            BreadUiState(1, R.drawable.bread_1, PizzaSize.SMALL, getIngredients()),
            BreadUiState(2, R.drawable.bread_2, PizzaSize.SMALL, getIngredients()),
            BreadUiState(3, R.drawable.bread_3, PizzaSize.SMALL, getIngredients()),
            BreadUiState(4, R.drawable.bread_4, PizzaSize.SMALL, getIngredients()),
            BreadUiState(5, R.drawable.bread_5, PizzaSize.SMALL, getIngredients()),
        )
    }

    private fun getIngredients(): List<IngredientsUiState> {
        return listOf(
            IngredientsUiState(
                1, "Basil", R.drawable.basil_3, 2, R.drawable.basil_group,
            ),
            IngredientsUiState(
                2, "Onion", R.drawable.onion_3, 4, R.drawable.onion_group,
            ),
            IngredientsUiState(
                3, "Broccoli", R.drawable.broccoli_3, 6, R.drawable.brocoli_group,
            ),
            IngredientsUiState(
                4, "Mushroom", R.drawable.mushroom_3, 8, R.drawable.mushroom_group,
            ),
            IngredientsUiState(
                5, "Sausage", R.drawable.sausage_3, 10,
                R.drawable.susage_group,
            ),
        )
    }
}