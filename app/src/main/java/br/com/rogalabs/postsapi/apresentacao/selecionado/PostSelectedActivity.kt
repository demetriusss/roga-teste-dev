package br.com.rogalabs.postsapi.apresentacao.selecionado


import android.content.Context
import android.content.Intent
import android.os.Bundle
import br.com.rogalabs.postsapi.R
import br.com.rogalabs.postsapi.apresentacao.base.BaseActivity
import kotlinx.android.synthetic.main.activity_selecionado.*
import kotlinx.android.synthetic.main.include_toolbar.*

class PostSelectedActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selecionado)

        setupToolbar(toolbarMain, R.string.titulo_secundario, true)

        postTitle.text = intent.getStringExtra(EXTRA_TITLE)
        postDescription.text = intent.getStringExtra(EXTRA_DESCRIPTION)

    }

    companion object {
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"
        private const val EXTRA_ID = "EXTRA_ID"

        fun getStartIntent(context: Context, title: String, description: String, id:Int): Intent {
            return Intent(context, PostSelectedActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION, description)
                putExtra(EXTRA_ID, id)
            }
        }
    }
}
