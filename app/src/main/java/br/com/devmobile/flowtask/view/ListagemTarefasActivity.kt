package br.com.devmobile.flowtask.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.devmobile.flowtask.R
import br.com.devmobile.flowtask.TarefaAdapter
import br.com.devmobile.flowtask.databinding.ActivityListagemTarefasBinding
import br.com.devmobile.flowtask.datalocal.Tarefa
import br.com.devmobile.flowtask.repository.TarefaRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListagemTarefasActivity : AppCompatActivity() {

    private val binding by lazy{ ActivityListagemTarefasBinding.inflate(layoutInflater) }

    private val tarefaAdapter by lazy { TarefaAdapter() }
    private val tarefaRepository by lazy { TarefaRepository(this) }
    private var tarefas = mutableListOf<Tarefa>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        getListTarefa()




        Log.i("TAG", "onCreate: "+tarefas.size)

        binding.floatingActionButtonAddTarefas.setOnClickListener {
             startActivity(Intent(this, AdicionarTarefasActivity::class.java))
             overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out )
        }

    }

    override fun onStart() {
        super.onStart()
        getListTarefa()
    }

    fun getListTarefa(){

        CoroutineScope(Dispatchers.IO).launch {
           tarefas = tarefaRepository.listarTarefas() as MutableList<Tarefa>

            withContext(Dispatchers.Main){
                 if(tarefas.isNotEmpty()){
                     binding.rvTarefas.layoutManager = LinearLayoutManager(application)
                     binding.rvTarefas.adapter = tarefaAdapter
                     tarefaAdapter.addLista( tarefas )
                 }
            }
        }

    }
}