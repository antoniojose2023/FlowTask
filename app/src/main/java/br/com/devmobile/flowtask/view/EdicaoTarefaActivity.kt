package br.com.devmobile.flowtask.view

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.devmobile.flowtask.R
import br.com.devmobile.flowtask.databinding.ActivityEdicaoTarefaBinding
import br.com.devmobile.flowtask.datalocal.Tarefa
import br.com.devmobile.flowtask.repository.TarefaRepository
import com.google.android.material.chip.Chip
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EdicaoTarefaActivity : AppCompatActivity() {
    private val binding by lazy{ ActivityEdicaoTarefaBinding.inflate(layoutInflater) }

    private lateinit var tarefa: Tarefa

    private var prioridade = ""

    private val tarefaRepository by lazy{
        TarefaRepository(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.ivVoltar.setOnClickListener {
              finish()
        }


        val bunble = intent.extras
        if(bunble != null){
             tarefa = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                   bunble.getSerializable("tarefa", Tarefa::class.java) as Tarefa
             }else{
                   bunble.getSerializable("tarefa") as Tarefa
             }

              popularTelaEdicao(tarefa)
              verificarChipMarcado()
        }


        binding.chipGrupo.setOnCheckedStateChangeListener { group, idChipPrioridade ->
            if(idChipPrioridade.isNotEmpty()){
                val chip = group.findViewById<Chip>(idChipPrioridade.first())
                prioridade = chip.text.toString()
            }
        }


        binding.btEditaTarefa.setOnClickListener {
              atualizarTarefa()
        }

        binding.btExcluir.setOnClickListener {
             deleteTarefa(tarefa)
        }

    }


    fun verificarChipMarcado(){

        prioridade = tarefa.prioridade!!

        when(prioridade){
            "Baixa" -> {
                binding.chipBaixa.isChecked = true
            }
            "Media" -> {
                binding.chipMedia.isChecked = true
            }
            "Alta" -> {
                binding.chipAlta.isChecked = true
            }
        }
    }



    fun popularTelaEdicao(tarefa: Tarefa){

          binding.editTituloTarefa.setText( tarefa.titulo )
          binding.editDesricaoTarefa.setText( tarefa.descricao )
          binding.editDataTarefa.setText( tarefa.data )
          binding.editHoratarefa.setText( tarefa.hora )


          binding.chipGrupo.checkedChipId.let { id->
              val texto =  if(id != -1) findViewById<Chip>(id).text else "Nenhum"

              when(texto){
                  "Baixa" -> {
                      binding.chipBaixa.isChecked = true
                  }
                  "Media" -> {
                      binding.chipMedia.isChecked = true
                  }
                  "Alta" -> {
                      binding.chipAlta.isChecked = true
                  }
              }
          }

    }


    fun atualizarTarefa(){

      val titulo= binding.editTituloTarefa.text.toString()
      val descricao= binding.editDesricaoTarefa.text.toString()
      val data = binding.editDataTarefa.text.toString()
      val hora = binding.editHoratarefa.text.toString()

      if(prioridade.isNotEmpty()){
          if(titulo.isNotEmpty() && descricao.isNotEmpty() && data.isNotEmpty() && hora.isNotEmpty()){


              CoroutineScope(Dispatchers.IO).launch {
                  tarefa =  Tarefa(tarefa.id,titulo, descricao, data, hora, prioridade)
                  val retorno = tarefaRepository.atualizar( tarefa )

                  withContext(Dispatchers.Main){
                      if(retorno > 0){
                          Toast.makeText(application, "Atualizado com sucesso", Toast.LENGTH_LONG).show()
                          finish()
                      }else{
                          Toast.makeText(application, "Erro ao tentar atualizar", Toast.LENGTH_LONG).show()
                      }
                  }
              }
          }else{
              Toast.makeText(application, "Existem campos vázios", Toast.LENGTH_SHORT).show()
          }
      }else{
          if(titulo.isNotEmpty() && descricao.isNotEmpty() && data.isNotEmpty() && hora.isNotEmpty()){


              CoroutineScope(Dispatchers.IO).launch {
                  tarefa = Tarefa(tarefa.id,titulo, descricao, data, hora, tarefa.prioridade)
                  val retorno = tarefaRepository.atualizar( tarefa )

                  withContext(Dispatchers.Main){
                      if(retorno > 0){
                          Toast.makeText(application, "Atualizado com sucesso", Toast.LENGTH_LONG).show()
                          finish()
                      }else{
                          Toast.makeText(application, "Erro ao tentar atualizar", Toast.LENGTH_LONG).show()
                      }
                  }
              }
          }else{
              Toast.makeText(application, "Existem campos vázios", Toast.LENGTH_SHORT).show()
          }
      }

    }


    fun deleteTarefa(tarefa: Tarefa){

        CoroutineScope(Dispatchers.IO).launch {

             val retorno = tarefaRepository.delete( tarefa )

            withContext(Dispatchers.Main){
                 if(retorno > 0){
                      Toast.makeText(application, "Excluido com sucesso", Toast.LENGTH_LONG).show()
                      finish()
                 }else{
                      Toast.makeText(application, "Erro ao tentar excluir", Toast.LENGTH_LONG).show()
                 }
            }

        }

    }


}