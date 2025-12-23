package com.example.basics.b_LayoutComposables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ColumnExample(){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("This is line 1")
        Text("This is line 2")
        Text("This is line 3")
        Text("This is line 4")
        Text("This is line 5")
        Text("This is line 6")
    }
}

@Composable
fun RowExample(){

    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("This is line 1")
        Text("This is line 2")
        Text("This is line 3")
        Text("This is line 4")
        Text("This is line 5")
        Text("This is line 6")
    }
}

@Composable
fun lazyColumnExample(){
    Column{
        Text("Lazy column preferred for the lists")

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
                .height(200.dp)
                .background(Color.LightGray)
        ) {
            items(100){
                index ->
                Text(
                    text="Item $index in lazyColumn",
                    modifier=Modifier.fillMaxWidth().padding(16.dp).background(Color.White)
                )
            }
        }
    }
}

@Composable
fun ConstraintLayoutExample(){

    ConstraintLayout(
        modifier = Modifier.fillMaxSize().background(color = Color.Gray)
    ) {

        val (text1, text2, text3) = createRefs()

        Text("Text 1",
            modifier=Modifier.constrainAs(text1){
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            })

        Text("Text 2",
            modifier=Modifier.constrainAs(text2){
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

        Text("Text 3",
            modifier=Modifier.constrainAs(text3){
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
            })
    }
}

@Preview (showSystemUi = true)
@Composable
fun Preview5(){
    ConstraintLayoutExample();
}