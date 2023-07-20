package com.chocolate.pizzaapp.pizza

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chocolate.pizzaapp.R
import com.chocolate.pizzaapp.pizza.composable.AddToCartButton
import com.chocolate.pizzaapp.pizza.composable.BreadPager
import com.chocolate.pizzaapp.pizza.composable.ChoosePizzaSizes
import com.chocolate.pizzaapp.pizza.composable.LazyIngredientsRow
import com.chocolate.pizzaapp.pizza.composable.PizzaIngredientsText
import com.chocolate.pizzaapp.pizza.composable.PizzaPrice
import com.chocolate.pizzaapp.pizza.composable.TopAppBar
import com.chocolate.pizzaapp.pizza.viewmodel.PizzaUiState
import com.chocolate.pizzaapp.pizza.viewmodel.PizzaSize
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaContent(
    state: PizzaUiState,
    onClickSize: (PizzaSize, Int) -> Unit,
    onClickIngredients: (Int, Int) -> Unit,
) {
    Scaffold(
        containerColor = Color.White,
        topBar = { TopAppBar(modifier = Modifier.padding(top = 6.dp)) }
    ) { paddings ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddings.calculateTopPadding(),
                ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) { val pagerState = rememberPagerState(0)
            BreadPager(
                pagerState = pagerState,
                breadUiStates = state.breadUiStates,
                modifier = Modifier.padding(top = 48.dp).height(232.dp).fillMaxWidth()
                    .paint(
                        painter = painterResource(id = R.drawable.plate),
                        contentScale = ContentScale.Inside)
            )
            PizzaPrice(modifier = Modifier.padding(top = 32.dp))
            ChoosePizzaSizes(
                pizzaSize = state.breadUiStates[pagerState.currentPage].pizzaSize,
                modifier = Modifier.padding(vertical = 16.dp),
                onSizeClick = { size -> onClickSize(size, pagerState.currentPage) },
            )
            PizzaIngredientsText(modifier = Modifier.fillMaxWidth().padding(top = 16.dp,
                start = 16.dp),)
            LazyIngredientsRow(
                ingredients = state.breadUiStates[pagerState.currentPage].ingredients,
                modifier = Modifier.padding(top = 8.dp).fillMaxWidth(),
                onClick = { index -> onClickIngredients(index, pagerState.currentPage) }
            )
            Spacer(modifier = Modifier.weight(1f))
            AddToCartButton(modifier = Modifier.padding(bottom = 64.dp),)
        }
    }
}