package br.com.devmobile.flowtask.datalocal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Tarefa::class], version = 1)
abstract class DatabaseRoom: RoomDatabase() {

    abstract fun tarefaDao(): TarefaDao

    companion object{
       fun getInstance(context: Context): DatabaseRoom{
              return Room.databaseBuilder(
                      context,
                  DatabaseRoom::class.java,
                    "db_tarefa"
              ).build()
        }
    }
}