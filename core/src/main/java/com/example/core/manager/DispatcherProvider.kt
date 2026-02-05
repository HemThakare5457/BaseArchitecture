package com.example.core.manager

import kotlinx.coroutines.CoroutineDispatcher

class DispatcherProvider(
    private val mainDispatcher: CoroutineDispatcher,
    private val ioDispatcher: CoroutineDispatcher
) {

    fun ioDispatcher() = ioDispatcher
    fun mainDispatcher() = mainDispatcher
}