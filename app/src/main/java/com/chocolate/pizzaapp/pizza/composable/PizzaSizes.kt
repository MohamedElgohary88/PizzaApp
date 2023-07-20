package com.chocolate.pizzaapp.pizza.composable

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chocolate.pizzaapp.R
import com.chocolate.pizzaapp.pizza.viewmodel.PizzaSize
import com.chocolate.pizzaapp.ui.theme.Black

@Composable
fun ChoosePizzaSizes(
    pizzaSize: PizzaSize,
    modifier: Modifier = Modifier,
    onSizeClick: (PizzaSize) -> Unit,
) {
    val position by animateDpAsState(
        targetValue = when (pizzaSize) {
            PizzaSize.SMALL -> 0.dp
            PizzaSize.MEDIUM -> 48.dp
            PizzaSize.LARGE -> 95.dp
        },
        label = stringResource(R.string.size_animation),
        animationSpec = tween(
            durationMillis = 300,
            easing = LinearOutSlowInEasing
        )
    )
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = modifier.matchParentSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Card(
                modifier = Modifier
                    .size(48.dp)
                    .offset(x = position, y = 0.dp),
                shape = CircleShape,
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp,
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.White
                ),
            ) {}
        }

        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextPizzaSize(
                text = stringResource(R.string.s),
                onClick = { onSizeClick(PizzaSize.SMALL) },
            )
            TextPizzaSize(
                text = stringResource(R.string.m),
                onClick = { onSizeClick(PizzaSize.MEDIUM) },
            )
            TextPizzaSize(
                text = stringResource(R.string.l),
                onClick = { onSizeClick(PizzaSize.LARGE) },
            )
        }
    }
}

@Composable
fun TextPizzaSize(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier
            .size(48.dp)
            .wrapContentHeight()
            .clickable { onClick() },
        text = text,
        textAlign = TextAlign.Center,
        color = Black,
        style = MaterialTheme.typography.bodyLarge,
    )
}