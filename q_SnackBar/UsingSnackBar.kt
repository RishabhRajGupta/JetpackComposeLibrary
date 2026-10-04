package com.example.basics.q_SnackBar

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@Composable
fun UsingSnackBar() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) { padding ->
        Box(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentAlignment = Alignment.Center
        ){
            Button(
                onClick = {
                    scope.launch {
                        val result = snackbarHostState.showSnackbar(
                            message = "Item Deleted",
                            actionLabel = "UNDO",
                            duration = SnackbarDuration.Short
                        )

                        if(result == SnackbarResult.ActionPerformed){
                            Toast.makeText(context, "Item Restored", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            ) {
                Text("Delete")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview24() {
    UsingSnackBar()
}