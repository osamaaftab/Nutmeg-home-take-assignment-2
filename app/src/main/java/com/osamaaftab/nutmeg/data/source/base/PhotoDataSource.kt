package com.osamaaftab.nutmeg.data.source.base

import com.osamaaftab.nutmeg.domain.model.PhotoModel
import io.reactivex.rxjava3.core.Observable

interface PhotoDataSource {
     fun getPhoto(albumId: String): Observable<List<PhotoModel>>
}