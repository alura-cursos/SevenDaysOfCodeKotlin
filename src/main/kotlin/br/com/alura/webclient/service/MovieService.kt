package br.com.alura.webclient.service

import br.com.alura.webclient.IMDB_API_KEY
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {

    @GET(IMDB_API_KEY)
    fun findTop250Movies(): Call<ResponseBody>

}