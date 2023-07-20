package com.chocolate.pizzaapp.pizza.viewmodel

data class PizzaUiState(
    val id: Int = 0,
    val breadUiStates: List<BreadUiState> = emptyList(),
)

data class IngredientsUiState(
    val id: Int = 0,
    val name: String = "",
    val mainImage: Int = 0,
    val price: Int = 0,
    val image: Int = 0,
    var isSelected: Boolean = false,
)

data class BreadUiState(
    val id: Int = 0,
    val image: Int = 0,
    var pizzaSize: PizzaSize = PizzaSize.SMALL,
    val ingredients: List<IngredientsUiState> = emptyList(),
)
enum class PizzaSize() {
    SMALL,
    MEDIUM,
    LARGE,
}