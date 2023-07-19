package com.osamaaftab.nutmeg.data.repository

import com.osamaaftab.nutmeg.data.source.remote.PhotoRemoteDataSource
import com.osamaaftab.nutmeg.domain.model.PhotoModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.reactivex.rxjava3.core.Observable
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class PhotoRepositoryTest {

    @MockK
    lateinit var photoRemoteDataSource: PhotoRemoteDataSource
    private lateinit var sut: PhotoRepositoryImp

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        sut = PhotoRepositoryImp(photoRemoteDataSource)
    }


    @Test
    fun `getPhoto from remote data THEN verify the observable of Photo is returned is same`() {
        val listPhotoModel = mockk<Observable<List<PhotoModel>>>(relaxed = true)
        every { photoRemoteDataSource.getPhoto("albumId") } returns (listPhotoModel)

        val photo = sut.getPhoto("albumId")

        assertEquals(listPhotoModel, photo)
    }
}