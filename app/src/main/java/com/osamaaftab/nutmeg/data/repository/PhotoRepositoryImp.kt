package com.osamaaftab.nutmeg.data.repository

import com.osamaaftab.nutmeg.data.source.remote.PhotoRemoteDataSource
import com.osamaaftab.nutmeg.domain.model.PhotoModel
import com.osamaaftab.nutmeg.domain.repository.PhotoRepository
import io.reactivex.rxjava3.core.Observable

class PhotoRepositoryImp(private val photoRemoteDataSource: PhotoRemoteDataSource) :
    PhotoRepository {
    override fun getPhoto(albumId: String): Observable<List<PhotoModel>> {
        return photoRemoteDataSource.getPhoto(albumId)
    }
}