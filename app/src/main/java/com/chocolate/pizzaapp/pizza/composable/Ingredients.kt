package com.chocolate.pizzaapp.pizza.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.chocolate.pizzaapp.R
import com.chocolate.pizzaapp.pizza.viewmodel.IngredientsUiState

@Composable
fun LazyIngredientsRow(
    ingredients: List<IngredientsUiState>,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        itemsIndexed(ingredients, key = { _, item -> item.id }) { index, topping ->
            PizzaIngredientItem(
                image = topping.mainImage,
                isSelected = topping.isSelected,
                onClick = { onClick(index) },
            )
        }
    }
}

@Composable
fun PizzaIngredientItem(
    image: Int,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier
            .size(64.dp)
            .background(
                if (isSelected) Color(0XFFDBF3E2)
                else Color.Transparent, CircleShape
            ),
        onClick = onClick,
    ) {
        Image(
            modifier = Modifier.size(48.dp),
            painter = painterResource(id = image),
            contentDescription = stringResource(R.string.ingredient),
        )
    }
}

@Composable
fun IngredientsItem(
    image: Int,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    AnimatedVisibility(
        visible = isSelected, enter = scaleIn(initialScale = 10f)
                + fadeIn(), exit = fadeOut()
    ) {
        Image(
            modifier = modifier,
            painter = painterResource(id = image),
            contentDescription = ""
        )
    }
}