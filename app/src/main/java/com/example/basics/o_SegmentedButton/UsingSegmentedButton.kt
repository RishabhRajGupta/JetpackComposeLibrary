package com.example.basics.o_SegmentedButton

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsWalk
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.DirectionsTransit
import androidx.compose.material3.Icon
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

enum class TravelMode{
    WALK,
    CAR,
    TRAIN
}

@Composable
fun UsingSegmentedButton(){
    val selectedOptions = remember {
        mutableStateListOf(false, false, false)
    }

    val options = TravelMode.entries.map { it.name }

    Box(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        contentAlignment = Alignment.BottomEnd
    ){
        MultiChoiceSegmentedButtonRow {
            options.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(
                        index=index,
                        count = options.size
                    ),
                    checked = selectedOptions[index],
                    onCheckedChange = {
                        selectedOptions[index] = !selectedOptions[index]
                    },
                    icon = {
                        SegmentedButtonDefaults.Icon(selectedOptions[index])
                    },
                    label = {
                        when(label){
                            "WALK" -> Icon(imageVector = Icons.AutoMirrored.Filled.DirectionsWalk, contentDescription = "Walk")
                            "CAR" -> Icon(Icons.Default.DirectionsCar, contentDescription = "Car")
                            "TRAIN" -> Icon(Icons.Default.DirectionsTransit, contentDescription = "Train")
                        }
                    }
                )
            }
        }
    }
}

@Preview (showSystemUi = true)
@Composable
fun Preview22(){
    UsingSegmentedButton()
}