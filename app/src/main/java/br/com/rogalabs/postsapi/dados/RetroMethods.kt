package br.com.rogalabs.postsapi.dados
import br.com.rogalabs.postsapi.dados.model.Comment
import br.com.rogalabs.postsapi.dados.response.PostResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroMethods {

    @GET("/posts")
    fun getPosts(): Call<List<PostResponse>>

    @GET("/posts/{id}/comments")
    fun getComments(@Query("id") id: Int?): Call<List<Comment>>?
}