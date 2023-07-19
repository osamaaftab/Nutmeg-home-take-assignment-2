package com.osamaaftab.nutmeg.data.repository

import com.osamaaftab.nutmeg.data.source.remote.AlbumRemoteDataSource
import com.osamaaftab.nutmeg.domain.model.AlbumModel
import com.osamaaftab.nutmeg.domain.repository.PhotoRepository
import com.osamaaftab.nutmeg.domain.repository.UserRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test

class AlbumRepositoryTest {

    @MockK
    lateinit var albumRemoteDataSource: AlbumRemoteDataSource

    @MockK
    lateinit var userRepository: UserRepository

    @MockK
    lateinit var photoRepository: PhotoRepository

    private lateinit var sut: AlbumRepositoryImp


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        sut = AlbumRepositoryImp(albumRemoteDataSource, photoRepository, userRepository)
    }

    @Test
    fun `getAlbums from remote data source and getUser and getPhoto THEN verify if they are mapped to album object`() {
        val listAlbumModel = mockk<Observable<List<AlbumModel>>>(relaxed = true)

        every { albumRemoteDataSource.getAlbums() } returns (listAlbumModel)

        sut.getAlbum().blockingForEach {
            verify(exactly = 1) { photoRepository.getPhoto(it.id) }
            verify(exactly = 1) { userRepository.getUser(it.userId) }
        }
    }
}