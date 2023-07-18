package com.chocolate.pizzaapp.pizza.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chocolate.pizzaapp.ui.theme.Black



@Composable
fun RowPizzaSize(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(48.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CreateText("S", 24)
            CreateText("M", 24)
            CreateText("L", 24)
        }
    }
}@Composable
fun CreateText(
    text: String,
    fontSize: Int,
    color: Color = Black,
    fontWeight: FontWeight = FontWeight.Normal,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        color = color,
        fontWeight = fontWeight,
        modifier = modifier
    )
}