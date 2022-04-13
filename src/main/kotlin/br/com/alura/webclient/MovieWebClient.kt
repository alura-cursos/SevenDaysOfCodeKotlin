package br.com.alura.webclient

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieWebClient {

    private val service = RetrofitInit().movieService

    fun findTop250Movies() {
        service.findTop250Movies().enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(
                call: Call<ResponseBody?>,
                response: Response<ResponseBody?>
            ) {
                println(response.body()?.string())
            }

            override fun onFailure(
                call: Call<ResponseBody?>,
                t: Throwable
            ) {

            }
        })
    }

}