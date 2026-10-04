package com.example.basics.e_CheckBox

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
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
fun MultiCheck(){
    var selectedItems by remember { mutableStateOf(setOf<String>()) }

    MultiCheckBox(
        options = listOf("Kotlin", "Java", "Compose", "Flutter", "2"),
        selectedItems=selectedItems,
        onSelectionChange = { selectedItems = it}
    )
}

@Composable
fun MultiCheckBox(options: List<String>, selectedItems: Set<String>, onSelectionChange: (Set<String>) -> Unit) {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        options.forEach { item ->
            Row(modifier = Modifier.clickable{

                onSelectionChange(
                    if(selectedItems.contains(item))
                        selectedItems-item
                    else
                        selectedItems+item
                    )
                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = selectedItems.contains(item),
                    onCheckedChange = null
                )
                Text(item)
            }
        }
    }
}

@Preview (showSystemUi = true)
@Composable
fun Preview9(){
    MultiCheck()
}