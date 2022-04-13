package br.com.alura.webclient.service

import br.com.alura.webclient.IMDB_API_KEY
import br.com.alura.webclient.model.Top250Data
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {

    @GET(IMDB_API_KEY)
    suspend fun findTop250Movies(): Top250Data

}