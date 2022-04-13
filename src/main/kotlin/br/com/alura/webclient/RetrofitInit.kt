package br.com.alura.webclient

import br.com.alura.webclient.service.MovieService
import retrofit2.Retrofit

class RetrofitInit {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://imdb-api.com/API/Top250Movies/")
        .build()

    val movieService: MovieService
        get() = retrofit.create(MovieService::class.java)

}