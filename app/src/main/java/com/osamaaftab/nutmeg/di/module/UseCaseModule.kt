package com.osamaaftab.nutmeg.di.module

import com.osamaaftab.nutmeg.data.ErrorHandler
import com.osamaaftab.nutmeg.domain.repository.AlbumRepository
import com.osamaaftab.nutmeg.domain.usecase.GetAlbumUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetAlbumUseCase(
        questionRepository: AlbumRepository,
        errorHandle: ErrorHandler,
    ): GetAlbumUseCase {
        return GetAlbumUseCase(questionRepository, errorHandle)
    }
}