package com.example.basics.c_BottomSheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun modalBottomSheet() {

    // whether the sheet will be visible on screen or not
    var showBottomSheet by remember {
        mutableStateOf(false)
    }
    // whether the bottom sheet will cover whole screen or half
    var showSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                showBottomSheet = true
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Yellow,
                containerColor = Color.Gray
            )
        ) {
            Text(
                text = "This is Modal Bottom Sheet",
                modifier = Modifier.padding(10.dp),
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic
            )
        }

    }
    if (showBottomSheet) {
        ModalBottomSheet(
            modifier = Modifier.fillMaxSize(),
            sheetState = showSheetState,
            onDismissRequest = {
                showBottomSheet = false
            }
        ){
            Text(
                modifier = Modifier.padding(16.dp),
                text = "You have successfull made bottom sheet"
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun Preview5() {
    modalBottomSheet()
}