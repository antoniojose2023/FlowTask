package br.com.devmobile.flowtask.datalocal

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TarefaDao {

    @Insert
    suspend fun salvar(tarefa: Tarefa): Long

    @Delete
    suspend fun delete(tarefa: Tarefa): Int

    @Update
    suspend fun atualizar(tarefa: Tarefa): Int

    @Query("SELECT * FROM tarefas")
    suspend fun getTarefas(): List<Tarefa>


}