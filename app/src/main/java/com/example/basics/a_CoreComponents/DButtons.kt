package com.example.basics.a_CoreComponents

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

// Filled Button
@Composable
fun ButtonSimple(){
    val context = LocalContext.current

    Box(
        modifier= Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column{

            // Filled Button
            Button(
                onClick = {
                    Toast.makeText(context, "Filled Button Clicked", Toast.LENGTH_SHORT).show()
                }
            ){
                Text("Filled Button")
            }

            // Filled Tonal Button
            FilledTonalButton(
                onClick = {
                    Toast.makeText(context, "Filled Tonal Button Clicked", Toast.LENGTH_SHORT).show()
                }
            ){
                Text("Filled Tonal Button")
            }

            // Outlined Button
            OutlinedButton(
                onClick = {
                    Toast.makeText(context, "Outlined Button Clicked", Toast.LENGTH_SHORT).show()
                }
            ){
                Text("Outlined Button")
            }

            // Elevated Button
            ElevatedButton(
                onClick = {
                    Toast.makeText(context, "Elevated Button Clicked", Toast.LENGTH_SHORT).show()
                }
            ){
                Text("Elevated Button")
            }

            // Text Button
            TextButton(
                onClick = {
                    Toast.makeText(context, "Text Button Clicked", Toast.LENGTH_SHORT).show()
                }
            ){
                Text("Text Button")
            }
        }
    }
}

@Preview (showSystemUi = true)
@Composable
fun Preview4(){
    ButtonSimple()
}