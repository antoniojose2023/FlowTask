package br.com.devmobile.flowtask.repository

import android.content.Context
import br.com.devmobile.flowtask.datalocal.DatabaseRoom
import br.com.devmobile.flowtask.datalocal.Tarefa
import br.com.devmobile.flowtask.view.ListagemTarefasActivity

class TarefaRepository(context: Context) {

    val dbTarefa = DatabaseRoom.getInstance( context )
    val tarefaDao = dbTarefa.tarefaDao()

    suspend fun salvar(tarefa: Tarefa): Long{
          return tarefaDao.salvar( tarefa )
    }

    suspend fun delete(tarefa: Tarefa): Int{
        return tarefaDao.delete( tarefa )
    }

    suspend fun atualizar(tarefa: Tarefa): Int{
        return tarefaDao.atualizar( tarefa )
    }

    suspend fun listarTarefas(): List<Tarefa>{
          return tarefaDao.getTarefas()
    }
}