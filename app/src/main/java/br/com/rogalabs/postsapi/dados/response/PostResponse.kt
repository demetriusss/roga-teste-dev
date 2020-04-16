package br.com.rogalabs.postsapi.dados.response

import br.com.rogalabs.postsapi.dados.model.Post
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostResponse(

        @Json(name = "userId")
        val userId: Int,
        @Json(name = "id")
        val id: Int,
        @Json(name = "title")
        val title: String,
        @Json(name = "body")
        val body: String
) {
    fun getPostModel() = Post(
            userId = this.userId,
            id = this.id,
            title = this.title,
            body = this.body
    )
}