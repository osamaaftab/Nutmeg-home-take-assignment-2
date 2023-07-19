package com.osamaaftab.nutmeg.domain.usecase

import com.osamaaftab.nutmeg.data.ErrorHandler
import com.osamaaftab.nutmeg.domain.model.AlbumModel
import com.osamaaftab.nutmeg.domain.repository.AlbumRepository
import com.osamaaftab.nutmeg.domain.usecase.base.ObservableUseCase
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetAlbumUseCase @Inject constructor(
    private val albumRepository: AlbumRepository,
    errorHandle: ErrorHandler
) : ObservableUseCase<AlbumModel>(errorHandle) {

    override fun buildUseCaseObservable(): Observable<AlbumModel> {
        return albumRepository.getAlbum()
    }
}
