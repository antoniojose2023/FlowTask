package br.com.devmobile.flowtask

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.devmobile.flowtask.databinding.ItemTarefaBinding
import br.com.devmobile.flowtask.datalocal.Tarefa

class TarefaAdapter(var onClickTarefa: (Tarefa)-> Unit = {}): RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

    private var tarefas = mutableListOf<Tarefa>()

    @SuppressLint("NotifyDataSetChanged")
    fun addLista(lista: MutableList<Tarefa>){
         this.tarefas = lista
         notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TarefaViewHolder {
          val inflate = LayoutInflater.from(parent.context)
          val binding= ItemTarefaBinding.inflate( inflate, parent, false )
          return TarefaViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: TarefaViewHolder,
        position: Int
    ) {
        val tarefa = tarefas[position]
        holder.bind( tarefa )
    }

    override fun getItemCount() = tarefas.size


    inner class TarefaViewHolder(val binding: ItemTarefaBinding): RecyclerView.ViewHolder(binding.root){

        @SuppressLint("ResourceAsColor")
        fun bind(tarefa: Tarefa){
             binding.apply {
                   tvTituloTarefa.text = tarefa.titulo
                   tvCategoria.text = tarefa.descricao
                   tvData.text = tarefa.data
             }

             when(tarefa.prioridade){
                   "Baixa" -> {
                        binding.tvPrioridade.setBackgroundResource( R.drawable.fundo_text_prioridade_baixa )
                        binding.tvPrioridade.text = tarefa.prioridade
                   }
                   "Media" -> {
                       binding.tvPrioridade.setBackgroundResource( R.drawable.fundo_text_prioridade_media )
                       binding.tvPrioridade.text = tarefa.prioridade
                   }
                   "Alta" -> {
                       binding.tvPrioridade.setBackgroundResource( R.drawable.fundo_text_prioridade_alta )
                       binding.tvPrioridade.text = tarefa.prioridade
                   }
             }

             itemView.setOnClickListener {
                  onClickTarefa(tarefa)
             }

        }

    }

}