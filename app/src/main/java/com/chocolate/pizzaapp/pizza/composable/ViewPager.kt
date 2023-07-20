package com.chocolate.pizzaapp.pizza.composable

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.chocolate.pizzaapp.R
import com.chocolate.pizzaapp.pizza.viewmodel.BreadUiState
import com.chocolate.pizzaapp.pizza.viewmodel.PizzaSize

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BreadPager(
    pagerState: PagerState,
    breadUiStates: List<BreadUiState>,
    modifier: Modifier = Modifier
) {
    HorizontalPager(
        pageCount = breadUiStates.size,
        modifier = modifier,
        state = pagerState,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val pizzaSize by animateDpAsState(
            when (breadUiStates[it].pizzaSize) {
                PizzaSize.SMALL -> 32.dp
                PizzaSize.MEDIUM -> 24.dp
                PizzaSize.LARGE -> 16.dp
            }, label = stringResource(id = R.string.size_animation),
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )
        Box(
            modifier = Modifier.padding(pizzaSize).fillMaxSize(), contentAlignment = Alignment.Center) {
            AsyncImage(
                ImageRequest.Builder(LocalContext.current)
                    .data(breadUiStates[it].image)
                    .scale(Scale.FILL)
                    .build(), modifier = Modifier.fillMaxSize(),
                contentDescription = stringResource(R.string.bread))
            for (item in breadUiStates[it].ingredients) {
                IngredientsItem(
                    image = item.image,
                    isSelected = item.isSelected,
                    modifier = Modifier
                        .size(180.dp)
                        .padding(pizzaSize)
                )
            }
        }
    }
}