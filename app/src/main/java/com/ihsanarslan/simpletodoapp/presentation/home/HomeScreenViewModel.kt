package com.ihsanarslan.simpletodoapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ihsanarslan.simpletodoapp.data.local.TodoEntity
import com.ihsanarslan.simpletodoapp.domain.repository.TodoDaoRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository : TodoDaoRepositoryImpl
) : ViewModel(){

    private val _list = MutableStateFlow<List<TodoEntity>>(emptyList())
    val list : StateFlow<List<TodoEntity>>
        get() = _list.asStateFlow()

    init {
        getAllTodos()
    }

    fun getAllTodos(){
        viewModelScope.launch {
            repository.getTodos().collect { todoList ->
                _list.value = todoList
            }
        }
    }

}