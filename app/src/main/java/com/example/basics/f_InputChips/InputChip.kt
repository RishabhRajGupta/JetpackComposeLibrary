package com.example.basics.f_InputChips

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
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
fun MakingInputChip() {
    var enable by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        InputChip(
            onClick = {
                enable = !enable
            },
            label = { Text(if (enable) "Remove English" else "English") },
            selected = enable,
            avatar = {
                if (!enable) {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "Just descrip",
                        modifier = Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            },
            trailingIcon = {
                if (enable) {
                    Icon(
                        Icons.Filled.Close,
                        contentDescription = "Just close",
                        modifier = Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            }
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MultiInputChips() {
    val languages = listOf("Kotlin", "Java", "Python", "C++", "Rust", "React", "Go")
    var selectedItems by remember { mutableStateOf(setOf<String>()) }

    FlowRow(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.Center
    ) {
        val sortedLanguages =
            languages.filter { selectedItems.contains(it) } +
                    languages.filter { !selectedItems.contains(it) }

        sortedLanguages.forEach { item ->
            InputChip(
                onClick = {
                    selectedItems =
                        if (selectedItems.contains(item))
                            selectedItems - item
                        else
                            selectedItems + item
                },
                selected = selectedItems.contains(item),
                label = { Text(item) },

                avatar = {
                    if (!selectedItems.contains(item)) {
                        Icon(
                            Icons.Filled.Add,
                            contentDescription = "Add",
                            modifier = Modifier.size(InputChipDefaults.AvatarSize)
                        )
                    }
                },

                trailingIcon = {
                    if (selectedItems.contains(item)) {
                        Icon(
                            Icons.Filled.Close,
                            contentDescription = "Remove",
                            modifier = Modifier.size(InputChipDefaults.AvatarSize)
                        )
                    }
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview10() {
    MultiInputChips()
}
