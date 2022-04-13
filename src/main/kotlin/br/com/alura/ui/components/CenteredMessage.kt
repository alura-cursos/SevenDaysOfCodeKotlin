package br.com.alura.ui.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun CenteredMessage(text: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text, fontSize = 18.sp)
    }
}

@Preview
@Composable
fun CenteredMessagePreview() {
    CenteredMessage("Test message...")
}