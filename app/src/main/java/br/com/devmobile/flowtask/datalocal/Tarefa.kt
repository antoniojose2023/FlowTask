package br.com.devmobile.flowtask.datalocal

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tarefas")
data class Tarefa(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var titulo:String? = null,
    val descricao:String? = null,
    val data:String? = null,
    val hora:String? = null,
    val prioridade:String?= null,
): Serializable