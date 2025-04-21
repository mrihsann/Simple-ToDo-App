package com.ihsanarslan.simpletodoapp.presentation.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ihsanarslan.simpletodoapp.data.local.TodoEntity
import com.ihsanarslan.simpletodoapp.domain.repository.TodoDaoRepositoryImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddScreenViewModel @Inject constructor(
    private val repository : TodoDaoRepositoryImpl
) : ViewModel(){

    fun insertTodo(todo: TodoEntity){
        viewModelScope.launch {
            repository.insertTodo(todo)
        }
    }

}