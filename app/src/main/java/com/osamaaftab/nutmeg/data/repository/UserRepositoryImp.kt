package com.osamaaftab.nutmeg.data.repository

import com.osamaaftab.nutmeg.data.source.remote.UserRemoteDataSource
import com.osamaaftab.nutmeg.domain.model.UserModel
import com.osamaaftab.nutmeg.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Observable

class UserRepositoryImp(private val userRemoteDataSource: UserRemoteDataSource) : UserRepository {
    override fun getUser(userId: String): Observable<UserModel> {
        return userRemoteDataSource.getUser(userId)
    }
}