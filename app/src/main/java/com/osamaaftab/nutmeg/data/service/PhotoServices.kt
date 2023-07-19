package com.osamaaftab.nutmeg.data.service

import com.osamaaftab.nutmeg.domain.model.PhotoModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotoServices {

    @GET("albums/{albumId}/photos")
    fun getPhotos(
        @Path("albumId") albumId: String
    ): Observable<List<PhotoModel>>
}