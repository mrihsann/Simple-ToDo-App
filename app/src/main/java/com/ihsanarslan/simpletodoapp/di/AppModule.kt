package com.ihsanarslan.simpletodoapp.di

import android.content.Context
import androidx.room.Room
import com.ihsanarslan.simpletodoapp.data.local.TodoDatabase
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
    fun provideTodoDao(database: TodoDatabase) {
        database.todoDao()
    }


}