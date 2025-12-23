package com.example.basics.k_NavigationDrawer

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MakingNavigationDrawer() {

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    var clicked by remember { mutableStateOf("Home") }

    ModalNavigationDrawer(
        drawerState=drawerState,
        drawerContent = {
            DrawerContent { item ->
                scope.launch {
                    drawerState.close()
                    clicked=item
                    Toast.makeText(context, "Clicked: $item", Toast.LENGTH_SHORT).show()
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {Text(clicked)},
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch { drawerState.open() }
                            }
                        ) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { padding ->
            Text(
                "Main Screen Content",
                modifier = Modifier.padding(padding)
            )
        }
    }
}

@Composable
fun DrawerContent(
    onItemClick: (String) -> Unit
) {
    ModalDrawerSheet {
        Text(
            "My App",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.titleLarge
        )

        NavigationDrawerItem(
            label = {Text("Home")},
            selected = false,
            onClick = { onItemClick("Home") }
        )
        NavigationDrawerItem(
            label = {Text("Profile")},
            selected = false,
            onClick = { onItemClick("Profile") }
        )
        NavigationDrawerItem(
            label = {Text("Settings")},
            selected = false,
            onClick = { onItemClick("Settings") }
        )
    }
}


@Preview (showSystemUi = true)
@Composable
fun NavDrawerPreview(){
    MakingNavigationDrawer()
}


