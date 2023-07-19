package com.osamaaftab.nutmeg.di.module

import com.osamaaftab.nutmeg.data.repository.AlbumRepositoryImp
import com.osamaaftab.nutmeg.data.repository.PhotoRepositoryImp
import com.osamaaftab.nutmeg.data.repository.UserRepositoryImp
import com.osamaaftab.nutmeg.data.source.remote.AlbumRemoteDataSource
import com.osamaaftab.nutmeg.data.source.remote.PhotoRemoteDataSource
import com.osamaaftab.nutmeg.data.source.remote.UserRemoteDataSource
import com.osamaaftab.nutmeg.domain.repository.AlbumRepository
import com.osamaaftab.nutmeg.domain.repository.PhotoRepository
import com.osamaaftab.nutmeg.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAlbumRepository(
        albumRemoteDataSource: AlbumRemoteDataSource,
        photoRepository: PhotoRepository,
        userRepository: UserRepository
    ): AlbumRepository {
        return AlbumRepositoryImp(albumRemoteDataSource, photoRepository, userRepository)
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        userRemoteDataSource: UserRemoteDataSource
    ): UserRepository {
        return UserRepositoryImp(userRemoteDataSource)
    }

    @Provides
    @Singleton
    fun providePhotoRepository(
        photoRemoteDataSource: PhotoRemoteDataSource
    ): PhotoRepository {
        return PhotoRepositoryImp(photoRemoteDataSource)
    }
}