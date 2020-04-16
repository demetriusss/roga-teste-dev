package br.com.rogalabs.postsapi.dados.response
import br.com.rogalabs.postsapi.dados.model.Comment
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ComentResponse(

        @Json(name = "postId")
        val postId: Int,
        @Json(name = "id")
        val id: Int,
        @Json(name = "name")
        val name: String,
        @Json(name = "email")
        val email: String,
        @Json(name = "body")
        val body: String
) {
    fun getCommentModel() = Comment(
            postId = this.postId,
            id = this.id,
            name = this.name,
            email = this.email,
            body = this.body
    )
}