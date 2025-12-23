package com.example.basics.e_CheckBox

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MakingCheckBox() {

    var isChecked by remember {
        mutableStateOf(false)
    }
    val childCheckedState = remember {
        mutableListOf(false, false, false)
    }

    val parentCheckedState = when {
        childCheckedState.all { it } -> ToggleableState.On
        childCheckedState.none() -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.clickable { // puuri row clickable bann gyi
                isChecked = !isChecked
            },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = null,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    uncheckedColor = Color.Gray,
                    checkmarkColor = Color.White
                )
            )
            Text(
                text = "Accept Terms & Conditions",
                modifier = Modifier.padding(5.dp)
            )
        }
        Button(
            onClick = { },
            enabled = isChecked // if checkBox is checked then only the button will work
        ) {
            Text("Submit")
        }
    }


}

@Composable
fun TermsCheckBox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.padding(30.dp).clickable {
            onCheckedChange(!checked)
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = null,
        )
        Text("Accept Terms")
    }

}

@Preview(showSystemUi = true)
@Composable
fun Preview8() {
    var checked by remember { mutableStateOf(false) }
    TermsCheckBox(
        checked=checked,
        onCheckedChange = {checked=it}
    )
}