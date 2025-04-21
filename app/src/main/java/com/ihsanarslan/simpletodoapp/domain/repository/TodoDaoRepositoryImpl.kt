package com.ihsanarslan.simpletodoapp.domain.repository

import com.ihsanarslan.simpletodoapp.data.local.TodoDao
import com.ihsanarslan.simpletodoapp.data.local.TodoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TodoDaoRepositoryImpl @Inject constructor(
    private val todoDao: TodoDao
) {

    suspend fun insertTodo(todo: TodoEntity) {
        todoDao.insertTodo(todo)
    }

    fun getTodos(): Flow<List<TodoEntity>> = flow {
        todoDao.getTodos().collect {
            emit(it)
        }
    }

    suspend fun deleteTodo(id: Int) {
        todoDao.deleteTodo(id)
    }

    fun getTodoById(id: Int): Flow<TodoEntity> = flow {
        todoDao.getTodoById(id).collect {
            emit(it)
        }
    }

}