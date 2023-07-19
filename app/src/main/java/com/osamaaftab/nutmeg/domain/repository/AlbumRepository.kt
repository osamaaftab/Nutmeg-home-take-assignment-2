package com.osamaaftab.nutmeg.domain.repository

import com.osamaaftab.nutmeg.domain.model.AlbumModel
import io.reactivex.rxjava3.core.Observable

interface AlbumRepository {
    fun getAlbum(): Observable<AlbumModel>
}