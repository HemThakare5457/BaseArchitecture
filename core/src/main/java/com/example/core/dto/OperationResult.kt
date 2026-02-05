package com.example.core.dto

import com.example.core.dto.ErrorResult.Companion.SOME_THING_WENT_WRONG
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Result<R> (r: R) {
    private val mutStateFlow = MutableStateFlow(r)
    val stateFlow: StateFlow<R> = mutStateFlow

    suspend fun emit(opInBetween: R) {
        mutStateFlow.emit(opInBetween)
    }
}

sealed class OperationResult<out T> {
    abstract fun <R> copy(r: R): OperationResult<R>

    data class Loading(val isLoadingRequired: Boolean = true) : OperationResult<Nothing>() {
        override fun <R> copy(r: R): OperationResult<R> {
            return Loading()
        }
    }

    data class SuccessOperationResult<T>(val result: T) : OperationResult<T>() {
        override fun <R> copy(r: R): OperationResult<R> {
            return SuccessOperationResult(r)
        }
    }

    data class ErrorOperationResult (var error: ErrorResult) : OperationResult<Nothing>() {
        override fun <R> copy(r: R): OperationResult<R> {
            return ErrorOperationResult(error)
        }
    }

    fun isLoading(): Loading? {
        return when (this) {
            is Loading -> {
                this
            }
            is SuccessOperationResult -> {
                null
            }
            is ErrorOperationResult -> {
                null
            }
        }
    }

    fun isSuccess(): SuccessOperationResult<out T>? {
        return when (this) {
            is Loading -> {
                null
            }
            is SuccessOperationResult -> {
                this
            }
            is ErrorOperationResult -> {
                null
            }
        }
    }

    fun getErrorResult(): ErrorOperationResult {
        return when (this) {
            is ErrorOperationResult -> {
                this
            }
            else -> {
                ErrorOperationResult(ErrorResult.getError(SOME_THING_WENT_WRONG))
            }
        }
    }

    fun isError(): ErrorOperationResult? {
        return when (this) {
            is Loading -> {
                null
            }
            is SuccessOperationResult -> {
                null
            }
            is ErrorOperationResult -> {
                this
            }
        }
    }

    fun getErrorDetails(): ErrorResult {
        val error = ErrorResult.getError(SOME_THING_WENT_WRONG)
        return when (this) {
            is Loading -> {
                error
            }
            is SuccessOperationResult -> {
                error
            }
            is ErrorOperationResult -> {
                this.error
            }
        }
    }

}