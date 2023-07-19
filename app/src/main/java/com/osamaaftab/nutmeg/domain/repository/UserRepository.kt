package com.osamaaftab.nutmeg.domain.repository

import com.osamaaftab.nutmeg.domain.model.UserModel
import io.reactivex.rxjava3.core.Observable

interface UserRepository {
    fun getUser(userId: String): Observable<UserModel>
}