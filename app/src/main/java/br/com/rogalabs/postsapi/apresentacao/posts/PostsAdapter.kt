package br.com.rogalabs.postsapi.apresentacao.posts


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.rogalabs.postsapi.R
import br.com.rogalabs.postsapi.dados.model.Post
import kotlinx.android.synthetic.main.item_post.view.*

class PostsAdapter(
        private val posts: List<Post>,
        private val onItemClickListener: ((book: Post) -> Unit)
) : RecyclerView.Adapter<PostsAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): BooksViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return BooksViewHolder(itemView, onItemClickListener)
    }

    override fun getItemCount() = posts.count()

    override fun onBindViewHolder(viewHolder: BooksViewHolder, position: Int) {
        viewHolder.bindView(posts[position])
    }

    class BooksViewHolder(
            itemView: View,
            private val onItemClickListener: ((book: Post) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {

        private val title = itemView.textTitle
        private val textPost = itemView.textPost

        fun bindView(book: Post) {
            title.text = book.title
            textPost.text = book.body

            itemView.setOnClickListener {
               onItemClickListener.invoke(book)
            }
        }
    }
}