package com.chocolate.pizzaapp.pizza

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.chocolate.pizzaapp.R
import com.chocolate.pizzaapp.pizza.components.AddToCartButton
import com.chocolate.pizzaapp.pizza.components.CreateText
import com.chocolate.pizzaapp.pizza.components.LazyIngredientsRow
import com.chocolate.pizzaapp.pizza.components.RowPizzaSize
import com.chocolate.pizzaapp.pizza.components.TopAppBar
import com.chocolate.pizzaapp.ui.theme.Gray

@Preview(showSystemUi = true)
@Composable
fun PizzaScreen() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (topBar, imagePlate, price, rowSize, ingredientsRow, customize, addToCartButton) = createRefs()
        TopAppBar(modifier = Modifier.constrainAs(topBar) {
            top.linkTo(parent.top, margin = 16.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Image(
            painter = painterResource(R.drawable.plate),
            contentDescription = stringResource(R.string.plate),
            modifier = Modifier
                .constrainAs(imagePlate) {
                    top.linkTo(topBar.bottom, margin = 32.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .height(256.dp)
                .fillMaxWidth()
        )
        CreateText("$17", 30, fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(price) {
                top.linkTo(imagePlate.bottom, margin = 32.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        RowPizzaSize(modifier = Modifier.constrainAs(rowSize) {
            top.linkTo(price.bottom, margin = 32.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        CreateText(
            text = "Customize Your Pizza",
            fontSize = 14,
            color = Gray,
            modifier = Modifier.constrainAs(customize) {
                top.linkTo(rowSize.bottom, margin = 32.dp)
                start.linkTo(parent.start, margin = 16.dp)
            })
        LazyIngredientsRow(modifier = Modifier.constrainAs(ingredientsRow) {
            top.linkTo(customize.bottom, margin = 16.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        AddToCartButton(text = "Add To Cart", modifier = Modifier.constrainAs(addToCartButton) {
            top.linkTo(ingredientsRow.bottom, margin = 32.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
    }
}