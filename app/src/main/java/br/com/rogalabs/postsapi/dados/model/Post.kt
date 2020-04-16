package br.com.rogalabs.postsapi.dados.model

data class Post(
        val userId: Int,
        val id: Int,
        val title: String,
        val body: String
)