package com.osamaaftab.nutmeg.data.repository

import com.osamaaftab.nutmeg.data.source.remote.AlbumRemoteDataSource
import com.osamaaftab.nutmeg.domain.model.AlbumModel
import com.osamaaftab.nutmeg.domain.repository.AlbumRepository
import com.osamaaftab.nutmeg.domain.repository.PhotoRepository
import com.osamaaftab.nutmeg.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Observable

class AlbumRepositoryImp(
    private val albumRemoteDataSource: AlbumRemoteDataSource,
    private val photoRepository: PhotoRepository,
    private val userRepository: UserRepository
) : AlbumRepository {

    override fun getAlbum(): Observable<AlbumModel> {
        return albumRemoteDataSource.getAlbums()
            .flatMap { Observable.fromIterable(it) }
            .concatMap { albumModel -> getAndMapUser(albumModel) }
            .concatMap { albumMode -> getAndMapPhoto(albumMode) }
    }

    private fun getAndMapUser(albumModel: AlbumModel): Observable<AlbumModel> {
        return userRepository.getUser(albumModel.userId)
            .map {
                albumModel.apply {
                    userName = it.userName
                }
            }
    }

    private fun getAndMapPhoto(albumModel: AlbumModel): Observable<AlbumModel> {
        return photoRepository.getPhoto(albumModel.id)
            .map {
                albumModel.apply {
                    photoTitle = it.first().title
                    thumbNail = it.first().thumbnailUrl
                }
            }
    }
}