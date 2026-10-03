package br.com.devmobile.flowtask.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.devmobile.flowtask.R
import br.com.devmobile.flowtask.databinding.ActivityAdicionarTarefasBinding
import br.com.devmobile.flowtask.datalocal.Tarefa
import br.com.devmobile.flowtask.repository.TarefaRepository
import com.google.android.material.chip.Chip
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AdicionarTarefasActivity : AppCompatActivity() {
    private val binding by lazy{ ActivityAdicionarTarefasBinding.inflate( layoutInflater ) }

    private var prioridade = ""
    private  var tarefa: Tarefa = Tarefa()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tarefaRepository by lazy{
            TarefaRepository(this)
        }

        binding.chipGrupo.setOnCheckedStateChangeListener { group, idChipPrioridade ->
                if(idChipPrioridade.isNotEmpty()){
                      val chip = group.findViewById<Chip>(idChipPrioridade.first())
                      prioridade = chip.text.toString()
                }
        }


        binding.btSalvaTarefa.setOnClickListener {
            val task = validaTarefa()

            CoroutineScope(Dispatchers.IO).launch {
                val retorno = tarefaRepository.salvar( task )

                withContext(Dispatchers.Main){
                     if(retorno > 0){
                           Toast.makeText(application, "Tarefa salva com sucesso", Toast.LENGTH_SHORT).show()
                     }else{
                           Toast.makeText(application, "Erro ao tentar salvar tarefa", Toast.LENGTH_SHORT).show()
                     }
                }
            }
        }


    }

    fun validaTarefa(): Tarefa{

        val titulo = binding.editTituloTarefa.text.toString()
        val descricao = binding.editDesricaoTarefa.text.toString()
        val data = binding.editDataTarefa.text.toString()
        val hora = binding.editHoratarefa.text.toString()

        if(titulo.isNotEmpty() && descricao.isNotEmpty() && data.isNotEmpty() && hora.isNotEmpty() && prioridade.isNotEmpty()){
              tarefa = Tarefa(0, titulo, descricao, data, hora, prioridade)
        }else{
              Toast.makeText(this, "Existem campos vázios", Toast.LENGTH_SHORT).show()
        }

        return tarefa

    }
}