package com.example.core.manager

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
class BackgroundOperationExecutor @Inject constructor(dispatcherProvider: DispatcherProvider) {
    private val coroutineScope = CoroutineScope(dispatcherProvider.ioDispatcher().limitedParallelism(1))

    fun performInBackGround(task : () -> Unit) {
        coroutineScope.launch {
            task()
        }
    }
}