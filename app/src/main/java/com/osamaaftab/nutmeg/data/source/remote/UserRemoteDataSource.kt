package com.osamaaftab.nutmeg.data.source.remote

import com.osamaaftab.nutmeg.data.service.UserServices
import com.osamaaftab.nutmeg.data.source.base.UserDataSource
import com.osamaaftab.nutmeg.domain.model.UserModel
import io.reactivex.rxjava3.core.Observable

class UserRemoteDataSource(private val userServices: UserServices) : UserDataSource {

    override fun getUser(albumId: String): Observable<UserModel> {
        return userServices.getUser(albumId)
    }
}