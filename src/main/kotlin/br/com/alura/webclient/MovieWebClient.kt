package br.com.alura.webclient

import br.com.alura.model.Movie
import br.com.alura.webclient.model.Top250Data
import br.com.alura.webclient.model.toMovie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieWebClient {

    private val service = RetrofitInit().movieService

    fun findTop250Movies(onSuccess: (movies: List<Movie>) -> Unit) {
        service.findTop250Movies().enqueue(object : Callback<Top250Data?> {
            override fun onResponse(
                call: Call<Top250Data?>,
                response: Response<Top250Data?>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { data ->
                        val movies = data.items.map { detail ->
                            detail.toMovie()
                        }
                        onSuccess(movies)
                    }
                }

            }

            override fun onFailure(
                call: Call<Top250Data?>,
                t: Throwable
            ) {

            }
        })
    }

}