package com.osamaaftab.nutmeg.data.repository

import com.osamaaftab.nutmeg.data.source.remote.UserRemoteDataSource
import com.osamaaftab.nutmeg.domain.model.UserModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test
import junit.framework.TestCase.assertEquals

class UserRepositoryTest {

    @MockK
    lateinit var userRemoteDataSource: UserRemoteDataSource

    private lateinit var sut: UserRepositoryImp

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        sut = UserRepositoryImp(userRemoteDataSource)
    }

    @Test
    fun `getUser from remote data THEN verify the observable which is returned  is same`() {
        val userModel = mockk<Observable<UserModel>>(relaxed = true)
        every { userRemoteDataSource.getUser("userId") } returns (userModel)

        val user = sut.getUser("userId")

        assertEquals(userModel, user)
    }

}