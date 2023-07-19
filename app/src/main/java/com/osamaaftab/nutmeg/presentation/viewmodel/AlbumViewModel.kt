package com.osamaaftab.nutmeg.presentation.viewmodel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.osamaaftab.nutmeg.domain.model.AlbumModel
import com.osamaaftab.nutmeg.domain.model.ErrorModel
import com.osamaaftab.nutmeg.domain.usecase.GetAlbumUseCase
import com.osamaaftab.nutmeg.domain.usecase.base.UseCaseResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(private val getAlbumUseCase: GetAlbumUseCase) : ViewModel() {

    private val onProgressShowLiveData = MutableLiveData<Boolean>()

    private val onErrorShowLiveData = MutableLiveData<Boolean>()

    private val albumListLiveData = MutableLiveData<List<AlbumModel>>()

    private val albumList = mutableListOf<AlbumModel>()

    init {
        loadAlbumList()
    }

    fun getAlbumUseCaseResponse() = object : UseCaseResponse<AlbumModel> {
        override fun onSuccess(result: AlbumModel) {
            Log.i(ContentValues.TAG, "result: ${result.id}")
            albumList.add(result)
            onProgressShowLiveData.postValue(false)
            onErrorShowLiveData.postValue(false)
            albumListLiveData.postValue(albumList)
        }

        override fun onError(errorModel: ErrorModel?) {
            Log.i(ContentValues.TAG, "error status: ${errorModel?.errorStatus}")
            Log.i(ContentValues.TAG, "error message: ${errorModel?.message}")
            onProgressShowLiveData.postValue(false)
            onErrorShowLiveData.postValue(true)
        }
    }

    private fun loadAlbumList() {
        onProgressShowLiveData.postValue(true)
        getAlbumUseCase.execute(getAlbumUseCaseResponse())
    }

    fun getShowProgressLiveData(): LiveData<Boolean> {
        return onProgressShowLiveData
    }

    fun getShowErrorLiveData(): LiveData<Boolean> {
        return onErrorShowLiveData
    }

    fun getAlbumListLiveData(): LiveData<List<AlbumModel>> {
        return albumListLiveData
    }
}