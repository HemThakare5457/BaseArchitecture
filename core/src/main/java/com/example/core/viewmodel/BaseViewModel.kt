package com.example.core.viewmodel

import androidx.lifecycle.ViewModel
import com.example.core.dto.OperationResult
import com.example.core.manager.DispatcherProvider
import com.example.core.utils.getIoDispatcher
import com.example.core.utils.getMainDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel(private val dispatcher: DispatcherProvider = DispatcherProvider(getMainDispatcher(), getIoDispatcher())) :
ViewModel() {

    fun <T> OperationResult<T>.performAction(
        f1: () -> Unit,
        f2: (OperationResult.SuccessOperationResult<T>) -> Unit,
        f3: (OperationResult.ErrorOperationResult) -> Unit
    ) =
        when (this) {
            is OperationResult.Loading -> {
                f1()
            }
            is OperationResult.SuccessOperationResult -> {
                f2(this)
            }
            is OperationResult.ErrorOperationResult -> {
                f3(this)
            }
        }

    fun <T, P> OperationResult<T>.performActionWithLoadingParam(
        p: P,
        f1: () -> Unit,
        f2: (p: P, OperationResult.SuccessOperationResult<T>) -> Unit,
        f3: (p: P, OperationResult.ErrorOperationResult) -> Unit
    ) =
        when (this) {
            is OperationResult.Loading -> {
                f1()
            }
            is OperationResult.SuccessOperationResult -> {
                f2(p, this)
            }
            is OperationResult.ErrorOperationResult -> {
                f3(p, this)
            }
        }

    fun <T, P> OperationResult<T>.performActionWithParameter(
        p: P,
        f1: () -> Unit,
        f2: (p: P, OperationResult.SuccessOperationResult<T>) -> Unit,
        f3: (OperationResult.ErrorOperationResult) -> Unit
    ) =
        when (this) {
            is OperationResult.Loading -> {
                f1()
            }
            is OperationResult.SuccessOperationResult -> {
                f2(p, this)
            }
            is OperationResult.ErrorOperationResult -> {
                f3(this)
            }
        }

    fun doExecute(
        runInBgFun: suspend () -> Unit,
        coroutineScope: CoroutineScope
    ){
        coroutineScope.launch(dispatcher.mainDispatcher()) {
            withContext(dispatcher.ioDispatcher()){runInBgFun()}
        }
    }
}

enum class ViewState {
    Loading,
    Success,
    NoDataAvailable,
    Error
}
