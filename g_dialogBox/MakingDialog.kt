package com.example.basics.g_dialogBox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun MakingAlertDialog(){
    var showDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){

        Button(
            onClick = {
                showDialog = true
            }
        ) { Text("Show Dialog") }
    }

    if(showDialog){
        AlertDialog(
            onDismissRequest = {
                showDialog = false
            },
            title = {
                Text("Delete Item?")
            },
            text = {
                Text("This action cannot be undone.")
            },
            confirmButton = {
                TextButton(
                    onClick = {showDialog=false}
                ) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(onClick = {showDialog=false}) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
fun MakingCustomDialog(){
    var showDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = {
                showDialog = true
            }
        ) { Text("Show Dialog") }
    }

    if (showDialog){
        Dialog(
            onDismissRequest = {showDialog=false}
        ) {
            Card(
                shape = RoundedCornerShape(16.dp)
            ){
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text("Custom Dialog", style = MaterialTheme.typography.titleMedium)

                    Text("This is fully custom dialog.")

                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        TextButton(onClick = {showDialog=false}) {
                            Text("Cancel")
                        }
                        TextButton(onClick = {showDialog=false}) {
                            Text("Ok")
                        }
                    }
                }
            }
        }
    }
}

@Preview (showSystemUi = true)
@Composable
fun Preview12(){
    MakingCustomDialog()
}