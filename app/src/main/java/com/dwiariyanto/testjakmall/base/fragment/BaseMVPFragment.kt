package com.dwiariyanto.testjakmall.base.fragment

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import com.dwiariyanto.testjakmall.base.mvp.BaseLoadView
import com.dwiariyanto.testjakmall.base.mvp.BasePresenter
import com.dwiariyanto.testjakmall.factory.DialogFactory
import com.dwiariyanto.testjakmall.utils.gone
import com.dwiariyanto.testjakmall.utils.visible
import com.dwiariyanto.testjakmall.widget.dialog.type.DialogInterface
import com.dwiariyanto.testjakmall.widget.dialog.type.ErrorDialogInterface
import com.dwiariyanto.testjakmall.widget.view.`interface`.MessageViewInterface

/**
 * Created by Dwi Ariyanto on 13/03/19.
 */

abstract class BaseMVPFragment<PRESENTER : BasePresenter<*>> : BaseFragment(), BaseLoadView {
    protected val presenter: PRESENTER by lazy { createPresenter() }
    protected val loadView by lazy { setupForLoadView() }

    abstract fun createPresenter(): PRESENTER
    abstract fun setupForLoadView(): LoadView

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        lifecycle.addObserver(presenter)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    private var loadingDialog: AlertDialog? = null
    override fun showLoadingDialog() {
        loadView.loadingDialog?.show()
    }

    override fun hideLoadingDialog() {
        loadView.loadingDialog?.dismiss()
    }

    override fun showErrorDialog(message: String) {
        loadView.errorDialog?.run {
            if (this is ErrorDialogInterface)
                updateMessage(message)
            show()
        }
    }

    override fun hideErrorDialog() {
        loadView.errorDialog?.dismiss()
    }

    override fun showLoadingView() {
        loadView.loadingView?.visible()
    }

    override fun hideLoadingView() {
        loadView.loadingView?.gone()
    }

    override fun showErrorView(message: String) {
        loadView.errorView?.run {
            if (this is MessageViewInterface)
                setMessage(message)
            visible()
        }
    }

    override fun hideErrorView() {
        loadView.errorView?.gone()
    }

    override fun showToast(message: String) {
        toast(message)
    }

    sealed class LoadView(
        val loadingDialog: DialogInterface? = null,
        val errorDialog: DialogInterface? = null,
        val loadingView: View? = null,
        val errorView: View? = null
    ) {
        class DefaultLoadView(context: Context, loadingView: View? = null, errorView: View? = null) : LoadView(
            DialogFactory.create(context, DialogFactory.Type.LoadingDialogType()),
            DialogFactory.create(context, DialogFactory.Type.ErrorDialogType("")),
            loadingView,
            errorView
        )
    }
}