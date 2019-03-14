package com.dwiariyanto.testjakmall.base.mvp

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers

/**
 * Created by Dwi Ariyanto on 13/03/19.
 */

abstract class BaseLoadPresenter<VIEW : BaseLoadView>(
    view: VIEW
) : BasePresenter<VIEW>(view) {
    private val compositeDisposable = CompositeDisposable()

    override fun onViewCreated() {
        super.onViewCreated()
        hideAllViewAndDialog()
    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.clear()
    }

    fun <DATA> async(
        observable: Observable<DATA>,
        onError: ((Throwable) -> Unit)? = null,
        onComplete: (() -> Unit)? = null,
        onNext: ((DATA) -> Unit)? = null
    ): Disposable {
        return observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    onNext?.invoke(it)
                },
                {
                    onError?.invoke(it)
                },
                {
                    onComplete?.invoke()
                })
            .also {
                compositeDisposable += it
            }
    }

    fun <DATA> asyncWithLoadingView(
        pObservable: Observable<DATA>,
        pOnError: ((Throwable) -> Unit)? = null,
        pOnComplete: (() -> Unit)? = null,
        pOnNext: ((DATA) -> Unit)? = null
    ): Disposable {
        hideAllViewAndDialog()

        view.showLoadingView()

        return async(pObservable,
            onNext = {
                view.hideLoadingView()
                pOnNext?.invoke(it)
            },
            onError = {
                view.hideLoadingView()
                view.showErrorView(it.message ?: "Unknown error")
                pOnError?.invoke(it)
            },
            onComplete = {
                pOnComplete?.invoke()
            })
    }

    open fun <DATA> asyncWithLoadingDialog(
        pObservable: Observable<DATA>,
        pOnError: ((Throwable) -> Unit)? = null,
        pOnComplete: (() -> Unit)? = null,
        pOnNext: ((DATA) -> Unit)? = null
    ): Disposable {
        hideAllViewAndDialog()

        view.showLoadingDialog()

        return async(pObservable,
            onNext = {
                view.hideLoadingDialog()
                pOnNext?.invoke(it)
            },
            onError = {
                view.hideLoadingDialog()
                view.showErrorDialog(it.message ?: "Unknown error")
                pOnError?.invoke(it)
            },
            onComplete = {
                pOnComplete?.invoke()
            })
    }

    private fun hideAllViewAndDialog() {
        view.hideLoadingDialog()
        view.hideErrorDialog()

        view.hideLoadingView()
        view.hideErrorView()

        if (view is BaseLoadDataView<*>)
            (view as BaseLoadDataView<*>).hideDataView()

        if (view is BaseLoadDataWithEmptyView<*>)
            (view as BaseLoadDataWithEmptyView<*>).hideEmptyDataView()
    }
}