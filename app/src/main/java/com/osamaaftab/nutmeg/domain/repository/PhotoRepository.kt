package com.osamaaftab.nutmeg.domain.repository

import com.osamaaftab.nutmeg.domain.model.PhotoModel
import io.reactivex.rxjava3.core.Observable

interface PhotoRepository {
    fun getPhoto(albumId: String): Observable<List<PhotoModel>>
}