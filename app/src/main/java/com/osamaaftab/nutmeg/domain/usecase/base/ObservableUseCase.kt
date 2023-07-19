package com.osamaaftab.nutmeg.domain.usecase.base

import com.osamaaftab.nutmeg.data.ErrorHandler
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class ObservableUseCase<T : Any>(val errorHandle: ErrorHandler) : UseCase() {

    internal abstract fun buildUseCaseObservable(): Observable<T>

    fun execute(
        onResult: UseCaseResponse<T>
    ) {
        disposeLast()
        lastDisposable = buildUseCaseObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<T>() {
                override fun onNext(t: T) {
                    onResult.onSuccess(t)
                }

                override fun onError(e: Throwable) {
                    onResult.onError(errorHandle.traceErrorException(e))
                }

                override fun onComplete() {

                }
            })

        lastDisposable?.let {
            compositeDisposable.add(it)
        }
    }
}