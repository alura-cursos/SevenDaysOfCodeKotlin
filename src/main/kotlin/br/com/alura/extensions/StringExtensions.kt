package br.com.alura.extensions

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import org.jetbrains.skia.Image
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.net.URL
import javax.imageio.ImageIO

fun String.loadImageBitmap(): ImageBitmap {
    val inputStream = BufferedInputStream(
        URL(this).openStream()
    )
    val bufferedImage = ImageIO.read(inputStream)

    val stream = ByteArrayOutputStream()
    ImageIO.write(bufferedImage, "png", stream)
    val byteArray = stream.toByteArray()

    return Image.makeFromEncoded(byteArray).toComposeImageBitmap()
}