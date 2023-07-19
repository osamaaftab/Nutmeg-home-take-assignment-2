package com.osamaaftab.nutmeg.data.source.base

import com.osamaaftab.nutmeg.domain.model.UserModel
import io.reactivex.rxjava3.core.Observable

interface UserDataSource {
     fun getUser(albumId: String): Observable<UserModel>
}