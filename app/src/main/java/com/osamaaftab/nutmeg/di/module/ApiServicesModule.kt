package com.osamaaftab.nutmeg.di.module

import com.osamaaftab.nutmeg.data.service.AlbumServices
import com.osamaaftab.nutmeg.data.service.PhotoServices
import com.osamaaftab.nutmeg.data.service.UserServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiServicesModule {

    @Provides
    @Singleton
     fun provideAlbumService(retrofit: Retrofit): AlbumServices {
        return retrofit.create(AlbumServices::class.java)
    }

    @Provides
    @Singleton
     fun provideUsersService(retrofit: Retrofit): UserServices {
        return retrofit.create(UserServices::class.java)
    }

    @Provides
    @Singleton
     fun providePhotosService(retrofit: Retrofit): PhotoServices {
        return retrofit.create(PhotoServices::class.java)
    }
}
