package com.osamaaftab.nutmeg.data.source.remote

import com.osamaaftab.nutmeg.data.service.AlbumServices
import com.osamaaftab.nutmeg.data.source.base.AlbumDataSource
import com.osamaaftab.nutmeg.domain.model.AlbumModel
import io.reactivex.rxjava3.core.Observable

class AlbumRemoteDataSource(private val albumServices: AlbumServices) : AlbumDataSource {
    override fun getAlbums(): Observable<List<AlbumModel>> {
        return albumServices.getAlbums()
    }
}