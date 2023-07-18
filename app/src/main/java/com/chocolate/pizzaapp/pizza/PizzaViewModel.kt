package com.chocolate.pizzaapp.pizza

import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import com.chocolate.pizzaapp.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PizzaViewModel : ViewModel() {
    private val _state = MutableStateFlow(HomeUIState())
    val state = _state.asStateFlow()

    private val breadImages = listOf(R.drawable.bread_1,
        R.drawable.bread_2,
        R.drawable.bread_3,
        R.drawable.bread_4,
        R.drawable.bread_5,
    )

    init {
        _state.update { it.copy(imagesList = breadImages) }
    }

    fun onPizzaImageChanged(newValue: Int) {
        _state.update { it.copy(imagePosition = newValue) }
    }
}

data class HomeUIState(
    @DrawableRes val imagesList: List<Int> = emptyList(),
    val imagePosition: Int = 1,
)