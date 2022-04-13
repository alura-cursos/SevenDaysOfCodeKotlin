package br.com.alura.ui.screen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.extensions.loadImageBitmap
import br.com.alura.model.Movie

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesListScreen(movies: List<Movie>) {
    LazyVerticalGrid(cells = GridCells.Adaptive(150.dp)) {
        items(movies) { movie ->
            MovieItem(
                movie
            )
        }
    }
}

@Composable
private fun MovieItem(movie: Movie) {
    Column(
        modifier = Modifier
            .width(200.dp)
            .padding(16.dp)
    ) {
        Image(
            bitmap = movie.image.loadImageBitmap(),
            contentDescription = "capa do filme",
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    top = 8.dp,
                    start = 8.dp,
                    end = 8.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Default.Star,
                    "ícone de estrela para nota",
                    tint = Color.Yellow,
                    modifier = Modifier.height(16.dp)
                )
                Text(
                    movie.rating.toString(),
                    modifier = Modifier
                        .padding(start = 2.dp),
                    color = Color(0xffeeeeee),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                movie.year.toString(),
                fontSize = 14.sp,
                color = Color(0xffeeeeee),
            )
        }
        Text(
            movie.title,
            modifier = Modifier.padding(
                start = 16.dp,
                top = 8.dp,
                end = 16.dp
            ),
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun MovieItemPreview() {
    MovieItem(
        Movie(
            title = "title test",
            image = "https://picsum.photos/200/300",
            rating = 9.2,
            year = 1999
        )
    )
}