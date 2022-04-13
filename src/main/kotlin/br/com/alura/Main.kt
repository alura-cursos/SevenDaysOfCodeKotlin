package br.com.alura

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import br.com.alura.extensions.loadImageBitmap

@Composable
@Preview
fun App() {
    val image =
        "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX674_.jpg"
    MaterialTheme {
        Column {
            Text("The Shawshank Redemption")
            Image(
                bitmap = image.loadImageBitmap(),
                contentDescription = "capa do filme",
                modifier = Modifier.height(200.dp)
            )
            Text("Nota: 9.2 - Ano: 1994")
        }
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "IMDB"
    ) {
        App()
    }
}
