package br.com.devmobile.flowtask.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.devmobile.flowtask.R
import br.com.devmobile.flowtask.databinding.ActivityListagemTarefasBinding

class ListagemTarefasActivity : AppCompatActivity() {

    private val binding by lazy{ ActivityListagemTarefasBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.floatingActionButtonAddTarefas.setOnClickListener {
             startActivity(Intent(this, AdicionarTarefasActivity::class.java))
             overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out )
        }

    }
}