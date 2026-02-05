package com.example.core.utils
import kotlinx.coroutines.CoroutineDispatcher

import kotlinx.coroutines.Dispatchers

fun getMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

fun getDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

fun getIoDispatcher(): CoroutineDispatcher = Dispatchers.IO