package com.example.basics.a_CoreComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun SimpleText(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text("Hello Jetpack Compose",
            color = Color.Blue,
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                shadow= Shadow(color = Color.Black, blurRadius = 7f)
            )
        )
    }
}

@Composable
fun ColorFullText(){
    val rainbowColors = listOf(
        Color.Blue,
        Color.Cyan,
        Color.Green,
        Color.Yellow,
        Color.Red
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = buildAnnotatedString{
                append("Do not allow people to dim your shine \n")
                withStyle(
                    SpanStyle(
                        brush = Brush.linearGradient(
                            colors = rainbowColors
                        )
                    )
                ){
                    append("because they are blinded.")
                }
                append("\n tell them to put some sunglasses on")
            }
        )
    }
}

@Composable
fun ScrollableText(){

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text="Hey this is Rishabh Raj Gupta, experimenting with Jetpack Compose".repeat(50),
            maxLines = 2,
//            modifier = Modifier.basicMarquee() -> for animation of text
            overflow = TextOverflow.Ellipsis,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview1(){
    ScrollableText()
}