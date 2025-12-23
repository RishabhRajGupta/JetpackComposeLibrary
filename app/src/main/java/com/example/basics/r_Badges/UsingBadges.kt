package com.example.basics.r_Badges

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CartWithBadgeExample() {

    var cartCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        BadgedBox(
            badge = {
                if (cartCount > 0) {
                    Badge {
                        Text(cartCount.toString())
                    }
                }
            }
        ) {
            Icon(
                Icons.Default.ShoppingCart,
                contentDescription = "Cart",
                modifier = Modifier.size(48.dp)
            )
        }

        Button(
            onClick = { cartCount++ }
        ) {
            Text("Add to Cart")
        }
    }
}


@Preview (showSystemUi = true)
@Composable
fun Preview25(){
    CartWithBadgeExample()
}