package com.example.basics.a_CoreComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PartiallySelectableText() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        SelectionContainer {
            Column {
                Text("This is selectable text 1")
                Text("This is selectable text 2")
                Text("This is selectable text 3")

                DisableSelection {
                    Text("This text is not selectable")
                    Text("This text is also not selectable")
                }
            }
        }
    }
}

@Composable
fun AnnotatedStringWithListenerSample() {
    val uriHandler = LocalUriHandler.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            buildAnnotatedString {
                append("You can check out my ")
                val link = LinkAnnotation.Url(
                    "https://www.linkedin.com/in/rishabh-raj-gupta-6a3860324",
                    TextLinkStyles(
                        SpanStyle(
                            color = Color.Blue
                        )
                    )
                ) {
                    val url = (it as LinkAnnotation.Url).url
                    uriHandler.openUri(url)
                }
                withLink(link) {
                    append("LinkedIn Profile")
                }
            }
        )
    }
}

@Preview (showSystemUi = true)
@Composable
private fun Preview3() {
    AnnotatedStringWithListenerSample()
}