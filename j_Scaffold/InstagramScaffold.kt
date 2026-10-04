package com.example.basics.j_Scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AddToQueue
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InstagramScaffold(){
    Scaffold(
        topBar = {
            InstagramTopBar()
        },
        bottomBar = {
            InstagramBottomBar()
        }
    ) { padding ->
        InstagramFeed(
            modifier = Modifier.padding(padding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramTopBar(){
    TopAppBar(
        title = {
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Instagram",
                    style = MaterialTheme.typography.titleLarge
                )
                IconButton(onClick = { },
                ) {
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Down Arrow")
                }
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(Icons.Default.FavoriteBorder, contentDescription = "Notifs")
            }
            IconButton(onClick = { }) {
                Icon(Icons.AutoMirrored.Filled.Send, contentDescription = "Messages")
            }
        }
    )
}

@Composable
fun InstagramBottomBar(){
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = {Icon(Icons.Default.Home, null)}
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {Icon(Icons.Default.Search, null)}
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {Icon(Icons.Default.AddToQueue, null)}
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {Icon(Icons.Default.PlayCircle, null)}
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {Icon(Icons.Default.Person, null)}
        )
    }
}

@Composable
fun InstagramFeed(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
    ) {
        items(20) { index ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Post #$index",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .background(Color.LightGray)
                )
            }
        }
    }
}



@Preview (showSystemUi = true)
@Composable
fun Preview15(){
    InstagramScaffold()
}