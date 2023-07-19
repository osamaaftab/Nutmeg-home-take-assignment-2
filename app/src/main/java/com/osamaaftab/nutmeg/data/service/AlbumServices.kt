package com.osamaaftab.nutmeg.data.service

import com.osamaaftab.nutmeg.domain.model.AlbumModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface AlbumServices {
    @GET("albums")
    fun getAlbums(): Observable<List<AlbumModel>>
}