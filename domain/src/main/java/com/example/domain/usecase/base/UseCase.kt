package com.example.domain.usecase.base


import com.example.core.dto.OperationResult
import com.example.core.dto.Result
import com.example.core.manager.CoroutinesManager
import com.example.core.manager.DispatcherProvider
import com.example.core.mapper.DomainMapper
import com.example.core.model.BaseModel
import kotlinx.coroutines.*

abstract class UseCase(
    val dispatcherProvider: DispatcherProvider,
) {

    fun <T> execute(
        runInBgFun: Function0<OperationResult<T>>,
        coroutineScope: CoroutineScope
    ): Result<OperationResult<T>> {
        return CoroutinesManager(
            dispatcherProvider.mainDispatcher(),
            dispatcherProvider.ioDispatcher()
        ).execute(
            runInBgFun,
            coroutineScope
        )
    }

    fun <P : BaseModel, T> execute(
        p: P, runInBgFun: Function1<P, OperationResult<T>>,
        coroutineScope: CoroutineScope
    ): Result<OperationResult<T>> {
        return CoroutinesManager(
            dispatcherProvider.mainDispatcher(),
            dispatcherProvider.ioDispatcher()
        ).execute(p, runInBgFun, coroutineScope)
    }

    suspend fun <T> executeSuspend(
        suspendFun: suspend () -> T
    ): T {
        return CoroutinesManager(
            dispatcherProvider.mainDispatcher(),
            dispatcherProvider.ioDispatcher()
        ).executeSuspend{ suspendFun()}.await()
    }

    fun <T, T1, T2> executesAndCombine(
        runInBgFun1: Function0<OperationResult<T1>>,
        runInBgFun2: Function0<OperationResult<T2>>,
        combine: (OperationResult<T1>, OperationResult<T2>) -> OperationResult<T>,
        coroutineScope: CoroutineScope
    ): Result<OperationResult<T>> {
        return CoroutinesManager(
            dispatcherProvider.mainDispatcher(),
            dispatcherProvider.ioDispatcher()
        ).executesAndCombine(
            runInBgFun1,
            runInBgFun2,
            combine,
            coroutineScope
        )
    }

    fun <T1, T2, T3, T4, T5, R> executesAndCombine(
        runInBgFun1: Function0<OperationResult<T1>>,
        runInBgFun2: Function0<OperationResult<T2>>,
        runInBgFun3: Function0<OperationResult<T3>>,
        runInBgFun4: Function0<OperationResult<T4>>,
        runInBgFun5: Function0<OperationResult<T5>>,
        combine: (OperationResult<T1>, OperationResult<T2>, OperationResult<T3>, OperationResult<T4>, OperationResult<T5>) -> OperationResult<R>,
        coroutineScope: CoroutineScope
    ): Result<OperationResult<R>> {
        return CoroutinesManager(
            dispatcherProvider.mainDispatcher(),
            dispatcherProvider.ioDispatcher()
        ).executesAndCombine(
            runInBgFun1,
            runInBgFun2,
            runInBgFun3,
            runInBgFun4,
            runInBgFun5,
            combine,
            coroutineScope
        )
    }

    fun <T> executeSuspend(
        suspendFun: suspend () -> OperationResult<T>,
        coroutineScope: CoroutineScope
    ): Result<OperationResult<T>> {
        return CoroutinesManager(
            dispatcherProvider.mainDispatcher(),
            dispatcherProvider.ioDispatcher()
        ).executeSuspend(
            suspendFun,
            coroutineScope
        )
    }

    fun executeSuspendOperation(
        suspendFun: suspend () -> Unit,
        coroutineScope: CoroutineScope
    ){
        CoroutinesManager(
            dispatcherProvider.mainDispatcher(),
            dispatcherProvider.ioDispatcher()
        ).executeSuspendOperation(
            suspendFun,
            coroutineScope
        )
    }

    fun executeSuspendOperationOnIO(
        suspendFun: suspend () -> Unit,
        coroutineScope: CoroutineScope
    ){
        CoroutinesManager(
            dispatcherProvider.mainDispatcher(),
            dispatcherProvider.ioDispatcher()
        ).executeSuspendOnIOOperation(
            suspendFun,
            coroutineScope
        )
    }

    suspend fun <T> executeSuspendOperationOnIOWithResult(
        suspendFun: suspend () -> OperationResult<T>
    ): OperationResult<T> {
        return CoroutinesManager(
            dispatcherProvider.mainDispatcher(),
            dispatcherProvider.ioDispatcher()
        ).executeSuspendOnIO(
            suspendFun
        )
    }

    fun <Domain, Data> OperationResult<Data>.transform(
        mapper: DomainMapper<Data, Domain>
    ): OperationResult<Domain> {
        return when (this) {
            is OperationResult.Loading -> {
                this
            }
            is OperationResult.SuccessOperationResult -> {
                this.copy(mapper(this.result))
            }
            is OperationResult.ErrorOperationResult -> {
                this
            }
        }
    }

    fun <Domain, Data> OperationResult<Data>.map(
        map: (Data) -> Domain
    ): OperationResult<Domain> {
        return when (this) {
            is OperationResult.Loading -> {
                this
            }
            is OperationResult.SuccessOperationResult -> {
                this.copy(map(this.result))
            }
            is OperationResult.ErrorOperationResult -> {
                this
            }
        }
    }

    fun <Domain> OperationResult<Domain>.transformErrorToSuccess(
        map: (OperationResult.ErrorOperationResult) -> Domain?
    ): OperationResult<Domain> {
        return when (this) {
            is OperationResult.Loading -> {
                this
            }
            is OperationResult.SuccessOperationResult -> {
                this
            }
            is OperationResult.ErrorOperationResult -> {
                val result = map(this)
                result?.let {
                    OperationResult.SuccessOperationResult(it)
                } ?: this
            }
        }
    }
}