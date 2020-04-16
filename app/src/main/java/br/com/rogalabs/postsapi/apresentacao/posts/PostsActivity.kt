package br.com.rogalabs.postsapi.apresentacao.posts


import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.rogalabs.postsapi.R
import br.com.rogalabs.postsapi.apresentacao.base.BaseActivity
import br.com.rogalabs.postsapi.apresentacao.selecionado.PostSelectedActivity
import kotlinx.android.synthetic.main.activity_posts.*
import kotlinx.android.synthetic.main.include_toolbar.*

class PostsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        setupToolbar(toolbarMain, R.string.titulo_principal)

        val viewModel: PostsViewModel = ViewModelProvider(this).get(PostsViewModel::class.java)

        viewModel.postsLiveData.observe(this, Observer {
            it?.let {books -> with(recyclerBooks){
                layoutManager= LinearLayoutManager(this@PostsActivity, RecyclerView.VERTICAL, false)
                setHasFixedSize(true)
                adapter = PostsAdapter(books){ book->
                    val intent = PostSelectedActivity.getStartIntent(this@PostsActivity, book.title, book.body, book.id)
                    this@PostsActivity.startActivity(intent)
                }
            }

            }
        })

        viewModel.trasDados()

    }

}
