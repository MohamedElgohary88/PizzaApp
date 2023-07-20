package com.chocolate.pizzaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.chocolate.pizzaapp.pizza.composable.PizzaScreen
import com.chocolate.pizzaapp.ui.theme.PizzaAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaAppTheme {
                PizzaScreen()
            }
        }
    }
}