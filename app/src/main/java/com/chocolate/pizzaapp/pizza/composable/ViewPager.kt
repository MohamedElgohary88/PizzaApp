package com.chocolate.pizzaapp.pizza.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ViewPager(
    pizzaList: List<Int>,
    pagerState: PagerState,
    onPizzaImageChanged: (Int) -> Unit,
) {
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect {
            onPizzaImageChanged(it)
        }
    }
    Scaffold(
        containerColor = Color.Transparent
    ) {
        HorizontalPager(
            pageCount = pizzaList.size,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = Modifier.fillMaxSize()
        ) { page ->
            val imageSizeModifier = Modifier.size(140.dp)
            Image(
                painter = painterResource(id = pizzaList[page]),
                contentDescription = null,
                modifier = imageSizeModifier.size(80.dp)
            )
        }
    }
}