package com.osamaaftab.nutmeg.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.osamaaftab.nutmeg.data.ErrorHandler
import com.osamaaftab.nutmeg.domain.model.AlbumModel
import com.osamaaftab.nutmeg.domain.usecase.GetAlbumUseCase
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue

class AlbumViewModelTest {

    @RelaxedMockK
    lateinit var getAlbumUseCase: GetAlbumUseCase

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var sut: AlbumViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        sut = AlbumViewModel(getAlbumUseCase)
    }

    @Test
    fun `getAlbumOnSuccess WHEN album is provided THEN verify progress bar live data value is false and album list posts to live data contains the latest album`() {
        val albumModel = mockk<AlbumModel>(relaxed = true)

        sut.getAlbumUseCaseResponse().onSuccess(albumModel)

        val response = sut.getAlbumListLiveData().value
        val state = sut.getShowProgressLiveData().value

        assertEquals(false, state)
        assertTrue(response!!.contains(albumModel))
    }

    @Test
    fun `getAlbumOnError WHEN error is provided THEN verify progress bar live data value is false and error live data value is true`() {
        val errorHandler = ErrorHandler()
        val throwable = mockk<Throwable>()
        errorHandler.traceErrorException(throwable)

        sut.getAlbumUseCaseResponse()
            .onError(errorHandler.traceErrorException(throwable))

        val state = sut.getShowProgressLiveData().value
        val drawable = sut.getShowErrorLiveData().value
        assertEquals(true, drawable)
        assertEquals(false, state)
    }

    @Test
    fun `loadAlbumList WHEN album view model is initialised THEN verify progress bar live data value is true and execute is called`() {
        val state = sut.getShowProgressLiveData().value
        assertEquals(true, state)
        verify(exactly = 1) { getAlbumUseCase.execute(any()) }
    }
}