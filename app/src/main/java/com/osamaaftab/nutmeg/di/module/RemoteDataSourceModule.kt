package com.osamaaftab.nutmeg.di.module

import com.osamaaftab.nutmeg.data.service.AlbumServices
import com.osamaaftab.nutmeg.data.service.PhotoServices
import com.osamaaftab.nutmeg.data.service.UserServices
import com.osamaaftab.nutmeg.data.source.remote.AlbumRemoteDataSource
import com.osamaaftab.nutmeg.data.source.remote.PhotoRemoteDataSource
import com.osamaaftab.nutmeg.data.source.remote.UserRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataSourceModule {

    @Provides
    @Singleton
    fun provideRemoteAlbumDataSource(
        albumServices: AlbumServices
    ): AlbumRemoteDataSource {
        return AlbumRemoteDataSource(albumServices)
    }

    @Provides
    @Singleton
    fun provideRemoteUserDataSource(
        userServices: UserServices
    ): UserRemoteDataSource {
        return UserRemoteDataSource(userServices)
    }

    @Provides
    @Singleton
    fun provideRemotePhotoDataSource(
        photoServices: PhotoServices
    ): PhotoRemoteDataSource {
        return PhotoRemoteDataSource(photoServices)
    }
}