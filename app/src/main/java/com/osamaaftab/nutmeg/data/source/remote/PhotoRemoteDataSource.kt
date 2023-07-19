package com.osamaaftab.nutmeg.data.source.remote

import com.osamaaftab.nutmeg.data.service.PhotoServices
import com.osamaaftab.nutmeg.data.source.base.PhotoDataSource
import com.osamaaftab.nutmeg.domain.model.PhotoModel
import io.reactivex.rxjava3.core.Observable

class PhotoRemoteDataSource(private val photoServices: PhotoServices) : PhotoDataSource {
    override fun getPhoto(albumId: String): Observable<List<PhotoModel>> {
        return photoServices.getPhotos(albumId)
    }
}