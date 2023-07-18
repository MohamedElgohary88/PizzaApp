package com.chocolate.pizzaapp.pizza.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chocolate.pizzaapp.R
import com.chocolate.pizzaapp.ui.theme.Brown

@Composable
fun AddToCartButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = Brown)
            .wrapContentSize()
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_cart),
            contentDescription = null,
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 28.dp, end = 8.dp)
                .align(Alignment.CenterVertically)
        )
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.padding(start = 12.dp, end = 28.dp, top = 12.dp, bottom = 12.dp)
        )
    }
}