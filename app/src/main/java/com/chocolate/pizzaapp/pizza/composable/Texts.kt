package com.chocolate.pizzaapp.pizza.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chocolate.pizzaapp.R
import com.chocolate.pizzaapp.ui.theme.Black
import com.chocolate.pizzaapp.ui.theme.Gray

@Composable
fun PizzaPrice(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(id = R.string._17),
        color = Black,
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold
    )
}


@Composable
fun PizzaIngredientsText(modifier: Modifier = Modifier.padding(top = 16.dp)) {
    Text(
        modifier = modifier,
        text = stringResource(id = R.string.customize_your_pizza),
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = Gray,
    )
}