package br.com.rogalabs.postsapi.apresentacao.posts


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.rogalabs.postsapi.dados.ApiRetro
import br.com.rogalabs.postsapi.dados.model.Post
import br.com.rogalabs.postsapi.dados.response.PostResponse
import retrofit2.Call
import retrofit2.Callback;
import retrofit2.Response

class PostsViewModel : ViewModel (){

    val postsLiveData: MutableLiveData<List<Post>> = MutableLiveData()

    fun trasDados(){
        ApiRetro.service.getPosts().enqueue(object : Callback<List<PostResponse>>{
            override fun onFailure(call: Call<List<PostResponse>>, t: Throwable) {
                    Log.i("deu errado", t.message.toString())
            }
            override fun onResponse(
                    call: Call<List<PostResponse>>,
                    response: Response<List<PostResponse>>
            ) {
                if (response.isSuccessful()){
                    val posts: MutableList<Post> = mutableListOf()
                    response.body()?.let { bookBodyResponse ->
                        for (results in bookBodyResponse){
                            Log.i("requisição chegou","chegou mesmo")
                        val post : Post = Post(
                            userId = results.userId,
                                id = results.id,
                            title = results.title,
                            body = results.body
                        )
                     posts.add(post)
                    }
                    }
                    postsLiveData.value = posts
                }
            }

        })
    }

}