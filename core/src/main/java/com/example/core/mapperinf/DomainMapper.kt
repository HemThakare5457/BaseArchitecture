package com.example.core.mapperinf

fun interface DomainMapper<T, R> {
    fun invoke(response: T): R
}