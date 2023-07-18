package com.chocolate.pizzaapp.pizza

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.chocolate.pizzaapp.R
import com.chocolate.pizzaapp.pizza.composable.AddToCartButton
import com.chocolate.pizzaapp.pizza.composable.CreateText
import com.chocolate.pizzaapp.pizza.composable.LazyIngredientsRow
import com.chocolate.pizzaapp.pizza.composable.RowPizzaSize
import com.chocolate.pizzaapp.pizza.composable.TopAppBar
import com.chocolate.pizzaapp.pizza.composable.ViewPager
import com.chocolate.pizzaapp.ui.theme.Gray

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaScreen(
    viewModel: PizzaViewModel = hiltViewModel(),
    onMovieImageChanged: (Int) -> Unit,
) {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(color = Color.Transparent, darkIcons = useDarkIcons)
        onDispose {
            systemUiController.setSystemBarsColor(color = Color.Transparent, darkIcons = useDarkIcons)
        }
    }

    val state by viewModel.state.collectAsState()
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (topBar, imagePlate, pager, price, rowSize, ingredientsRow, customize, addToCartButton) = createRefs()

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
        Box(
            modifier = Modifier
                .constrainAs(pager) {
                    top.linkTo(topBar.bottom, margin = 86.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }.fillMaxWidth()
        ) {
            ViewPager(
                state.imagesList,
                rememberPagerState(initialPage = 1),
                onMovieImageChanged,
            )
        }
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