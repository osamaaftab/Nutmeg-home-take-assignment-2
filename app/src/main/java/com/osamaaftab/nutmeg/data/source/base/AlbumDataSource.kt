package com.osamaaftab.nutmeg.data.source.base

import com.osamaaftab.nutmeg.domain.model.AlbumModel
import io.reactivex.rxjava3.core.Observable

interface AlbumDataSource {
    fun getAlbums(): Observable<List<AlbumModel>>
}