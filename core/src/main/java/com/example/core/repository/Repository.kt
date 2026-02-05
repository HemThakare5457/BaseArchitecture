package com.example.core.repository


import com.example.core.dto.ErrorResult
import com.example.core.dto.OperationResult
import com.example.core.manager.DispatcherProvider
import com.example.core.mapper.DomainMapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

private const val TAG = "Repository"
abstract class Repository{


    companion object {
        @Suppress("unused")
        fun performInBackGround(task : () -> Unit, dispatcherProvider: DispatcherProvider) {
            val coroutineScope = CoroutineScope(dispatcherProvider.ioDispatcher())
            coroutineScope.launch {
                task()
            }
        }

        fun performActionWithJob(task : suspend () -> Unit, dispatcherProvider: DispatcherProvider): Job {
            val coroutineScope = CoroutineScope(dispatcherProvider.ioDispatcher())
            return coroutineScope.launch {
             //   Logger.v(TAG, "start Delay task")
                task()
             //   Logger.v(TAG, "end Delay task")
            }
        }
    }

    fun <Domain, Data> OperationResult<Data>.transform(
        mapper: DomainMapper<Data, Domain>
    ): OperationResult<Domain> {
        return when (this) {
            is OperationResult.Loading -> {
                this
            }
            is OperationResult.SuccessOperationResult -> {
                this.copy(r = mapper(this.result))
            }
            is OperationResult.ErrorOperationResult -> {
                this
            }
        }
    }
    fun <Domain, Data> OperationResult<Data>.transform(
        mapper: com.example.core.mapperinf.DomainMapper<Data, Domain>
    ): OperationResult<Domain> {
        return when (this) {
            is OperationResult.Loading -> {
                this
            }
            is OperationResult.SuccessOperationResult -> {
                this.copy(r = mapper.invoke(this.result))
            }
            is OperationResult.ErrorOperationResult -> {
                this
            }
        }
    }

    fun <Domain, Data> OperationResult<Data>.transform(
        filter: (Data) -> Data,
        mapper: DomainMapper<Data, Domain>
    ): OperationResult<Domain> {
        return when (this) {
            is OperationResult.Loading -> {
                this
            }
            is OperationResult.SuccessOperationResult -> {
                this.copy(r = mapper(filter(this.result)))
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
                this.copy(r = map(this.result))
            }
            is OperationResult.ErrorOperationResult -> {
                this
            }
        }
    }

    fun <Domain, Business, Data> OperationResult<Data>.map(
        map: (Domain) -> Business,
        mapper: DomainMapper<Data, Domain>
    ): OperationResult<Business> {
        return when (this) {
            is OperationResult.Loading -> {
                this
            }
            is OperationResult.SuccessOperationResult -> {
                this.copy(r = map(mapper(this.result)))
            }
            is OperationResult.ErrorOperationResult -> {
                this
            }
        }
    }

    @Suppress("unused")
    fun <Domain, Data> OperationResult<Data>.transformWithAction(
        action: (Domain) -> Unit,
        mapper: DomainMapper<Data, Domain>
    ): OperationResult<Domain> {
        return when (this) {
            is OperationResult.Loading -> {
                this
            }
            is OperationResult.SuccessOperationResult -> {
                val domainResult  = mapper(this.result)
                this.copy(r = domainResult).also { action(domainResult) }
            }
            is OperationResult.ErrorOperationResult -> {
                this
            }
        }
    }

    @Suppress("unused")
    fun <Domain, Data> OperationResult<Data>.action(
        action: (Data) -> Domain,
    ): OperationResult<Domain> {
        return when (this) {
            is OperationResult.Loading -> {
                this
            }
            is OperationResult.SuccessOperationResult -> {
                val domainResult  = action(this.result)
                this.copy(r = domainResult)
            }
            is OperationResult.ErrorOperationResult -> {
                this
            }
        }
    }

    @Suppress("unused")
    fun <Actual, Convert, Data, Domain> OperationResult<Convert>.convertAndTransform(
        actual: Actual,
        convert: (Actual, Convert) -> Data,
        mapper: DomainMapper<Data, Domain>
    ): OperationResult<Domain> {
        return when (this) {
            is OperationResult.Loading -> {
                this
            }
            is OperationResult.SuccessOperationResult -> {
                this.copy(r = mapper(convert(actual, this.result)))
            }
            is OperationResult.ErrorOperationResult -> {
                this
            }
        }
    }

    fun <Data1, Data2, Data3> OperationResult<Data2>.combineResult(
        data1: Data1,
        combine: (Data1,Data2) -> Data3,
    ): OperationResult<Data3> {
        return when (this) {
            is OperationResult.Loading -> {
                this
            }
            is OperationResult.SuccessOperationResult -> {
                this.copy(r = combine.invoke(data1, this.result))
            }
            is OperationResult.ErrorOperationResult -> {
                this
            }
        }
    }

    fun <Domain> OperationResult<Domain>.getCache(cache: () -> OperationResult<Domain>?): OperationResult<Domain> {
        return when (this) {
            is OperationResult.Loading -> {
                this
            }
            is OperationResult.SuccessOperationResult -> {
                this
            }
            is OperationResult.ErrorOperationResult -> {
                cache() ?: this
            }
        }
    }

    infix fun <T, U> OperationResult<T>.then(f: (T) -> OperationResult<U>) =
        when (this) {
            is OperationResult.SuccessOperationResult -> f(this.result)
            is OperationResult.ErrorOperationResult -> this
            else -> OperationResult.ErrorOperationResult(ErrorResult.getError(ErrorResult.SOME_THING_WENT_WRONG))
        }
}