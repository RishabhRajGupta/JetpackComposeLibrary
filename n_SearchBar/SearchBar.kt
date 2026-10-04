package com.example.basics.n_SearchBar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsingSearchBar() {
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    val focusManager = LocalFocusManager.current // to clear focus

    val items = listOf(
        "Android",
        "Compose",
        "Kotlin",
        "Instagram",
        "Jetpack"
    )

    val filteredItems = items.filter {
        it.contains(query, ignoreCase = true)
    }

    DockedSearchBar(
        query = query,
        onQueryChange = { query = it },
        onSearch = { active = false },
        active=active,
        onActiveChange = { active = it },
        placeholder = { Text("Search") },
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = null)
        },
        trailingIcon = {
            if (query.isNotEmpty()) {
                IconButton(onClick = {
                    query = ""
                    active = false
                    focusManager.clearFocus() // clears focus
                }) {
                    Icon(Icons.Default.Close, contentDescription = "Clear")
                }
            }
        }
    ) {
        // Suggestions
        if(active){
            LazyColumn {
                items(filteredItems) { item ->
                    Text(
                        text = item,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview21() {
    UsingSearchBar()
}