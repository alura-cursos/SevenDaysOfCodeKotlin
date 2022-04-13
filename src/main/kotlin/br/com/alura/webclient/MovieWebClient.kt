package br.com.alura.webclient

import br.com.alura.webclient.model.toMovie
import kotlinx.coroutines.flow.flow

class MovieWebClient {

    private val service = RetrofitInit().movieService

    fun findTop250Movies() = flow {
        val result = try {
            val movies = service.findTop250Movies()
                .items.map { it.toMovie() }
            println("movies loaded $movies")
            Status.Success(movies)
        } catch (e: Exception) {
            println("exception loaded")
            Status.Error(e)
        }
        emit(result)
    }
}

sealed class Status<out R> {
    data class Success<out T>(val data: T) : Status<T>()
    data class Error(val exception: Exception) : Status<Nothing>()
    object Loading : Status<Nothing>()
}