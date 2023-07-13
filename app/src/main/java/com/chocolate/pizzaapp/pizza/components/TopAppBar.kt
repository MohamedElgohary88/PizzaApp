package com.chocolate.pizzaapp.pizza.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chocolate.pizzaapp.R

@Preview
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_arrow_back),
            contentDescription = "Left Icon",
            modifier = modifier.padding(start = 16.dp)
        )
        Spacer(modifier = modifier.weight(1f))
        Text(
            text = "Pizza",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            ),
            modifier = modifier.padding(horizontal = 16.dp, vertical = 4.dp)
        )
        Spacer(modifier = modifier.weight(1f))
        Icon(
            painter = painterResource(R.drawable.ic_heart),
            contentDescription = "Right Icon",
            modifier = modifier.padding(end = 16.dp)
        )
    }
}