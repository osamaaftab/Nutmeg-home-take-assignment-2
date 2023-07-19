package com.osamaaftab.nutmeg.di.module

import com.osamaaftab.nutmeg.data.ErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideErrorHandler(): ErrorHandler {
        return ErrorHandler()
    }

}