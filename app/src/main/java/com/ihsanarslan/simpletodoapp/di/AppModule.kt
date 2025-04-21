package com.ihsanarslan.simpletodoapp.di

import android.content.Context
import androidx.room.Room
import com.ihsanarslan.simpletodoapp.data.local.TodoDao
import com.ihsanarslan.simpletodoapp.data.local.TodoDatabase
import com.ihsanarslan.simpletodoapp.domain.repository.TodoDaoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): TodoDatabase {
        return Room.databaseBuilder(
            appContext,
            TodoDatabase::class.java,
            "tododb"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoDao(database: TodoDatabase) : TodoDao {
        return database.todoDao()
    }

    @Provides
    @Singleton
    fun provideTodoDaoRepositoryImpl(todoDao: TodoDao) : TodoDaoRepositoryImpl {
        return TodoDaoRepositoryImpl(todoDao)
    }


}