package com.example.basics.h_ExtendedFAB

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MakingEtendedFAB(){

    val expanded by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        ExtendedFloatingActionButton(
            onClick = { },
            expanded=expanded,
            icon = {
                Icon(Icons.Default.Add, contentDescription = "Add")
            },
            text = {
                Text("Add")
            },
            elevation = FloatingActionButtonDefaults.elevation(
                defaultElevation = 6.dp
            )
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview11(){
    MakingEtendedFAB()
}