package com.osamaaftab.nutmeg.data.service

import com.osamaaftab.nutmeg.domain.model.UserModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface UserServices {

    @GET("users/{userId}")
    fun getUser(
        @Path("userId") userId: String
    ): Observable<UserModel>
}