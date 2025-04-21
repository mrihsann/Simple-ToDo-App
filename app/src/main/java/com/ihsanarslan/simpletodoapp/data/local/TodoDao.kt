package com.ihsanarslan.simpletodoapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert
    suspend fun insertTodo(todo: TodoEntity)

    @Query("SELECT * FROM Todos")
    fun getTodos(): Flow<List<TodoEntity>>

    @Query("DELETE FROM Todos WHERE id = :id")
    suspend fun deleteTodo(id: Int)

    @Query("SELECT * FROM Todos WHERE id = :id")
    fun getTodoById(id: Int): Flow<TodoEntity>

}