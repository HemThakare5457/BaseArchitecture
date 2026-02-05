package com.example.core.manager

import com.example.core.dto.OperationResult
import com.example.core.dto.Result
import com.example.core.model.BaseModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class CoroutinesManager(private val mainDispatcher: CoroutineDispatcher, private val ioDispatcher:
CoroutineDispatcher) {

    private val coroutineScope = CoroutineScope(ioDispatcher)

    interface PerformTask<T> {
        fun performInBackground()
        fun performedInForeGround(op: OperationResult<T>)
    }

    fun <T> execute(
        runInBgFun: Function0<OperationResult<T>>,
        coroutineScope: CoroutineScope
    ): Result<OperationResult<T>> {
        val outcome = Result<OperationResult<T>>(OperationResult.Loading())
        val performTask = object : PerformTask<T> {
            override fun performInBackground() {
                coroutineScope.launch(mainDispatcher) {
                    val result = async(ioDispatcher) { runInBgFun() }
                    performedInForeGround(result.await())
                }
            }

            override fun performedInForeGround(op: OperationResult<T>) {
                setResult(outcome, op, coroutineScope)
            }
        }
        performTask.performInBackground()
        return outcome
    }

    suspend fun <T> execute(
        runInBgFun: Function0<T>
    ) =
        withContext(mainDispatcher) {
            async(ioDispatcher) { runInBgFun() }
        }

    suspend fun <T> executeSuspend(
        suspendFun: suspend () -> T
    ) =
        withContext(mainDispatcher) {
            async(ioDispatcher) { suspendFun() }
        }

    fun <T, T1, T2> executesAndCombine(
        runInBgFun1: Function0<OperationResult<T1>>,
        runInBgFun2: Function0<OperationResult<T2>>,
        combine: (OperationResult<T1>, OperationResult<T2>) -> OperationResult<T>,
        coroutineScope: CoroutineScope
    ): Result<OperationResult<T>> {
        val outcome = Result<OperationResult<T>>(OperationResult.Loading())
        val performTask = object : PerformTask<T> {
            override fun performInBackground() {
                coroutineScope.launch(mainDispatcher) {
                    val result1 = async(ioDispatcher) { runInBgFun1() }
                    val result2 = async(ioDispatcher) { runInBgFun2() }
                    val op1 = result1.await()
                    val op2 = result2.await()
                    val result3 = async(ioDispatcher) { combine(op1, op2) }
                    performedInForeGround(result3.await())
                }
            }

            override fun performedInForeGround(op: OperationResult<T>) {
                setResult(outcome, op, coroutineScope)
            }
        }
        performTask.performInBackground()
        return outcome
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
        val outcome = Result<OperationResult<R>>(OperationResult.Loading())
        val performTask = object : PerformTask<R> {
            override fun performInBackground() {
                coroutineScope.launch(mainDispatcher) {
                    val result1 = async(ioDispatcher) { runInBgFun1() }
                    val result2 = async(ioDispatcher) { runInBgFun2() }
                    val result3 = async(ioDispatcher) { runInBgFun3() }
                    val result4 = async(ioDispatcher) { runInBgFun4() }
                    val result5 = async(ioDispatcher) { runInBgFun5() }
                    val op1 = result1.await()
                    val op2 = result2.await()
                    val op3 = result3.await()
                    val op4 = result4.await()
                    val op5 = result5.await()
                    val result = async(ioDispatcher) { combine(op1, op2, op3, op4, op5) }
                    performedInForeGround(result.await())
                }
            }

            override fun performedInForeGround(op: OperationResult<R>) {
                setResult(outcome, op, coroutineScope)
            }
        }
        performTask.performInBackground()
        return outcome
    }

    fun <P : BaseModel, T> execute(
        p: P,
        runInBgFun: Function1<P, OperationResult<T>>,
        coroutineScope: CoroutineScope
    ): Result<OperationResult<T>> {
        val outcome = Result<OperationResult<T>>(OperationResult.Loading())
        val performTask = object : PerformTask<T> {
            override fun performInBackground() {
                coroutineScope.launch(mainDispatcher) {
                    val result = async(ioDispatcher) { runInBgFun(p) }
                    performedInForeGround(result.await())
                }
            }

            override fun performedInForeGround(op: OperationResult<T>) {
                setResult(outcome, op, coroutineScope)
            }
        }
        performTask.performInBackground()
        return outcome
    }

    fun <T> executeSuspend(
        runInBgFun: suspend () -> OperationResult<T>,
        coroutineScope: CoroutineScope
    ): Result<OperationResult<T>> {
        val outcome = Result<OperationResult<T>>(OperationResult.Loading())
        val performTask = object : PerformTask<T> {
            override fun performInBackground() {
                coroutineScope.launch(mainDispatcher) {
                    val result = async{ runInBgFun() }
                    performedInForeGround(result.await())
                }
            }

            override fun performedInForeGround(op: OperationResult<T>) {
                setResult(outcome, op, coroutineScope)
            }
        }
        performTask.performInBackground()
        return outcome
    }

    fun executeSuspendOperation(
        runInBgFun: suspend () -> Unit,
        coroutineScope: CoroutineScope
    ){
        coroutineScope.launch{
            runInBgFun()
        }
    }

    fun executeSuspendOnIOOperation(
        runInBgFun: suspend () -> Unit,
        coroutineScope: CoroutineScope
    ){
        coroutineScope.launch(ioDispatcher){
            runInBgFun()
        }
    }

    fun <T> setResult(
        outcome: Result<OperationResult<T>>,
        opInBetween: OperationResult<T>,
        coroutineScope: CoroutineScope
    ) {
        coroutineScope.launch {
            outcome.emit(opInBetween)
        }
    }

    fun executeBackGroundOperation(function: () -> Unit) {
        coroutineScope.launch(ioDispatcher) {
            function()
        }
    }

    suspend fun <T> executeSuspendOnIO(
        runInBgFun: suspend () -> OperationResult<T>
    ): OperationResult<T> {
        return withContext(Dispatchers.IO) {
            // perform network request to fetch data
            val result = runInBgFun()
            return@withContext result
        }
    }
}
