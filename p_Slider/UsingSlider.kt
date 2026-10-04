package com.example.basics.p_Slider

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UsingSlider(){
    var value by remember { mutableStateOf(50f) }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Slider(
            value = value,
            onValueChange = { value = it },
            valueRange = 0f..100f,
            steps = 9,
            onValueChangeFinished = {
                // called when the user completed selecting the value
                println("Selected value: $value")
            },
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                activeTrackColor = Color.Blue,
                activeTickColor = Color.Green
            )
        )

        Text("Value: ${value.toInt()}")
    }

}



@Preview (showSystemUi = true)
@Composable
fun Preview23(){
    UsingSlider()
}