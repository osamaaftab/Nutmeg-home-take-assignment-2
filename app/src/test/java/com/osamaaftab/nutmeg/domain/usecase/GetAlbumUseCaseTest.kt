package com.osamaaftab.nutmeg.domain.usecase

import com.osamaaftab.nutmeg.data.ErrorHandler
import com.osamaaftab.nutmeg.domain.model.AlbumModel
import com.osamaaftab.nutmeg.domain.repository.AlbumRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test
import junit.framework.TestCase.assertEquals

class GetAlbumUseCaseTest {

    @RelaxedMockK
    lateinit var albumRepository: AlbumRepository

    private lateinit var sut: GetAlbumUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        val errorHandler = mockk<ErrorHandler>()
        sut = GetAlbumUseCase(albumRepository, errorHandler)
    }

    @Test
    fun `buildUseCaseObservable THEN verify the album observable`() {
        val albumModel = mockk<Observable<AlbumModel>>(relaxed = true)
        every { albumRepository.getAlbum() } returns (albumModel)

        val album = sut.buildUseCaseObservable()

        assertEquals(albumModel, album)
    }
}